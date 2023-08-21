package api.managers;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import api.services.CreditAccountService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CreditAccountManager extends BaseManager {

    private CreditAccountService creditAccountService = initialise(BASE_URL).create(CreditAccountService.class);

    public Response<AllCreditAccountsModel> getAllCreditAccounts(int page, int size, String sort) {
        Call<AllCreditAccountsModel> call = creditAccountService
                .getAllCreditAccounts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CreditAccountsModel> getCreditAccountById(String id) {
        Call<CreditAccountsModel> call = creditAccountService
                .getCreditAccountById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllCreditAccountsModel> getCreditAccountsByOwnerId(String id, int page, int size, String sort) {
        Call<AllCreditAccountsModel> call = creditAccountService
                .getCreditAccountByOwnerId(TokenManager.getToken(), id, page, size, sort);
        return getResponse(call);
    }

    public Response<CreditAccountsModel> getCreditTransferByAccountNumber (String creditAccountNumber) {
        Call<CreditAccountsModel> call = creditAccountService
                .getCreditTransferByAccountNumber(TokenManager.getToken(), creditAccountNumber);
        return getResponse(call);
    }
}
