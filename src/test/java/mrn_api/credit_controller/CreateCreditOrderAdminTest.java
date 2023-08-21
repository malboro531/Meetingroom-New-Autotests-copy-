package mrn_api.credit_controller;

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

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class CreateCreditOrderAdminTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrderModel;
    private CreditOrderModel invalidCreditOrderModel;
    private String creditProductId;
    private CreditModel creditProduct;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(ADMIN);

        creditProductId = creditProductApiStep.getAllActiveCreditProducts(0, 100, Strings.EMPTY)
                .body().getContent().get(0).getId();
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

    @TestRails(id = "C6100036")
    @Test(description = "Create credit order, valid data, role - User", groups = {"Api"})
    public void c6100036() {
        Response<CreditOrderModel> response = creditOrderApiStep.createCreditOrder(creditOrderModel);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6100038")
    @Test(description = "Create credit order with invalid credit product id, role - User", groups = {"Api"})
    public void c6100038() {
        Response<CreditOrderModel> response = creditOrderApiStep.createCreditOrder(invalidCreditOrderModel);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
