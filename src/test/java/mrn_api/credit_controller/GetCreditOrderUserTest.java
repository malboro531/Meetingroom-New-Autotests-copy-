package mrn_api.credit_controller;

import api.models.controllers.AllCreditOrdersModel;
import api.models.controllers.CreditModel;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_ORDER_BY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditOrderUserTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrderModel;
    private String creditProductId;
    private CreditModel creditProduct;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(USER);

        creditProductId = creditProductApiStep.getAllActiveCreditProducts(0, 100, Strings.EMPTY)
                .body().getContent().get(0).getId();
        creditProduct = creditProductApiStep.getCreditProductById(creditProductId).body();
        creditOrderModel = FakeGenerator.generateFakeCreditOrder();
        creditOrderModel.setOwnerId(userId);
        creditOrderModel.setLoanRate(creditProduct.getLoanRate());
        creditOrderModel.setAmount(creditProduct.getMinSum());
        creditOrderModel.setTempCredit(creditProduct.getMultiplicityOfTemp());
        creditOrderModel.setCreditProductId(creditProductId);
    }

    @TestRails(id = "C6230068")
    @Test(description = "Get credit order by id, role - User", groups = {"Api"})
    public void c6230068() {
        Response<CreditOrderModel> responseCreate = creditOrderApiStep.createCreditOrder(creditOrderModel);
        checkResponseCode(responseCreate, HTTP_OK);
        Response<CreditOrderModel> response = creditOrderApiStep.getCreditOrderById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
        creditOrderDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_ORDER_BY_ID,
                responseCreate.body().getId());
    }

    @TestRails(id = "C6230072")
    @Test(description = "Get all credit orders by owner id, role - User", groups = {"Api"})
    public void c6230072() {
        Response<AllCreditOrdersModel> response = creditOrderApiStep
                .getAllCreditOrdersByOwnerId(userId, 0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditOrderApiStep.checkAllCreditOrders(creditOrderDataBaseManager.getCountAllByOwnerId(userId),
                response.body().getContent().size());
        checkAll();
    }
}
