package api.services;

import api.models.controllers.AllCreditCardsModel;
import api.models.controllers.CreditCardModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CreditCardService {

    @POST(CREATE_CREDIT_CARD)
    Call<CreditCardModel> createCreditCard(@Header(API_AUTHORIZATION) String token, @Body CreditCardModel pojoCreditCardModel);

    @PUT(UPDATE_CREDIT_CARD)
    Call<CreditCardModel> updateCreditCard(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body CreditCardModel pojoCreditCardModel);

    @GET(GET_ALL_CREDIT_CARDS_OF_CURRENT_USER)
    Call<AllCreditCardsModel> getAllCreditCardsOfCurrentUser(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size, @Query(API_SORT) String sort);

    @GET(GET_CREDIT_CARD_BY_ID)
    Call<CreditCardModel> getCreditCardById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @DELETE(DEACTIVATE_CREDIT_CARD_BY_ID)
    Call<Void> deactivateCreditCard(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(ACTIVATE_CREDIT_CARD_BY_ID)
    Call<Void> activateCreditCard(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);
}
