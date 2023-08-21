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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;


@Feature(API_ACCOUNT_CONTROLLER)
public class GetAccountUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6195790")
    @Test(description = "Get all accounts", groups = {"Api"})
    public void c6195790() {
        Response<AllAccountsModel> response = accountApiStep.getAllAccounts(0, 100, "ASC");
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6196527")
    @Test(description = "Get account by id", groups = {"Api"})
    public void c6196527() {
        Response<AccountModel> testAccount = createAccount();
        String id = testAccount.body().getId();
        Response<AccountModel> response = accountApiStep.getAccountById(id);
        checkResponseCode(response, HTTP_OK);
        AccountModel accountModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ACCOUNT_BY_ID, id),
                AccountModel.class);
        accountApiStep.checkAccount(accountModelSql, response.body());
        checkAll();
    }

    @TestRails(id = "C6197070")
    @Test(description = "Get accounts with owner id", groups = {"Api"})
    public void c6197070() {
        Response<AllAccountsModel> response = accountApiStep.getAccountsWithOwnerId(userId);
        checkResponseCode(response, HTTP_OK);
        List<AccountModel> sqlOwnerAccounts = DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_ACCOUNTS_WITH_OWNER_ID,
                userId), AccountModel.class);
        accountApiStep.checkAllAccounts(response.body().getContent(), sqlOwnerAccounts);
        checkAll();
    }

    @TestRails(id = "C6197075")
    @Test(description = "Get account's info by accounts number", groups = {"Api"})
    public void c6197075() {
        Response<AccountModel> response = accountApiStep
                .getAccountByAccountNumber(GlobalData.VALID_ACCOUNT_NUMBER);
        checkResponseCode(response, HTTP_OK);
        AccountModel sqlAccount = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ACCOUNT_BY_ACCOUNT_NUMBER,
                VALID_ACCOUNT_NUMBER), AccountModel.class);
        Assert.assertEquals(response.body(), sqlAccount);
    }

    @TestRails(id = "C6096614")
    @Test(description = "Trying to get an account by invalid id", groups = {"Api"})
    public void c6096614() {
        Response<AccountModel> response = accountApiStep.getAccountById(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6275663")
    @Test(description = "Trying to get an accounts with invalid owner id", groups = {"Api"})
    public void c6275663() {
        Response<AllAccountsModel> response = accountApiStep
                .getAccountsWithOwnerId(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
