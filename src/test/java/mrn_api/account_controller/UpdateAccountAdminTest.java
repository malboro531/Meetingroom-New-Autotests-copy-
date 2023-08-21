package mrn_api.account_controller;

import api.models.controllers.AccountModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_ACCOUNT_CONTROLLER;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@Feature(API_ACCOUNT_CONTROLLER)
public class UpdateAccountAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6299210")
    @Test(description = "account updating by valid data as Admin", groups = {"Api"})
    public void c6299210() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        Response<AccountModel> testAccount = createAccount();
        account.setId(testAccount.body().getId());
        account.setOwnerId(testAccount.body().getOwnerId());
        Response<AccountModel> response = accountApiStep.updateAccount(account);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6179879")
    @Test(description = "account updating by valid but not-existing user Id  ", groups = {"Api"})
    public void c6179879() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        account.setOwnerId(createAccount().body().getOwnerId());
        Response<AccountModel> response = accountApiStep.updateAccount(account);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "c6179884")
    @Test(description = "account updating by valid but not-existing owner id", groups = {"Api"})
    public void c6179884() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        account.setId(createAccount().body().getId());
        Response<AccountModel> response = accountApiStep.updateAccount(account);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}