package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CardModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.ApiDataBase.*;
import static constants.enums.CardStatus.*;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_OK;

public class PatchCardStatusUserTest extends BaseApiTestUsingDataBase {

    private CardModel sqlCard;
    private String cardStatus;

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6118687")
    @Test(description = "Set card status to READY, role - USER", groups = {"Api"})
    public void c6118687() {
        CardModel sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_CREATE_STATUS, userId),
                CardModel.class);
        Response<Void> response = cardApiStep.setCardStatusReady(sqlCard.getId());
        checkResponseCode(response, HTTP_FORBIDDEN);
        cardStatus = cardApiStep.getCardById(sqlCard.getId()).body().getCardStatus();
        VerifySoft.verifyEqualsSoft(cardStatus, CREATED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118688")
    @Test(description = "Set ready card status to ACTIVE, role - USER", groups = {"Api"})
    public void c6118688() {
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_READY_STATUS, userId), CardModel.class);
        Response<Void> response = cardApiStep.setCardStatusActive(sqlCard.getId());
        checkResponseCode(response, HTTP_FORBIDDEN);
        cardStatus = (cardApiStep.getCardById(sqlCard.getId())).body().getCardStatus();
        VerifySoft.verifyEqualsSoft(cardStatus, READY.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118689")
    @Test(description = "Set card status to BLOCKED, role - USER", groups = {"Api"})
    public void c6118689() {
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ACTIVE_STATUS, userId), CardModel.class);
        Response<Void> response = cardApiStep.setCardStatusBlocked(sqlCard.getId());
        checkResponseCode(response, HTTP_OK);
        cardStatus = (cardApiStep.getCardById(sqlCard.getId())).body().getCardStatus();
        VerifySoft.verifyEqualsSoft(cardStatus, BLOCKED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6118690")
    @Test(description = "Set ACTIVE card status to CLOSED, role - USER", groups = {"Api"})
    public void c6118690() {
        sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ACTIVE_STATUS, userId), CardModel.class);
        Response<Void> response = cardApiStep.setCardStatusClosed(sqlCard.getId());
        checkResponseCode(response, HTTP_OK);
        cardStatus = (cardApiStep.getCardById(sqlCard.getId())).body().getCardStatus();
        VerifySoft.verifyEqualsSoft(cardStatus, CLOSED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }
}
