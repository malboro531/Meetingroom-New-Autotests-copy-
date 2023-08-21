package mrn_api.card_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.*;
import api.services.TestRails;
import constants.enums.Currency;
import helpers.FakeGenerator;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_CARD_PRODUCT_ID_FOR_USER;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class GetCardUserTest extends BaseApiTestUsingDataBase {

    private String firstTwelveNumbers;
    private CardModel card;

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
        card = createCard();
    }

    private CardModel createCard() {
        CardModel card = FakeGenerator.generateFakeCard();
        card.setCardProductId(VALID_CARD_PRODUCT_ID_FOR_USER);
        card.setAccountId(createAccount().body().getId());
        Response<CardModel> response = cardApiStep.createCard(card);
        checkResponseCode(response, HTTP_OK);
        CardModel cardModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ID, response.body().getId()),
                CardModel.class);
        cardApiStep.checkCreatedCardInDataBase(response.body(), cardModelSql);
        checkAll();
        return response.body();
    }

    @TestRails(id = "C6121837")
    @Test(description = "Get card by card id, role - USER", groups = {"Api"})
    public void c6121837() {
        Response<CardModel> cardResponse = cardApiStep.getCardById(card.getId());
        checkResponseCode(cardResponse, HTTP_OK);
        cardApiStep.verifyFieldsNotNull(cardResponse.body());
        checkAll();
    }

    @TestRails(id = "C6189383")
    @Test(description = "Get all cards of current user, role - USER", groups = {"Api"})
    public void c6189383() {
        Response<AllCardModel> response = cardApiStep.getCardsOfCurrentUser(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        cardApiStep.checkAllCards(cardProductDataBaseManager.getCountAllById(userId), response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6406065")
    @Test(description = "Get all cards, role - USER", groups = {"Api"})
    public void c6406065() {
        Response<AllCardModel> response = cardApiStep.getAllCard(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    private String getCardNumbersHash() {
        return card.getFirstTwelveNumbersHash() + card.getLastFourNumbers();
    }

    @SneakyThrows
    @TestRails(id = "C6194990")
    @Test(description = "Get cards currency, role - User", groups = {"Api"})
    public void c6194990() {
        Response<CurrencyType> response = cardApiStep.getCardsCurrency(getCardNumbersHash());
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyEqualsSoft(response.body().getCurrency(), Currency.EUR.getCurrency(), ERROR_MESSAGE_INVALID_CURRENCY_NAME);
        checkAll();
    }

    @SneakyThrows
    @TestRails(id = "C6420393")
    @Test(description = "Check card status by card number, role - USER", groups = {"Api"})
    public void c6420393() {
        Response<ResponseBody> response = cardApiStep.getCardStatusByCardNumber(getCardNumbersHash());
        checkResponseCode(response, HTTP_OK);
        CardModel sqlCard = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CARD_BY_ACCOUNT_ID, card.getAccountId()),
                CardModel.class);
        VerifySoft.verifyEqualsSoft(response.body().string(), sqlCard.getCardStatus(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6192881")
    @Test(description = "Get all cards by type card, role - USER", groups = {"API"})
    public void c6192881() {
        Response<AllCardModel> response = cardApiStep.getAllCardsByTypeCard(card.getPaymentSystem(),
                card.getTypeName(), DEFAULT_PAGE_DB_REQUEST, DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6194987")
    @Test(description = "Get card by card hashed numbers, role - USER", groups = {"API"})
    public void c6194987() {
        Response<CardNumberNotHashedModel> response = cardApiStep
                .getCardsHashedNumbers(card.getFirstTwelveNumbersHash(), card.getLastFourNumbers());
        firstTwelveNumbers = response.body().getFirstTwelve();
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6194981")
    @Test(description = "Get card by card numbers, role - USER", groups = {"API"}, dependsOnMethods = "c6194987")
    public void c6194981() {
        Response<CardModel> response = cardApiStep.getCardsNumbers(firstTwelveNumbers,
                card.getLastFourNumbers());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6175216")
    @Test(description = "Get extended card information by id, role - USER", groups = {"API"})
    public void c6175216() {
        Response<CardModel> response = cardApiStep.getExtendedCardInformationById(card.getId());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6195794")
    @Test(description = "Get all cards by account id, role - USER", groups = {"Api"})
    public void c6195794() {
        Response<AllCardModel> response = cardApiStep.getAllCardsByAccountId(card.getAccountId(),
                DEFAULT_PAGE_DB_REQUEST, DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6195798")
    @Test(description = "Get account by card number, role - USER", groups = {"Api"})
    public void c6195798() {
        Response<AccountModel> response = cardApiStep.getAccountByCardNumber(getCardNumbersHash());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @AfterClass
    public void deleteCard() {
        cardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CARD_BY_ID, card.getId());
    }
}
