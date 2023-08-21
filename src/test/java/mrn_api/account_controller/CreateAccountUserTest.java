package mrn_api.account_controller;

import api.models.controllers.AccountModel;
import api.models.controllers.CurrencyType;
import api.services.TestRails;
import constants.enums.Currency;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_ACCOUNT_BY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class CreateAccountUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6197118")
    @Test(description = "Create account with currency RUB", groups = {"Api"})
    public void c6197118() {
        createAccount(Currency.RUB.getCurrency());
    }

    @TestRails(id = "C6197116")
    @Test(description = "Create account with currency EUR", groups = {"Api"})
    public void c6197116() {
        createAccount(Currency.EUR.getCurrency());
    }

    @TestRails(id = "C6197117")
    @Test(description = "Create account with currency USD", groups = {"Api"})
    public void c6197117() {
        createAccount(Currency.USD.getCurrency());
    }

    @TestRails(id = "C6276193")
    @Test(description = "Create account with invalid currency", groups = {"Api"})
    public void c6276193() {
        CurrencyType currencyType = new CurrencyType(FakeGenerator.getFakeCurrency());
        Response<AccountModel> response = accountApiStep.createAccount(currencyType);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    public void createAccount(String currency) {
        CurrencyType currencyType = new CurrencyType(currency);
        Response<AccountModel> response = accountApiStep.createAccount(currencyType);
        checkResponseCode(response, HTTP_OK);
        listOfCreatedAccount.add(response.body().getId());
        accountDbManager.deleteFromDataBaseById(SQL_DELETE_ACCOUNT_BY_ID, response.body().getId());
        checkAll();
    }
}