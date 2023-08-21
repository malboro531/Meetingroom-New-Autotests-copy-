package steps.api;

import api.managers.CardManager;
import api.models.controllers.*;
import io.qameta.allure.Step;
import okhttp3.ResponseBody;
import retrofit2.Response;
import verification.Verify;
import verification.VerifySoft;

public class CardApiStep {

    private CardManager cardManager = new CardManager();

    @Step("Create card")
    public Response<CardModel> createCard(CardModel cardModel) {
        return cardManager.createCard(cardModel);
    }

    @Step("Get all card")
    public Response<AllCardModel> getAllCard(int page, int size, String sort) {
        return cardManager.getAllCard(page, size, sort);
    }

    @Step("Get all cards of current user")
    public Response<AllCardModel> getCardsOfCurrentUser(int page, int size, String sort) {
        return cardManager.getCardsOfCurrentUser(page, size, sort);
    }

    @Step("Check created card in DB")
    public void checkCreatedCardInDataBase(CardModel cardModel, CardModel cardModelSql) {
        VerifySoft.verifyEqualsSoft(cardModel.getId(), cardModelSql.getId(), "card id found in DB");
        VerifySoft.verifyEqualsSoft(cardModel.getAccountId(), cardModelSql.getAccountId(), "account id found in DB");
        VerifySoft.verifyEqualsSoft(cardModel.getCardProductId(), cardModelSql.getCardProductId(), "card product id found in DB");
        VerifySoft.verifyEqualsSoft(cardModel.getHolderName(), cardModelSql.getHolderName(), "holder name found in DB");
    }

    public void checkAllCards(Integer baseCount, Integer responseCount) {
        VerifySoft.verifyEqualsSoft(baseCount, responseCount, "Count cards in DataBase matches with response count");
    }

    @Step("Get card by id")
    public Response<CardModel> getCardById(String id) {
        return cardManager.getCardByCardId(id);
    }

    @Step("Verify that all fields in response body 'get card by id' are not null")
    public void verifyFieldsNotNull(CardModel cardModel) {
        Verify.verifyNotNull(cardModel.getId(), "There is id in response body");
        Verify.verifyNotNull(cardModel.getCardProductId(), "There is card product id in response body");
        Verify.verifyNotNull(cardModel.getPaymentSystem(), "There is payment system in response body");
        Verify.verifyNotNull(cardModel.getTypeName(), "There is type name in response body");
        Verify.verifyNotNull(cardModel.getLastFourNumbers(), "There are last four numbers in response body");
        Verify.verifyNotNull(cardModel.getFirstTwelveNumbersHash(), "There are first twelve numbers hash in response body");
        Verify.verifyNotNull(cardModel.getPaymentSystem(), "There is payment system in response body");
        Verify.verifyNotNull(cardModel.getValidFromDate(), "There is 'valid from date'-information in response body");
        Verify.verifyNotNull(cardModel.getExpireDate(), "There is expire date in response body");
        Verify.verifyNotNull(cardModel.getHolderName(), "There is holder name in response body");
        Verify.verifyNotNull(cardModel.getBalance(), "There is balance in response body");
        Verify.verifyNotNull(cardModel.getCurrency(), "There is currency in response body");
        Verify.verifyNotNull(cardModel.isActive(), "There is 'is active'-information in response body");
        Verify.verifyNotNull(cardModel.getCardStatus(), "There is cardStatus in response body");
    }

    @Step("Deactivate card by id")
    public void deactivateCard(String id) {
        cardManager.deactivateCard(id);
    }

    @Step("Get cards currency")
    public Response<CurrencyType> getCardsCurrency(String cardNumber) {
        return cardManager.getCardsCurrency(cardNumber);
    }

    @Step("Get card status by card number")
    public Response<ResponseBody> getCardStatusByCardNumber(String number) {
        return cardManager.getCardStatus(number);
    }

    @Step("Get all cards by type card")
    public Response<AllCardModel> getAllCardsByTypeCard(String payment, String type, int page, int size, String sort) {
        return cardManager.getAllCardsByTypeCard(payment, type, page, size, sort);
    }

    @Step("Get card by card hashed numbers")
    public Response<CardNumberNotHashedModel> getCardsHashedNumbers(String firstTwelveHashed, String lastFour) {
        return cardManager.getCardsHashedNumbers(firstTwelveHashed, lastFour);
    }

    @Step("Get card by card numbers")
    public Response<CardModel> getCardsNumbers(String firstTwelveNotHashed, String lastFour) {
        return cardManager.getCardsNumbers(firstTwelveNotHashed, lastFour);
    }

    @Step("Get extended card information by id")
    public Response<CardModel> getExtendedCardInformationById(String id) {
        return cardManager.getExtendedCardInformationById(id);
    }

    @Step("Get all cards by account id")
    public Response<AllCardModel> getAllCardsByAccountId(String accountId, int page, int size, String sort) {
        return cardManager.getAllCardsByAccountId(accountId, page, size, sort);
    }

    @Step("Get account by card number")
    public Response<AccountModel> getAccountByCardNumber(String cardNumber) {
        return cardManager.getAccountByCardNumber(cardNumber);
    }

    @Step("Set card status to ready")
    public Response<Void> setCardStatusReady(String id) {
        return cardManager.setCardStatusReady(id);
    }

    @Step("Set card status to active")
    public Response<Void> setCardStatusActive(String id) {
        return cardManager.setCardStatusActive(id);
    }

    @Step("Set card status to blocked")
    public Response<Void> setCardStatusBlocked(String id) {
        return cardManager.setCardStatusBlocked(id);
    }

    @Step("Set active card status to closed")
    public Response<Void> setCardStatusClosed(String id) {
        return cardManager.setCardStatusClosed(id);
    }

    @Step("Set all cards of account status closed by account id")
    public Response<Void> setAllCardsOfAccountStatusClosedByAccountId(String accountId) {
        return cardManager.setAllCardsOfAccountStatusClosedByAccountId(accountId);
    }
}
