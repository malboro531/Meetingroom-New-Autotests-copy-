package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.*;
import api.services.TestRails;
import helpers.FakeGenerator;
import okhttp3.ResponseBody;
import org.testng.annotations.AfterClass;
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

public class GetCardUnauthorizedTest extends BaseApiTestUsingDataBase {

    private String firstTwelveNumbers;
    private CardModel card;

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
        card = createCard();
        authorization(UNAUTHORIZED);
    }

    private CardModel createCard() {
        CardModel card = FakeGenerator.generateFakeCard();
        card.setCardProductId(VALID_CARD_PRODUCT_ID_FOR_USER);
        card.setAccountId(createAccount().body().getId());
        Response<CardModel> response = cardApiStep.createCard(card);
        checkResponseCode(response, HTTP_OK);
        CardModel cardModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID,
                response.body().getId()), CardModel.class);
        cardApiStep.checkCreatedCardInDataBase(response.body(), cardModelSql);
        checkAll();
        return response.body();
    }

    @TestRails(id = "C6189390")
    @Test(description = "Get all cards of current user, role - UNAUTHORIZED", groups = {"Api"})
    public void c6189390() {
        Response<AllCardModel> response = cardApiStep.getCardsOfCurrentUser(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6406082")
    @Test(description = "Get all cards, role - UNAUTHORIZED", groups = {"Api"})
    public void c6406082() {
        Response<AllCardModel> response = cardApiStep.getAllCard(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    private String getCardNumbersHash() {
        return card.getFirstTwelveNumbersHash() + card.getLastFourNumbers();
    }

    @TestRails(id = "C6194993")
    @Test(description = "Get cards currency, role - UNAUTHORIZED", groups = {"Api"})
    public void c6194993() {
        Response<CurrencyType> response = cardApiStep.getCardsCurrency(getCardNumbersHash());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6420394")
    @Test(description = "Check card status by card number, role - UNAUTHORIZED", groups = {"Api"})
    public void c6420394() {
        Response<ResponseBody> response = cardApiStep.getCardStatusByCardNumber(getCardNumbersHash());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6194988")
    @Test(description = "Get card by card hashed numbers, role - UNAUTHORIZED", groups = {"API"})
    public void c6194988() {
        Response<CardNumberNotHashedModel> response = cardApiStep
                .getCardsHashedNumbers(card.getFirstTwelveNumbersHash(), card.getLastFourNumbers());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6194985")
    @Test(description = "Get card by card numbers, role - UNAUTHORIZED", groups = {"API"})
    public void c6194985() {
        Response<CardModel> response = cardApiStep.getCardsNumbers(firstTwelveNumbers, card.getLastFourNumbers());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6175243")
    @Test(description = "Get extended card information by id, role - UNAUTHORIZED", groups = {"API"})
    public void c6175243() {
        Response<CardModel> response = cardApiStep.getExtendedCardInformationById(card.getId());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6195795")
    @Test(description = "Get all cards by account id, role - UNAUTHORIZED", groups = {"Api"})
    public void c6195795() {
        Response<AllCardModel> response = cardApiStep.getAllCardsByAccountId(card.getAccountId(),
                DEFAULT_PAGE_DB_REQUEST, DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6196451")
    @Test(description = "Get account by card number, role - UNAUTHORIZED", groups = {"Api"})
    public void c6196451() {
        Response<AccountModel> response = cardApiStep.getAccountByCardNumber(getCardNumbersHash());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @AfterClass
    public void deleteCard() {
        cardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CARD_BY_ID, card.getId());
    }
}
