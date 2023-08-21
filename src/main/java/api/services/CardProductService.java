package api.services;

import api.models.controllers.AllCardProductModel;
import api.models.controllers.CardProductModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CardProductService {

    @POST(CREATE_CARD_PRODUCT)
    Call<CardProductModel> createCardProduct(@Header(API_AUTHORIZATION) String token,
                                             @Body CardProductModel cardProductModel);

    @DELETE(DELETE_CARD_PRODUCT)
    Call<CardProductModel> deleteCardProduct(@Header(API_AUTHORIZATION) String token,
                                             @Path(API_ID) String id);

    @PUT(PUT_UPDATE_CARD_PRODUCT)
    Call<CardProductModel> updateCardProduct(@Header(API_AUTHORIZATION) String token,
                                             @Body CardProductModel cardProductModel);

    @GET(CET_ALL_CARD_PRODUCT)
    Call<AllCardProductModel> getAllCardProducts(@Header(API_AUTHORIZATION) String token,
                                                 @Query(API_PAGE) int page,
                                                 @Query(API_SIZE) int size,
                                                 @Query(API_SORT) String sort);

    @GET(GET_CARD_PRODUCT_BY_ID)
    Call<CardProductModel> getCardProductById(@Header(API_AUTHORIZATION) String token,
                                              @Path(API_ID) String id);
}
