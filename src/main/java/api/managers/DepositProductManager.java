package api.managers;

import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.*;
import api.services.DepositProductService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class DepositProductManager extends BaseManager {

    private DepositProductService depositProductService = initialise(BASE_URL).create(DepositProductService.class);

    public Response<DepositProductModel> getDepositProductById(String id) {
        Call<DepositProductModel> call = depositProductService
                .getDepositProductById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllDepositProductsModel> getAllDepositProducts(int page, int size) {
        Call<AllDepositProductsModel> call = depositProductService
                .getAllDepositProducts(TokenManager.getToken(), page,size);
        return getResponse(call);
    }

    public Response<AllDepositProductsModel> getDepositProductByNameAndCurrency(int page, int size, String depositName, String currencyName) {
        Call<AllDepositProductsModel> call = depositProductService
                .getDepositProductByNameAndCurrency(TokenManager.getToken(),
                page, size,depositName, currencyName);
        return getResponse(call);
    }

    public Response<PojoDepositProductModel> createDepositProduct(PojoDepositProductModel pojoDepositProductModel) {
        Call<PojoDepositProductModel> call = depositProductService
                .createDepositProduct(TokenManager.getToken(), pojoDepositProductModel);
        return getResponse(call);
    }

    public Response<Void> editDepositProduct(PojoDepositProductEditModel pojoDepositProductEditModel) {
        Call<Void> call = depositProductService
                .editDepositProduct(TokenManager.getToken(), pojoDepositProductEditModel);
        return getResponse(call);
    }

    public Response<DepositProductModel> deleteDepositProductById(String id) {
        Call<DepositProductModel> call = depositProductService
                .deleteDepositProductById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<List<Currency>> getAllCurrenciesForDeposit() {
        Call<List<Currency>> call = depositProductService
                .getAllCurrencies(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<List<Type>> getAllTypesForDeposit() {
        Call<List<Type>> call = depositProductService
                .getAllTypesForDepositProducts(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<AllSortDepositProductModel> getFilteredDepositProducts(int page, int size, String sort) {
        Call<AllSortDepositProductModel> call = depositProductService
                .getFilteredDepositProducts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }
}
