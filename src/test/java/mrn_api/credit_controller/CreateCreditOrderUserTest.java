package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditModel;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_ORDER_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDER_BY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateCreditOrderUserTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrderModel;
    private CreditOrderModel invalidCreditOrderModel;
    private String creditProductId;
    private CreditModel creditProduct;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(USER);

        creditProductId = creditProductApiStep
                .getAllActiveCreditProducts(0, 100, Strings.EMPTY).body().getContent().get(0).getId();
        creditProduct = creditProductApiStep.getCreditProductById(creditProductId).body();

        creditOrderModel = FakeGenerator.generateFakeCreditOrder();
        creditOrderModel.setOwnerId(userId);
        creditOrderModel.setLoanRate(creditProduct.getLoanRate());
        creditOrderModel.setAmount(creditProduct.getMinSum());
        creditOrderModel.setTempCredit(creditProduct.getMultiplicityOfTemp());
        creditOrderModel.setCreditProductId(creditProductId);

        invalidCreditOrderModel = SerializationUtils.clone(creditOrderModel);
        invalidCreditOrderModel.setCreditProductId(FakeGenerator.getRandomString());
    }

    @TestRails(id = "C6100037")
    @Test(description = "Create credit order, valid data, role - User", groups = {"Api"})
    public void c6100037() {
        Response<CreditOrderModel> response = creditOrderApiStep.createCreditOrder(creditOrderModel);
        checkResponseCode(response, HTTP_OK);
        CreditOrderModel creditOrderModelSQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class);
        creditOrderApiStep.checkCreditOrderInDataBase(response.body(), creditOrderModelSQL);
        checkAll();
        creditOrderDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_ORDER_BY_ID, response.body().getId());
    }

    @TestRails(id = "C6100039")
    @Test(description = "Create credit order with invalid credit product id, role - User", groups = {"Api"})
    public void c6100039() {
        Response<CreditOrderModel> response = creditOrderApiStep.createCreditOrder(invalidCreditOrderModel);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
