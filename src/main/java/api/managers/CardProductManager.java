package api.managers;

import api.models.controllers.AllCardProductModel;
import api.models.controllers.CardProductModel;
import api.services.CardProductService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CardProductManager extends BaseManager {

    private CardProductService cardProductService = initialise(BASE_URL).create(CardProductService.class);

    public Response<CardProductModel> createCardProduct(CardProductModel cardProductModel) {
        Call<CardProductModel> call = cardProductService.createCardProduct(TokenManager.getToken(), cardProductModel);
        return getResponse(call);
    }

    public Response<CardProductModel> deleteCardProduct(String id) {
        Call<CardProductModel> call = cardProductService.deleteCardProduct(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<CardProductModel> updateCardProduct(CardProductModel cardProduct) {
        Call<CardProductModel> call = cardProductService.updateCardProduct(TokenManager.getToken(), cardProduct);
        return getResponse(call);
    }

    public Response<AllCardProductModel> getAllCardProducts(int page, int size, String sort) {
        Call<AllCardProductModel> call = cardProductService.getAllCardProducts(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CardProductModel> getCardProductById(String id) {
        Call<CardProductModel> call = cardProductService.getCardProductById(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
