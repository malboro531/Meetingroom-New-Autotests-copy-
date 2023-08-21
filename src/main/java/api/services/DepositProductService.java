package api.services;

import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface DepositProductService {

    @POST(CREATE_DEPOSIT_PRODUCT)
    Call<PojoDepositProductModel> createDepositProduct(@Header(API_AUTHORIZATION) String token, @Body PojoDepositProductModel pojoDepositProductModel);

    @GET(GET_DEPOSIT_PRODUCT_BY_ID)
    Call<DepositProductModel> getDepositProductById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_All_DEPOSIT_PRODUCTS)
    Call<AllDepositProductsModel> getAllDepositProducts(@Header(API_AUTHORIZATION) String token,
                                                        @Query(API_PAGE) int page, @Query(API_SIZE) int size);

    @GET(GET_DEPOSIT_PRODUCT_BY_NAME_AND_CURRENCY)
    Call<AllDepositProductsModel> getDepositProductByNameAndCurrency(@Header(API_AUTHORIZATION) String token,
                                                                     @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                                                     @Query(API_DEPOSIT_NAME) String depositName,
                                                                     @Query(API_CURRENCY_NAME) String currencyName);

    @PUT(UPDATE_DEPOSIT_PRODUCT)
    Call<Void> editDepositProduct(@Header(API_AUTHORIZATION) String token,
                                  @Body PojoDepositProductEditModel pojoDepositProductEditModel);

    @DELETE(DELETE_DEPOSIT_PRODUCT_BY_ID)
    Call<DepositProductModel> deleteDepositProductById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ALL_CURRENCIES_FOR_DEPOSIT_PRODUCTS)
    Call<List<Currency>> getAllCurrencies(@Header(API_AUTHORIZATION) String token);

    @GET(GET_ALL_TYPES_FOR_DEPOSIT_PRODUCTS)
    Call<List<Type>> getAllTypesForDepositProducts(@Header(API_AUTHORIZATION) String token);

    @GET(GET_FILTERED_DEPOSIT_PRODUCTS)
    Call<AllSortDepositProductModel> getFilteredDepositProducts(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE)
    int page, @Query(API_SIZE) int size, @Query(API_SORT) String sort);
}
