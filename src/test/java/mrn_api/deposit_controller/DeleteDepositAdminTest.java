package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDeposit;

import static constants.GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT;
import static constants.enums.Role.ADMIN;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteDepositAdminTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C6135532")
    @Test(description = "Delete deposit with valid data, role Admin", groups = {"Api"})
    public void C6135532() {
        authorization(USER);
        Response<DepositModel> responseCreateDeposit = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        String depositId = responseCreateDeposit.body().getId();
        checkResponseCode(responseCreateDeposit, HTTP_OK);
        authorization(ADMIN);
        depositApiStep.deleteDepositByID(depositId);
        Response<DepositModel> responseIsDepositExist = depositApiStep
                .getDepositById(depositId);
        checkResponseCode(responseIsDepositExist, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6135534")
    @Test(description = "Delete deposit with non-existent data, role Admin", groups = {"Api"})
    public void C6135534() {
        authorization(ADMIN);
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_NON_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6135535")
    @Test(description = "Delete two times deposit with valid data, role Admin", groups = {"Api"})
    public void C6135535() {
        authorization(USER);
        Response<DepositModel> responseCreateDeposit = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        String depositId = responseCreateDeposit.body().getId();
        authorization(ADMIN);
        depositApiStep.deleteDepositByID(depositId);
        Response<DepositModel> responseDeleteDeposit = depositApiStep
                .deleteDepositByID(depositId);
        checkResponseCode(responseDeleteDeposit, HTTP_NOT_FOUND);
        checkAll();
    }
}
