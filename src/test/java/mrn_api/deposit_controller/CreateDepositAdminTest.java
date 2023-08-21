package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDeposit;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

public class CreateDepositAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6135476")
    @Test(description = "Create deposit with valid data, role Admin", groups = {"Api"})
    public void C6135476() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6135478")
    @Test(description = "Create deposit with non-existent data, role Admin", groups = {"Api"})
    public void C6135478() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModelNonExistent());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6135479")
    @Test(description = "Create two deposits with valid data, role Admin", groups = {"Api"})
    public void C6135479() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
