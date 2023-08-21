package mrn_api.credit_controller;

import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditCardProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6220981")
    @Test(description = "Get credit card product by id with valid data, role - ADMIN", groups = {"Api"})
    public void c6220981() {
        CreditCardProductModel creditCardProductModel = FakeGenerator.generateFakeCreditCardProduct();
        Response<CreditCardProductModel> responseCreate = creditCardProductApiStep
                .createCreditCardProduct(creditCardProductModel);
        checkResponseCode(responseCreate, HTTP_OK);
        Response<CreditCardProductModel> response = creditCardProductApiStep
                .getCreditCardProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
        creditCardProductDBManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID,
                responseCreate.body().getId());
    }

    @TestRails(id = "C6220979")
    @Test(description = "Get all credit card products, role - ADMIN", groups = {"Api"})
    public void c6220979() {
        Response<List<CreditCardProductModel>> response = creditCardProductApiStep.getAllCreditCardProducts();
        checkResponseCode(response, HTTP_OK);
        creditCardProductApiStep.checkAllCreditCardProducts(creditCardProductDBManager.getCountAll(), response.body().size());
        checkAll();
    }
}
