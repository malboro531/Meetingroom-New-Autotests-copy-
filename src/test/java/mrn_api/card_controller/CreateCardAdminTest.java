package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CardModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CARD_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateCardAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6189373")
    @Test(description = " Create card , role Admin", groups = {"Api"})
    public void c6189373() {
        CardModel card = FakeGenerator.generateFakeCard();
        card.setCardProductId(createCardProduct().body().getId());
        card.setAccountId(createAccount().body().getId());
        Response<CardModel> response = cardApiStep.createCard(card);
        checkResponseCode(response, HTTP_OK);
        CardModel cardModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, response.body().getId()),
                CardModel.class);
        cardApiStep.checkCreatedCardInDataBase(response.body(), cardModelSql);
        checkAll();
    }
}
