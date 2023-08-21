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
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateAccountAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6114558")
    @Test(description = "Create account with currency RUB", groups = {"Api"})
    public void c6114458() {
        createAccount(Currency.RUB.getCurrency());
    }

    @TestRails(id = "C6114486")
    @Test(description = "Create account with currency EUR", groups = {"Api"})
    public void c6114486() {
        createAccount(Currency.EUR.getCurrency());
    }

    @TestRails(id = "C6114487")
    @Test(description = "Create account with currency USD", groups = {"Api"})
    public void c6114487() {
        createAccount(Currency.USD.getCurrency());
    }

    @TestRails(id = "C6114559")
    @Test(description = "Create account with invalid currency", groups = {"Api"})
    public void c6114559() {
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
