package api.services;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditModel;
import api.models.controllers.RegularPaymentModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CreditProductService {

    @POST(CREATE_CREDIT_PRODUCT)
    Call<CreditModel> createCreditProduct(@Header(API_AUTHORIZATION) String token, @Body CreditModel pojoCreditProductModel);

    @GET(GET_CREDIT_PRODUCT_BY_ID)
    Call<CreditModel> getCreditProductById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ALL_CREDIT_PRODUCTS)
    Call<AllCreditAccountsModel> getAllCreditProducts(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                                      @Query(API_SORT) String sort);

    @GET(GET_ALL_ACTIVE_CREDIT_PRODUCT)
    Call<AllCreditAccountsModel> getAllActiveCreditProducts(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                                      @Query(API_SORT) String sort);

    @PUT(UPDATE_CREDIT_PRODUCT)
    Call<CreditModel> updateCreditProduct(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body CreditModel pojoCreditProductModel);
}