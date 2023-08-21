package mrn_api.account_controller;

import api.models.controllers.AccountModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.GlobalData.*;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

public class GetAdminAccountByIdBankAndCurrencyNameTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6188780")
    @Test(description = "Get account by X-User-Id, bank name and currency 'USD', valid values, role 'ADMIN'", groups = {"Api"})
    public void c6188780() {
        getAccountByCurrency(USD);
    }

    @TestRails(id = "C6188781")
    @Test(description = "Get account by X-User-Id, bank name and currency 'EUR', valid values, role 'ADMIN'", groups = {"Api"})
    public void c6188781() {
        getAccountByCurrency(EUR);
    }

    @TestRails(id = "C6188782")
    @Test(description = "Get account by X-User-Id, bank name and currency 'RUB', valid values, role 'ADMIN'", groups = {"Api"})
    public void c6188782() {
        getAccountByCurrency(RUB);
    }

    @TestRails(id = "C6192798")
    @Test(description = "Get account by invalid X-User-Id, bank name and currency, role 'ADMIN'", groups = {"Api"})
    public void c6192798() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getInvalidNumber(),
                        FakeGenerator.getInvalidNumber(), FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6192871")
    @Test(description = "Get account by non-existent X-User-Id, bank name and currency, role 'ADMIN'", groups = {"Api"})
    public void c6192871() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getUserId(),
                        FakeGenerator.getRandomBank(), FakeGenerator.getFakeCurrency());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6192830")
    @Test(description = "Get account by valid X-User-Id, invalid bank name and currency, role 'ADMIN'", groups = {"Api"})
    public void c6192830() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(VALID_ID_FOR_PAYMENT_SERVICE,
                        FakeGenerator.getInvalidNumber(), FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6192866")
    @Test(description = "Get account by invalid X-User-Id, non-existent bank name and valid currency, role 'ADMIN'", groups = {"Api"})
    public void c6192866() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getInvalidNumber(),
                        FakeGenerator.getRandomBank(), USD);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6192873")
    @Test(description = "Get account by non-existent X-User-Id, valid bank name and non-existent currency, role 'ADMIN'", groups = {"Api"})
    public void c6192873() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getUserId(),
                        BANK_NAME, FakeGenerator.getFakeCurrency());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
