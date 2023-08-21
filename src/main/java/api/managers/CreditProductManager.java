package api.managers;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditModel;
import api.services.CreditProductService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CreditProductManager extends BaseManager {

    private CreditProductService creditProductService = initialise(BASE_URL).create(CreditProductService.class);

    public Response<CreditModel> createCreditProduct(CreditModel pojoCreditProductModel) {
        Call<CreditModel> call = creditProductService
                .createCreditProduct(TokenManager.getToken(), pojoCreditProductModel);
        return getResponse(call);
    }

    public Response<CreditModel> getCreditProductById(String id) {
        Call<CreditModel> call = creditProductService.getCreditProductById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllCreditAccountsModel> getAllCreditProducts(int page, int size, String sort) {
        Call<AllCreditAccountsModel> call = creditProductService
                .getAllCreditProducts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<AllCreditAccountsModel> getAllActiveCreditProducts(int page, int size, String sort) {
        Call<AllCreditAccountsModel> call = creditProductService
                .getAllActiveCreditProducts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CreditModel> updateCreditProduct(String id, CreditModel pojoCreditProductModel) {
        Call<CreditModel> call = creditProductService
                .updateCreditProduct(TokenManager.getToken(), id, pojoCreditProductModel);
        return getResponse(call);
    }
}