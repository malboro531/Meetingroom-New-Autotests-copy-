package api.services;

import api.models.controllers.AccountModel;
import api.models.controllers.AllAccountsModel;
import api.models.controllers.CurrencyType;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface AccountService {

    @GET(GET_ALL_ACCOUNTS)
    Call<AllAccountsModel> getAllAccounts(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                          @Query(API_SORT) String sort);

    @GET(GET_ACCOUNT_BY_ID)
    Call<AccountModel> getAccountById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ACCOUNTS_WITH_OWNER_ID)
    Call<AllAccountsModel> getAccountsWithOwnerId(@Header(API_AUTHORIZATION) String token, @Path(API_OWNER_ID) String ownerId);

    @GET(GET_ACCOUNT_BY_ACCOUNT_NUMBER)
    Call<AccountModel> getAccountByAccountNumber(@Header(API_AUTHORIZATION) String token,
                                                 @Path((API_ACCOUNT_NUMBER)) String accountNumber);

    @POST(CREATE_ACCOUNT)
    Call<AccountModel> createAccount(@Header(API_AUTHORIZATION) String token, @Body CurrencyType currencyType);

    @PUT(PUT_UPDATE_ACCOUNT)
    Call<AccountModel> updateAccount(@Header(API_AUTHORIZATION) String token, @Body AccountModel accountModel);

    @GET(GET_ACCOUNT_BY_BANK_NAME_AND_CURRENCY)
    Call<List<AccountModel>> getAccountByIdBankNameAndCurrency(@Header(API_AUTHORIZATION) String token,
                                                               @Header(API_X_USER_ID) String xUserId,
                                                               @Query(API_BANK_NAME) String bankName,
                                                               @Query(API_CURRENCY_NAME) String currency);
}
