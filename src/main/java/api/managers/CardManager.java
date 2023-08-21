package api.managers;

import api.models.controllers.*;
import api.services.CardService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CardManager extends BaseManager {

    private CardService cardService = initialise(BASE_URL).create(CardService.class);

    public Response<CardModel> createCard(CardModel cardModel) {
        Call<CardModel> call = cardService.createCard(TokenManager.getToken(), cardModel);
        return getResponse(call);
    }

    public Response<AllCardModel> getAllCard(int page, int size, String sort) {
        Call<AllCardModel> call = cardService.getAllCard(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<AllCardModel> getCardsOfCurrentUser(int page, int size, String sort) {
        Call<AllCardModel> call = cardService.getCardsOfCurrentUser(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CardModel> getCardByCardId(String id) {
        Call<CardModel> call = cardService.getCardByCardId(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<CardModel> deactivateCard(String id) {
        Call<CardModel> call = cardService.deactivateCard(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<CurrencyType> getCardsCurrency(String cardNumber) {
        Call<CurrencyType> call = cardService.getCardsCurrency(TokenManager.getToken(), cardNumber);
        return getResponse(call);
    }

    public Response<ResponseBody> getCardStatus(String number) {
        Call<ResponseBody> call = cardService.getCardStatus(TokenManager.getToken(), number);
        return getResponse(call);
    }

    public Response<AllCardModel> getAllCardsByTypeCard(String payment, String type, int page, int size,
                                                        String sort) {
        Call<AllCardModel> call = cardService.getAllCardsByTypeCard(TokenManager.getToken(), payment, type, page, size, sort);
        return getResponse(call);
    }

    public Response<CardNumberNotHashedModel> getCardsHashedNumbers(String firstTwelveHashed, String lastFour) {
        Call<CardNumberNotHashedModel> call = cardService.getCardsHashedNumbers(TokenManager.getToken(), firstTwelveHashed, lastFour);
        return getResponse(call);
    }

    public Response<CardModel> getCardsNumbers(String firstTwelveNotHashed, String lastFour) {
        Call<CardModel> call = cardService.getCardsNumbers(TokenManager.getToken(), firstTwelveNotHashed, lastFour);
        return getResponse(call);
    }

    public Response<CardModel> getExtendedCardInformationById(String id) {
        Call<CardModel> call = cardService.getExtendedCardInformationById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllCardModel> getAllCardsByAccountId(String accountId, int page, int size, String sort) {
        Call<AllCardModel> call = cardService.getAllCardsByAccountId(TokenManager.getToken(), accountId, page, size, sort);
        return getResponse(call);
    }

    public Response<AccountModel> getAccountByCardNumber(String cardNumber) {
        Call<AccountModel> call = cardService.getAccountByCardNumber(TokenManager.getToken(), cardNumber);
        return getResponse(call);
    }

    public Response<Void> setCardStatusReady(String id) {
        Call<Void> call = cardService.setCardStatusReady(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> setCardStatusActive(String id) {
        Call<Void> call = cardService.setCardStatusActive(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> setCardStatusBlocked(String id) {
        Call<Void> call = cardService.setCardStatusBlocked(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> setCardStatusClosed(String id) {
        Call<Void> call = cardService.setCardStatusClosed(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> setAllCardsOfAccountStatusClosedByAccountId(String accountId) {
        Call<Void> call = cardService.setAllCardsOfAccountStatusClosedByAccountId(TokenManager.getToken(), accountId);
        return getResponse(call);
    }
}
