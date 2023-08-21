package mrn_api.account_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllCardProductModel;
import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CARD_PRODUCT_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CARD_PRODUCT_BY_LIMITS;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCardProductAdminTest extends BaseApiTestUsingDataBase {

    private Response<CardProductModel> responseCreate;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        CardProductModel cardProduct = FakeGenerator.generateFakeCardProduct();
        responseCreate = cardProductApiStep.createCardProduct(cardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6205035")
    @Test(description = "Get all card products, role - ADMIN", groups = {"Api"})
    public void c6205035() {
        getAllCardsAndCheckCount(cardProductControllerDataBaseManager.getCountAllById());
    }

    @TestRails(id = "C6114600")
    @Test(description = "Get all card products by limits", groups = {"Api"})
    public void c6114600() {
        getAllCardsAndCheckCount(cardProductControllerDataBaseManager.getCountAllByLimits());
    }

    @TestRails(id = "C6205120")
    @Test(description = "Get card product by id with valid data, role - ADMIN", groups = {"Api"})
    public void c6205120() {
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_ID,
                responseCreate.body().getId()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseById(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6114603")
    @Test(description = "Checking 'limits' field in created card product", groups = {"Api"})
    public void c6114603() {
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_LIMITS,
                (responseCreate.body().getLimits())), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseById(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    private void getAllCardsAndCheckCount(int expectedCount) {
        Response<AllCardProductModel> response = cardProductApiStep.getAllCardProducts(0, 500, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        cardProductApiStep.checkCountOfAllCardProducts(expectedCount, response.body().getContent().size());
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
