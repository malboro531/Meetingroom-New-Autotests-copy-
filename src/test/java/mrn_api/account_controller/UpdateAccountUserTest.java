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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

@Feature(API_ACCOUNT_CONTROLLER)
public class UpdateAccountUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6175472")
    @Test(description = "account updating by valid data as USER", groups = {"Api"})
    public void с6175472() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        Response<AccountModel> testAccount = createAccount();
        account.setId(testAccount.body().getId());
        account.setOwnerId(testAccount.body().getOwnerId());
        Response<AccountModel> response = accountApiStep.updateAccount(FakeGenerator.generateFakeAccount());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6276208")
    @Test(description = "account updating by Invalid user Id ", groups = {"Api"})
    public void c6276208() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        account.setOwnerId(createAccount().body().getOwnerId());
        Response<AccountModel> response = accountApiStep.updateAccount(account);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6276211")
    @Test(description = "account updating by Invalid owner id", groups = {"Api"})
    public void c6276211() {
        AccountModel account = FakeGenerator.generateFakeAccount();
        account.setId(createAccount().body().getId());
        Response<AccountModel> response = accountApiStep.updateAccount(account);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
