package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDeposit;

import static constants.ApiDataBase.SQL_DELETE_DEPOSIT_BY_ID;
import static constants.GlobalData.VALID_ID_FOR_EXISTENT_DEPOSIT;
import static constants.GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT;
import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class DeleteDepositUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6135536")
    @Test(description = "Delete deposit with valid data, role User", groups = {"Api"})
    public void C6135536() {
        Response<DepositModel> responseCreateDeposit = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        String depositId = responseCreateDeposit.body().getId();
        checkResponseCode(responseCreateDeposit, HTTP_OK);
        Response<DepositModel> response = depositApiStep.deleteDepositByID(depositId);
        checkResponseCode(response, HTTP_FORBIDDEN);
        depositDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_BY_ID, depositId);
        checkAll();
    }

    @TestRails(id = "C6135538")
    @Test(description = "Delete deposit with non-existent data, role User", groups = {"Api"})
    public void C6135538() {
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_NON_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6135539")
    @Test(description = "Delete two times deposit with valid data, role User", groups = {"Api"})
    public void C6135539() {
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6135540")
    @Test(description = "Delete deposit with valid data, role Unauthorized", groups = {"Api"})
    public void C6135540() {
        authorization(UNAUTHORIZED);
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6135542")
    @Test(description = "Delete deposit with non-existent data, role Unauthorized", groups = {"Api"})
    public void C6135542() {
        authorization(UNAUTHORIZED);
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_NON_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6135543")
    @Test(description = "Delete two times deposit with valid data, role Unauthorized", groups = {"Api"})
    public void C6135543() {
        authorization(UNAUTHORIZED);
        Response<DepositModel> response = depositApiStep
                .deleteDepositByID(VALID_ID_FOR_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
