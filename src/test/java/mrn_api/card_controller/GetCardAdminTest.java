package mrn_api.card_controller;

import api.models.controllers.*;
import api.services.TestRails;
import constants.enums.CardStatus;
import constants.enums.Currency;
import helpers.FakeGenerator;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.ApiDataBase.*;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCardAdminTest extends BaseApiTestUsingDataBase {

    private String firstTwelveNumbers;
    private CardModel card;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        card = createCard();
    }

    @TestRails(id = "C6406054")
    @Test(description = "Get all cards, role - ADMIN", groups = {"Api"})
    public void c6406054() {
        Response<AllCardModel> response = cardApiStep.getAllCard(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6121838")
    @Test(description = "Get card by card id, role - ADMIN", groups = {"Api"})
    public void c6121838() {
        Response<CardModel> cardResponse = cardApiStep.getCardById(createCard().getId());
        checkResponseCode(cardResponse, HTTP_OK);
        cardApiStep.verifyFieldsNotNull(cardResponse.body());
        checkAll();
    }

    private CardModel createCard() {
        CardModel cardModel = FakeGenerator.generateFakeCard();
        cardModel.setCardProductId(createCardProduct().body().getId());
        cardModel.setAccountId(createAccount().body().getId());
        Response<CardModel> createCardResponse = cardApiStep.createCard(cardModel);
        checkResponseCode(createCardResponse, HTTP_OK);
        return createCardResponse.body();
    }

    @AfterTest
    public void deleteCardProductAndDeactivateCard() {
        cardProductApiStep.deleteCardProduct(createCardProduct().body().getId());
        cardApiStep.deactivateCard(createCard().getId());
    }

    @TestRails(id = "C5987862")
    @Test(description = "Get all cards of current user, role - ADMIN", groups = {"Api"})
    public void c5987862() {
        Response<AllCardModel> response = cardApiStep
                .getCardsOfCurrentUser(DEFAULT_PAGE_DB_REQUEST, DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        cardApiStep.checkAllCards(cardProductDataBaseManager.getCountAllById(userId), response.body().getContent().size());
        checkAll();
    }

    private String getCardNumberHash() {
        String cardNumberHash = card.getFirstTwelveNumbersHash() + card.getLastFourNumbers();
        return cardNumberHash;
    }

    @SneakyThrows
    @TestRails(id = "C6194989")
    @Test(description = "Get cards currency, role - ADMIN", groups = {"Api"})
    public void c6194989() {
        Response<CurrencyType> response = cardApiStep.getCardsCurrency(getCardNumberHash());
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyEqualsSoft(response.body().getCurrency(), Currency.EUR.getCurrency(), ERROR_MESSAGE_INVALID_CURRENCY_NAME);
        checkAll();
    }

    @SneakyThrows
    @TestRails(id = "C6420391")
    @Test(description = "Check card status by card number, role - ADMIN", groups = {"Api"})
    public void c6420391() {
        Response<ResponseBody> response = cardApiStep.getCardStatusByCardNumber(getCardNumberHash());
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyEqualsSoft(response.body().string(), CardStatus.CREATED.name(), ERROR_MESSAGE_INVALID_CARD_STATUS);
        checkAll();
    }

    @TestRails(id = "C6192879")
    @Test(description = "Get all cards by type card, role - ADMIN", groups = {"API"})
    public void c6192879() {
        Response<AllCardModel> response = cardApiStep.getAllCardsByTypeCard(card.getPaymentSystem(),
                card.getTypeName(), DEFAULT_PAGE_DB_REQUEST, DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6194986")
    @Test(description = "Get card by card hashed numbers, role - ADMIN", groups = {"API"})
    public void c6194986() {
        Response<CardNumberNotHashedModel> response = cardApiStep
                .getCardsHashedNumbers(card.getFirstTwelveNumbersHash(), card.getLastFourNumbers());
        firstTwelveNumbers = response.body().getFirstTwelve();
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6194469")
    @Test(description = "Get card by card numbers, role - ADMIN", groups = {"API"}, dependsOnMethods = "c6194986")
    public void c6194469() {
        Response<CardModel> response = cardApiStep.getCardsNumbers(firstTwelveNumbers, card.getLastFourNumbers());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6175146")
    @Test(description = "Get extended card information by id, role - ADMIN", groups = {"API"})
    public void c6175146() {
        Response<CardModel> response = cardApiStep.getExtendedCardInformationById(card.getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6195789")
    @Test(description = "Get all cards by account id, role - ADMIN", groups = {"Api"})
    public void c6195789() {
        Response<AllCardModel> response = cardApiStep
                .getAllCardsByAccountId(card.getAccountId(),0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6195797")
    @Test(description = "Get account by card number, role - ADMIN", groups = {"Api"})
    public void c6195797() {
        Response<AccountModel> response = cardApiStep.getAccountByCardNumber(getCardNumberHash());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @AfterClass
    public void deleteCard() {
        cardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CARD_BY_ID, card.getId());
    }
}
