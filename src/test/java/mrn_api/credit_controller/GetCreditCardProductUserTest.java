package mrn_api.credit_controller;

import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditCardProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    public String getCreditCardProductId() {
        Response<List<CreditCardProductModel>> creditCardProductId = creditCardProductApiStep.getAllCreditCardProducts();
        return creditCardProductId.body().get(0).getId();
    }

    @TestRails(id = "C6220983")
    @Test(description = "Get credit card product by id with valid data, role - ADMIN", groups = {"Api"})
    public void c6220983() {
        Response<CreditCardProductModel> response = creditCardProductApiStep.getCreditCardProductById(getCreditCardProductId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6220980")
    @Test(description = "Get all credit card products, role - ADMIN", groups = {"Api"})
    public void c6220980() {
        Response<List<CreditCardProductModel>> response = creditCardProductApiStep.getAllCreditCardProducts();
        checkResponseCode(response, HTTP_OK);
        creditCardProductApiStep.checkAllCreditCardProducts(creditCardProductDBManager.getCountAll(), response.body().size());
        checkAll();
    }
}
