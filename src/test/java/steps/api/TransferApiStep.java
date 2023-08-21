package steps.api;

import api.managers.TransferManager;
import api.models.controllers.TransferModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

import java.util.List;

public class TransferApiStep {

    private TransferManager transferManager = new TransferManager();

    @Step("Get all transfer for user")
    public Response<List<TransferModel>> getAllTransferForUser(String userId, int page, int size, String sort) {
        return transferManager.getAllTransferForUser(userId, page, size, sort);
    }

    public void checkAllTransferForUser(Integer baseCount, Integer responseCount) {
        VerifySoft.verifyEqualsSoft(baseCount, responseCount,
                "Count transfer in DataBase matches with response count");
    }

    @Step("Create request on transfer money")
    public Response<TransferModel> createRequestOnTransferMoney(TransferModel transferModel) {
        return transferManager.createRequestOnTransferMoney(transferModel);
    }
}