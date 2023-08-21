package mrn_api.transfer_controller;

import api.models.controllers.TransferModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetTransferMoneyController extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6223073")
    @Test(description = "Get all transfers , role Admin", groups = {"Api"})
    public void c6223073() {
        Response<List<TransferModel>> response = transferApiStep
                .getAllTransferForUser(userId, 0, 100, "");
        checkResponseCode(response, HTTP_OK);
        transferApiStep.checkAllTransferForUser(transferDBManager.getCountAll(userId), response.body().size());
        checkAll();
    }
}
