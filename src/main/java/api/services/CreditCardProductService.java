package api.services;

import api.models.controllers.CreditCardProductModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CreditCardProductService {

    @POST(CREATE_CREDIT_CARD_PRODUCT)
    Call<CreditCardProductModel> createCreditCardProduct(@Header(API_AUTHORIZATION) String token, @Body CreditCardProductModel pojoCreditCardProductModel);

    @GET(GET_CREDIT_CARD_PRODUCT_BY_ID)
    Call<CreditCardProductModel> getCreditCardProductById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ALL_CREDIT_CARD_PRODUCTS)
    Call<List<CreditCardProductModel>> getAllCreditCardProducts(@Header(API_AUTHORIZATION)String token);

    @DELETE(DELETE_CREDIT_CARD_PRODUCT_BY_ID)
    Call<CreditCardProductModel> deleteCreditCardProduct(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PUT(UPDATE_CREDIT_CARD_PRODUCT)
    Call<CreditCardProductModel> updateCreditCardProduct(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body CreditCardProductModel pojoCreditCardProductModel);

}
