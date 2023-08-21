package api.managers;

import api.models.controllers.CreditCardProductModel;
import api.services.CreditCardProductService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class CreditCardProductManager extends BaseManager {

    private CreditCardProductService creditCardProductService = initialise(BASE_URL).create(CreditCardProductService.class);

    public Response<CreditCardProductModel> createCreditCardProduct(CreditCardProductModel pojoCreditCardProductModel) {
        Call<CreditCardProductModel> call = creditCardProductService
                .createCreditCardProduct(TokenManager.getToken(), pojoCreditCardProductModel);
        return getResponse(call);
    }

    public Response<CreditCardProductModel> getCreditCardProductById(String id) {
        Call<CreditCardProductModel> call = creditCardProductService
                .getCreditCardProductById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<List<CreditCardProductModel>> getAllCreditCardProducts() {
        Call<List<CreditCardProductModel>> call = creditCardProductService
                .getAllCreditCardProducts(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<CreditCardProductModel> deleteCreditCardProduct(String id) {
        Call<CreditCardProductModel> call = creditCardProductService
                .deleteCreditCardProduct(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<CreditCardProductModel> updateCreditCardProduct(String id, CreditCardProductModel pojoCreditCardProductModel) {
        Call<CreditCardProductModel> call = creditCardProductService
                .updateCreditCardProduct(TokenManager.getToken(), id, pojoCreditCardProductModel);
        return getResponse(call);
    }
}
