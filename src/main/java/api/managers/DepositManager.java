package api.managers;

import api.models.controllers.deposit.*;
import api.services.DepositService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class DepositManager extends BaseManager {

    private DepositService depositService = initialise(BASE_URL).create(DepositService.class);

    public Response<DepositModel> getDepositById(String id) {
        Call<DepositModel> call = depositService.getDepositById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<DepositModel> createDeposit(DepositModel depositModel) {
        Call<DepositModel> call = depositService.createDeposit(TokenManager.getToken(), depositModel);
        return getResponse(call);
    }

    public Response<DepositModel> deleteDepositById(String id) {
        Call<DepositModel> call = depositService.deleteDepositById(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
