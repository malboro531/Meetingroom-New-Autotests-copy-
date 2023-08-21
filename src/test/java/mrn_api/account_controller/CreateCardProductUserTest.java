package mrn_api.account_controller;

import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class CreateCardProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6204950")
    @Test(description = " Create card product , role User", groups = {"Api"})
    public void c6204950() {
        CardProductModel cardProduct = FakeGenerator.generateFakeCardProduct();
        Response<CardProductModel> response = cardProductApiStep.createCardProduct(cardProduct);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6205028")
    @Test(description = "Card product update , role User", groups = {"Api"})
    public void c6205028() {
        authorization(ADMIN);
        CardProductModel cardProduct = FakeGenerator.generateFakeCardProduct();
        Response<CardProductModel> responseCreate = cardProductApiStep.createCardProduct(cardProduct);
        cardProduct.setCurrency(responseCreate.body().getCurrency());
        cardProduct.setId(responseCreate.body().getId());
        authorization(USER);
        Response<CardProductModel> responseUpdate = cardProductApiStep.updateCardProduct(cardProduct);
        checkResponseCode(responseUpdate, HTTP_FORBIDDEN);
        checkAll();
    }
}
