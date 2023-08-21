package mrn_api.credit_controller;

import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateCreditCardProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6220891")
    @Test(description = " Create Credit card product, valid data, role - ADMIN", groups = {"Api"})
    public void c6220891() {
        CreditCardProductModel creditCardProduct = FakeGenerator.generateFakeCreditCardProduct();
        Response<CreditCardProductModel> response = creditCardProductApiStep.createCreditCardProduct(creditCardProduct);
        checkResponseCode(response, HTTP_OK);
        checkAll();
        creditCardProductDBManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID, response.body().getId());
    }
}
