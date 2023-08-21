package api.managers;

import api.models.controllers.TransferModel;
import api.services.TransferService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class TransferManager extends BaseManager {

    private TransferService transferService = initialise(BASE_URL).create(TransferService.class);

    public Response<List<TransferModel>> getAllTransferForUser(String userId, int page, int size, String sort) {
        Call<List<TransferModel>> call = transferService
                .getAllTransferForUser(TokenManager.getToken(), userId, page, size, sort);
        return getResponse(call);
    }

    public Response<TransferModel> createRequestOnTransferMoney(TransferModel transferModel) {
        Call<TransferModel> call = transferService
                .createRequestOnTransferMoney(TokenManager.getToken(), transferModel);
        return getResponse(call);
    }
}