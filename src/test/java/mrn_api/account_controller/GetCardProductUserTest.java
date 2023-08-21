package mrn_api.account_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllCardProductModel;
import api.models.controllers.CardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CARD_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCardProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6205034")
    @Test(description = "Get all card products, role - USER", groups = {"Api"})
    public void c6205034() {
        Response<AllCardProductModel> response = cardProductApiStep.getAllCardProducts(0, 500, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        cardProductApiStep.checkCountOfAllCardProducts(cardProductControllerDataBaseManager.getCountAllById(),
                response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6205119")
    @Test(description = "Get card product by id with valid data, role - USER", groups = {"Api"})
    public void c6205119() {
        authorization(ADMIN);
        Response<CardProductModel> responseCreate = cardProductApiStep
                .createCardProduct(FakeGenerator.generateFakeCardProduct());
        Response<CardProductModel> response = cardProductApiStep
                .getCardProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        authorization(USER);
        CardProductModel cardProductModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_PRODUCT_BY_ID,
                responseCreate.body().getId()), CardProductModel.class);
        cardProductApiStep.checkCreatedCardProductInDataBaseById(response.body(), cardProductModelSql);
        checkAll();
    }
}
