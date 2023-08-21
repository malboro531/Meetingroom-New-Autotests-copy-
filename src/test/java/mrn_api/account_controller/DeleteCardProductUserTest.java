package mrn_api.account_controller;

import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class DeleteCardProductUserTest extends BaseApiTestUsingDataBase {

    private Response<CardProductModel> responseCreate;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        CardProductModel cardProduct = FakeGenerator.generateFakeCardProduct();
        responseCreate = cardProductApiStep.createCardProduct(cardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6205130")
    @Test(description = "Delete card product, role - USER", groups = {"Api"})
    public void c6205130() {
        authorization(USER);
        cardProductApiStep.deleteCardProduct(responseCreate.body().getId());
        Response<CardProductModel> responseDelete = cardProductApiStep
                .deleteCardProduct(responseCreate.body().getId());
        checkResponseCode(responseDelete, HTTP_FORBIDDEN);
        checkAll();
    }

    @AfterTest
    public void deleteCardProduct() {
        authorization(ADMIN);
        cardProductApiStep.deleteCardProduct(responseCreate.body().getId());
        Response<CardProductModel> response = cardProductApiStep.getCardProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
