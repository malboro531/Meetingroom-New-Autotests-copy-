package api.services;

import api.models.controllers.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CardService {
    @POST(CREATE_CARD)
    Call<CardModel> createCard(@Header(API_AUTHORIZATION) String token, @Body CardModel cardModel);

    @GET(GET_ALL_CARDS_COUNT)
    Call<AllCardModel> getAllCard(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE)
    int size, @Query(API_SORT) String sort);

    @GET(GET_CARDS_OF_CURRENT_USER)
    Call<AllCardModel> getCardsOfCurrentUser(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page,
                                             @Query(API_SIZE) int size, @Query(API_SORT) String sort);

    @GET(GET_CARD_BY_CARD_ID)
    Call<CardModel> getCardByCardId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_CARD_STATUS_BY_CARD_NUMBER)
    Call<ResponseBody> getCardStatus(@Header(API_AUTHORIZATION) String token, @Query(API_NUMBER) String number);

    @GET(GET_CARDS_CURRENCY)
    Call<CurrencyType> getCardsCurrency(@Header(API_AUTHORIZATION) String token, @Query(API_CARD_NUMBER) String cardNumber);

    @GET(GET_ALL_CARDS_BY_TYPE_CARD)
    Call<AllCardModel> getAllCardsByTypeCard(@Header(API_AUTHORIZATION) String token, @Query(API_PAYMENT) String payment,
                                             @Query(API_TYPE) String type, @Query(API_PAGE) int page, @Query(API_SIZE)
                                             int size, @Query(API_SORT) String sort);

    @GET(GET_CARDS_HASHED_NUMBERS)
    Call<CardNumberNotHashedModel> getCardsHashedNumbers(@Header(API_AUTHORIZATION) String string,
                                                         @Query(API_FIRST_TWELVE_HASHED) String firstTwelveHashed,
                                                         @Query(API_LAST_FOUR) String lastFour);

    @GET(GET_CARDS_NUMBERS)
    Call<CardModel> getCardsNumbers(@Header(API_AUTHORIZATION) String string,
                                    @Query(API_FIRST_TWELVE_NOT_HASHED) String firstTwelveNotHashed,
                                    @Query(API_LAST_FOUR) String lastFour);

    @GET(GET_EXTENDED_CARD_INFORMATION_BY_ID)
    Call<CardModel> getExtendedCardInformationById(@Header(API_AUTHORIZATION) String string, @Path(API_ID) String id);

    @GET(GET_ALL_CARDS_BY_ACCOUNT_ID)
    Call<AllCardModel> getAllCardsByAccountId(@Header(API_AUTHORIZATION) String token, @Path(API_ACCOUNT_ID) String accountId,
                                              @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                              @Query(API_SORT) String sort);

    @GET(GET_ACCOUNT_BY_CARD_NUMBER)
    Call<AccountModel> getAccountByCardNumber(@Header(API_AUTHORIZATION) String token, @Query(API_NUMBER) String cardNumber);

    @DELETE(DEACTIVATE_CARD)
    Call<CardModel> deactivateCard(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(SET_CARD_STATUS_READY)
    Call<Void> setCardStatusReady(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(SET_CARD_STATUS_ACTIVE)
    Call<Void> setCardStatusActive(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(SET_CARD_STATUS_BLOCKED)
    Call<Void> setCardStatusBlocked(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(SET_CARD_STATUS_CLOSED)
    Call<Void> setCardStatusClosed(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(SET_ALL_CARDS_OF_ACCOUNT_STATUS_CLOSED_BY_ACCOUNT_ID)
    Call<Void> setAllCardsOfAccountStatusClosedByAccountId(@Header(API_AUTHORIZATION) String token,
                                                           @Path(API_ACCOUNT_ID) String accountId);
}
