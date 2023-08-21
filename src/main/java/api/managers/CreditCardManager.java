package api.managers;

import api.models.controllers.AllCreditCardsModel;
import api.models.controllers.CreditCardModel;
import api.services.CreditCardService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CreditCardManager extends BaseManager {

    private CreditCardService creditCardService = initialise(BASE_URL).create(CreditCardService.class);

    public Response<CreditCardModel> createCreditCard(CreditCardModel pojoCreditCardModel) {
        Call<CreditCardModel> call = creditCardService.createCreditCard(TokenManager.getToken(), pojoCreditCardModel);
        return getResponse(call);
    }

    public Response<CreditCardModel> updateCreditCard(String id, CreditCardModel pojoCreditCardModel) {
        Call<CreditCardModel> call = creditCardService.updateCreditCard(TokenManager.getToken(), id, pojoCreditCardModel);
        return getResponse(call);
    }

    public Response<AllCreditCardsModel> getAllCreditCardsOfCurrentUser(int page, int size, String sort) {
        Call<AllCreditCardsModel> call = creditCardService
                .getAllCreditCardsOfCurrentUser(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CreditCardModel> getCreditCardById(String id) {
        Call<CreditCardModel> call = creditCardService.getCreditCardById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> deactivateCreditCard(String id) {
        Call<Void> call = creditCardService.deactivateCreditCard(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> activateCreditCard(String id) {
        Call<Void> call = creditCardService.activateCreditCard(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
