package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDeposit;

import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class CreateDepositUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6135482")
    @Test(description = "Create deposit with valid data, role Unauthorized", groups = {"Api"})
    public void C6135482() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6135485")
    @Test(description = "Create deposit with non-existent data, role Unauthorized", groups = {"Api"})
    public void C6135485() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModelNonExistent());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6135487")
    @Test(description = "Create two deposits with valid data, role Unauthorized", groups = {"Api"})
    public void C6135487() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
