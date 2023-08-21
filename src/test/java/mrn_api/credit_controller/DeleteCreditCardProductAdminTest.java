package mrn_api.credit_controller;

import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteCreditCardProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6220984")
    @Test(description = "Delete credit card product, role - ADMIN", groups = {"Api"})
    public void c6220984() {
        CreditCardProductModel creditCardProduct = FakeGenerator.generateFakeCreditCardProduct();
        Response<CreditCardProductModel> responseCreate = creditCardProductApiStep
                .createCreditCardProduct(creditCardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        creditCardProductApiStep.deleteCreditCardProduct(responseCreate.body().getId());
        Response<CreditCardProductModel> response = creditCardProductApiStep
                .getCreditCardProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
