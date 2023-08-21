package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDeposit;

import static constants.ApiDataBase.SQL_DELETE_DEPOSIT_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_DEPOSIT_BY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateDepositUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6134989")
    @Test(description = "Create deposit with valid data, role User", groups = {"Api"})
    public void C6134989() {
        Response<DepositModel> responseCreateDeposit = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        String depositId = responseCreateDeposit.body().getId();
        checkResponseCode(responseCreateDeposit, HTTP_OK);
        DepositModel depositModelSql = depositDBManager.getById(SQL_SELECT_DEPOSIT_BY_ID, depositId);
        depositApiStep.checkCreatedDepositInDataBase(responseCreateDeposit.body(), depositModelSql);
        depositDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_BY_ID, depositId);
        checkAll();
    }

    @TestRails(id = "C6134992")
    @Test(description = "Create deposit with non-existent data, role User", groups = {"Api"})
    public void C6134992() {
        Response<DepositModel> response = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModelNonExistent());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6134993")
    @Test(description = "Create two deposits with valid equal data, role User", groups = {"Api"})
    public void C6134993() {
        Response<DepositModel> responseCreateDepositFirst = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(responseCreateDepositFirst, HTTP_OK);
        String depositOneId = responseCreateDepositFirst.body().getId();
        Response<DepositModel> responseCreateDepositSecond = depositApiStep
                .createDeposit(JsonToPojoDeposit.getDepositModel());
        checkResponseCode(responseCreateDepositSecond, HTTP_OK);
        String depositTwoId = responseCreateDepositSecond.body().getId();
        depositApiStep.checkDifferentDepositsWithId(depositOneId, depositTwoId);
        depositDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_BY_ID, depositOneId);
        depositDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_BY_ID, depositTwoId);
        checkAll();
    }
}
