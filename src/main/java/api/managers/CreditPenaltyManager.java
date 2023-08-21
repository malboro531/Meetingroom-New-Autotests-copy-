package api.managers;

import api.models.controllers.CreditPenaltyModel;
import api.services.CreditPenaltyService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CreditPenaltyManager extends BaseManager {

    private CreditPenaltyService creditPenaltyService = initialise(BASE_URL).create(CreditPenaltyService.class);

    public Response<CreditPenaltyModel> createCreditPenalty(CreditPenaltyModel pojoCreditPenaltyModel) {
        Call<CreditPenaltyModel> call = creditPenaltyService
                .createCreditPenalty(TokenManager.getToken(), pojoCreditPenaltyModel);
        return getResponse(call);
    }

    public Response<CreditPenaltyModel> updateCreditPenalty(String id, CreditPenaltyModel pojoCreditPenaltyModel) {
        Call<CreditPenaltyModel> call = creditPenaltyService
                .updateCreditPenalty(TokenManager.getToken(), id, pojoCreditPenaltyModel);
        return getResponse(call);
    }

    public Response<CreditPenaltyModel> getCreditPenaltyById(String id) {
        Call<CreditPenaltyModel> call = creditPenaltyService
                .getCreditPenaltyById(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
