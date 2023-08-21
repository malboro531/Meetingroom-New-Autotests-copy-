package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CardModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CARD_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CARD_BY_ID;
import static constants.GlobalData.VALID_CARD_PRODUCT_ID_FOR_USER;
import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class CreateCardUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6189374")
    @Test(description = " Create card , role USER", groups = {"Api"})
    public void c6189374() {
        CardModel card = FakeGenerator.generateFakeCard();
        card.setCardProductId(VALID_CARD_PRODUCT_ID_FOR_USER);
        card.setAccountId(createAccount().body().getId());
        Response<CardModel> response = cardApiStep.createCard(card);
        checkResponseCode(response, HTTP_OK);
        CardModel cardModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID,
                response.body().getId()), CardModel.class);
        cardApiStep.checkCreatedCardInDataBase(response.body(), cardModelSql);
        checkAll();
        cardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CARD_BY_ID, cardModelSql.getId());
    }

    @TestRails(id = "C6189422")
    @Test(description = " Create card , role UNAUTHORIZED", groups = {"Api"})
    public void c6189422() {
        CardModel card = FakeGenerator.generateFakeCard();
        card.setCardProductId(VALID_CARD_PRODUCT_ID_FOR_USER);
        card.setAccountId(createAccount().body().getId());
        authorization(UNAUTHORIZED);
        Response<CardModel> response = cardApiStep.createCard(card);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
