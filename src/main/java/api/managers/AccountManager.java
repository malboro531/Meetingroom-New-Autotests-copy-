package api.managers;

import api.models.controllers.AccountModel;
import api.models.controllers.AllAccountsModel;
import api.models.controllers.CurrencyType;
import api.services.AccountService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class AccountManager extends BaseManager {

    private AccountService accountService = initialise(BASE_URL).create(AccountService.class);

    public Response<AllAccountsModel> getAllAccounts(int page, int size, String sort) {
        Call<AllAccountsModel> call = accountService
                .getAllAccounts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<AccountModel> getAccountById(String id) {
        Call<AccountModel> call = accountService
                .getAccountById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllAccountsModel> getAccountsWithOwnerId(String ownerId) {
        Call<AllAccountsModel> call = accountService
                .getAccountsWithOwnerId(TokenManager.getToken(), ownerId);
        return getResponse(call);
    }

    public Response<AccountModel> getAccountByAccountNumber(String accountNumber) {
        Call<AccountModel> call = accountService
                .getAccountByAccountNumber(TokenManager.getToken(), accountNumber);
        return getResponse(call);
    }

    public Response<AccountModel> createAccount(CurrencyType currencyType) {
        Call<AccountModel> call = accountService
                .createAccount(TokenManager.getToken(), currencyType);
        return getResponse(call);
    }

    public Response<AccountModel> updateAccount(AccountModel account) {
        Call<AccountModel> call = accountService
                .updateAccount(TokenManager.getToken(), account);
        return getResponse(call);
    }

    public Response<List<AccountModel>> getAccountByIdBankNameAndCurrency(String xUserId, String bankName, String currency) {
        Call<List<AccountModel>> call = accountService
                .getAccountByIdBankNameAndCurrency(TokenManager.getToken(), xUserId, bankName, currency);
        return getResponse(call);
    }
}
