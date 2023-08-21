package api.services;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;
import static constants.ApiInterfaceServicesData.API_SORT;

public interface CreditAccountService {

    @GET(GET_ALL_CREDIT_ACCOUNTS)
    Call<AllCreditAccountsModel> getAllCreditAccounts(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                                      @Query(API_SORT) String sort);

    @GET(GET_CREDIT_ACCOUNT_BY_ID)
    Call<CreditAccountsModel> getCreditAccountById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_CREDIT_ACCOUNTS_BY_OWNER_ID)
    Call<AllCreditAccountsModel> getCreditAccountByOwnerId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                                           @Query(API_SORT) String sort);

    @GET(GET_TRANSFER_INFO_BY_CREDIT_ACCOUNT_NUMBER)
    Call<CreditAccountsModel> getCreditTransferByAccountNumber(@Header(API_AUTHORIZATION) String token, @Path(API_CREDIT_ACCOUNT_NUMBER) String creditAccountNumber);
}
