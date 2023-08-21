package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CardModel;
import api.services.TestRails;
import constants.enums.CardStatus;
import helpers.FakeGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.ApiDataBase.*;
import static constants.enums.CardStatus.CLOSED;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class PatchCardStatusAdminTest extends BaseApiTestUsingDataBase {

    private CardModel card;
    private CardModel sqlCard;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        card = createCard();
    }

    private CardModel createCard() {
        CardModel cardModel = FakeGenerator.generateFakeCard();
        cardModel.setCardProductId(createCardProduct().body().getId());
        cardModel.setAccountId(createAccount().body().getId());
        Response<CardModel> createCardResponse = cardApiStep.createCard(cardModel);
        checkResponseCode(createCardResponse, HTTP_OK);
        return createCardResponse.body();
    }

    @TestRails(id = "C6118106")
    @Test(description = "Set card status to READY, role - ADMIN", groups = {"Api"})
    public void c6118106() {
        Response<Void> response = cardApiStep.setCardStatusReady(card.getId());
        checkResponseCode(response, HTTP_OK);
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, card.getId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CardStatus.READY.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118112")
    @Test(description = "Set card status to ACTIVE, role - Admin", groups = {"Api"}, dependsOnMethods = "c6118106")
    public void c6118112() {
        Response<Void> response = cardApiStep.setCardStatusActive(card.getId());
        checkResponseCode(response, HTTP_OK);
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, card.getId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CardStatus.ACTIVE.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118115")
    @Test(description = "Set card status to BLOCKED, role - Admin", groups = {"Api"}, dependsOnMethods = "c6118112")
    public void c6118115() {
        Response<Void> response = cardApiStep.setCardStatusBlocked(card.getId());
        checkResponseCode(response, HTTP_OK);
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, card.getId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CardStatus.BLOCKED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118692")
    @Test(description = "Set BLOCKED card status to ACTIVE, role - Admin", groups = {"Api"}, dependsOnMethods = "c6118115")
    public void c6118692() {
        Response<Void> response = cardApiStep.setCardStatusActive(card.getId());
        checkResponseCode(response, HTTP_OK);
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, card.getId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CardStatus.ACTIVE.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118116")
    @Test(description = "Set ACTIVE card status to CLOSED, role - Admin", groups = {"Api"}, dependsOnMethods = "c6118692")
    public void c6118116() {
        Response<Void> response = cardApiStep.setCardStatusClosed(card.getId());
        checkResponseCode(response, HTTP_OK);
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, card.getId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CardStatus.CLOSED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6192864")
    @Test(description = "Set all cards of account status to CLOSED by accountId, role - ADMIN", groups = {"Api"})
    public void c6192864() {
        Response<Void> response = cardApiStep.setAllCardsOfAccountStatusClosedByAccountId(card.getAccountId());
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ACCOUNT_ID, card.getAccountId()), CardModel.class);
        VerifySoft.verifyEqualsSoft(sqlCard.getCardStatus(), CLOSED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @AfterClass
    public void deleteCard() {
        cardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CARD_BY_ID, card.getId());
    }
}
