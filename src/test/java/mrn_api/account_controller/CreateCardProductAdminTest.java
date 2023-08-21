package mrn_api.account_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
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

public class CreateCardProductAdminTest extends BaseApiTestUsingDataBase {

    private CardProductModel cardProduct;
    private Response<CardProductModel> responseCreate;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        cardProduct = FakeGenerator.generateFakeCardProduct();
        responseCreate = cardProductApiStep.createCardProduct(cardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6204951")
    @Test(description = " Create card product , role Admin", groups = {"Api"})
    public void c6204951() {
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_ID,
                responseCreate.body().getId()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseById(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6114605")
    @Test(description = " Create card product and check limits field", groups = {"Api"})
    public void c6114605() {
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_LIMITS,
                responseCreate.body().getLimits()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseByLimits(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6205029")
    @Test(description = "Card product update, role Admin", groups = {"Api"})
    public void c6205029() {
        updateCardProduct();
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_LIMITS,
                responseCreate.body().getLimits()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseByLimits(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6114624")
    @Test(description = "Update card product and check limits field", groups = {"Api"})
    public void c6114624() {
        updateCardProduct();
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_LIMITS,
                responseCreate.body().getLimits()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseByLimits(responseCreate.body(), cardProductModelSql);
        checkAll();
    }

    private void updateCardProduct() {
        cardProduct.setLimits(responseCreate.body().getLimits());
        cardProduct.setId(responseCreate.body().getId());
        Response<CardProductModel> responseUpdate = cardProductApiStep.updateCardProduct(cardProduct);
        checkResponseCode(responseUpdate, HTTP_OK);
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
