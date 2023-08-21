package mrn_api.account_controller;

import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteCardProductAdminTest extends BaseApiTestUsingDataBase {

    private Response<CardProductModel> responseCreate;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        CardProductModel cardProduct = FakeGenerator.generateFakeCardProduct();
        responseCreate = cardProductApiStep.createCardProduct(cardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6205642")
    @Test(description = "Delete card product, role - ADMIN", groups = {"Api"})
    public void c6205642() {
        cardProductApiStep.deleteCardProduct(responseCreate.body().getId());
        Response<CardProductModel> response = cardProductApiStep.getCardProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
