package mrn_api.account_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AccountModel;
import api.models.controllers.AllAccountsModel;
import api.services.TestRails;
import constants.GlobalData;
import helpers.FakeGenerator;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.AllureData.API_ACCOUNT_CONTROLLER;
import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_ACCOUNT_NUMBER;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;


@Feature(API_ACCOUNT_CONTROLLER)
public class GetAccountAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6096313")
    @Test(description = "Get all accounts", groups = {"Api"})
    public void c6096313() {
        Response<AllAccountsModel> response = accountApiStep.getAllAccounts(0, 100, "");
        checkResponseCode(response, HTTP_OK);
        List<AccountModel> sqlAccounts = DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_ALL_FROM_ACCOUNT),
                AccountModel.class);
        accountApiStep.checkAllAccounts(response.body().getContent(), sqlAccounts);
        checkAll();
    }

    @TestRails(id = "C6096317")
    @Test(description = "Get account by id", groups = {"Api"})
    public void c6096317() {
        String id = createAccount().body().getId();
        Response<AccountModel> response = accountApiStep.getAccountById(id);
        checkResponseCode(response, HTTP_OK);
        AccountModel accountModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ACCOUNT_BY_ID, id),
                AccountModel.class);
        accountApiStep.checkAccount(accountModelSql, response.body());
        checkAll();
    }

    @TestRails(id = "C6096318")
    @Test(description = "Get accounts with owner id", groups = {"Api"})
    public void c6096318() {
        Response<AllAccountsModel> response = accountApiStep.getAccountsWithOwnerId(userId);
        checkResponseCode(response, HTTP_OK);
        List<AccountModel> sqlOwnerAccounts = DataBaseAbstractManager.getListInfoFromDB(String.format
                (SQL_SELECT_ACCOUNTS_WITH_OWNER_ID, userId), AccountModel.class);
        accountApiStep.checkAllAccounts(response.body().getContent(), sqlOwnerAccounts);
        checkAll();
    }

    @TestRails(id = "C6096614")
    @Test(description = "Trying to get an account by invalid id", groups = {"Api"})
    public void c6096614() {
        Response<AccountModel> response = accountApiStep.getAccountById(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096615")
    @Test(description = "Trying to get an accounts with invalid owner id", groups = {"Api"})
    public void c6096615() {
        Response<AllAccountsModel> response = accountApiStep
                .getAccountsWithOwnerId(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6197072")
    @Test(description = "Get account's info by accounts number", groups = {"Api"})
    public void c6197072() {
        Response<AccountModel> response = accountApiStep
                .getAccountByAccountNumber(GlobalData.VALID_ACCOUNT_NUMBER);
        checkResponseCode(response, HTTP_OK);
        AccountModel sqlAccount = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ACCOUNT_BY_ACCOUNT_NUMBER,
                VALID_ACCOUNT_NUMBER), AccountModel.class);
        Assert.assertEquals(response.body(), sqlAccount);
    }
}
