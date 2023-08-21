package mrn_api.account_controller;

import api.models.controllers.AccountModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.GlobalData.*;
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class GetUnauthorizedAccountByIdBankAndCurrencyNameTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6192791")
    @Test(description = "Get account by X-User-Id, bank name and currency 'USD', valid values, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192791() {
        getUnauthorizedAccountByCurrency(USD);
    }

    @TestRails(id = "C6192792")
    @Test(description = "Get account by X-User-Id, bank name and currency 'EUR', valid values, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192792() {
        getUnauthorizedAccountByCurrency(EUR);
    }

    @TestRails(id = "C6192793")
    @Test(description = "Get account by X-User-Id, bank name and currency 'RUB', valid values, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192793() {
        getUnauthorizedAccountByCurrency(RUB);
    }

    @TestRails(id = "C6192800")
    @Test(description = "Get account by invalid X-User-Id, bank name and currency, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192800() {
        getUnauthorizedAccountByValues(FakeGenerator.getInvalidNumber(),
                FakeGenerator.getInvalidNumber(), FakeGenerator.getInvalidNumber());
    }

    @TestRails(id = "C6192872")
    @Test(description = "Get account by non-existent X-User-Id, bank name and currency, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192872() {
        getUnauthorizedAccountByValues(FakeGenerator.getUserId(),
                FakeGenerator.getRandomBank(), FakeGenerator.getFakeCurrency());
    }

    @TestRails(id = "C6192831")
    @Test(description = "Get account by valid X-User-Id, non-existent bank name and currency, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192831() {
        getUnauthorizedAccountByValues(VALID_ID_FOR_PAYMENT_SERVICE,
                FakeGenerator.getRandomBank(), FakeGenerator.getFakeCurrency());
    }

    @TestRails(id = "C6192867")
    @Test(description = "Get account by invalid X-User-Id, valid bank name and invalid currency, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192867() {
        getUnauthorizedAccountByValues(FakeGenerator.getInvalidNumber(),
                BANK_NAME, FakeGenerator.getInvalidNumber());
    }

    @TestRails(id = "C6192874")
    @Test(description = "Get account by non-existent X-User-Id, invalid bank name and valid currency, role 'UNAUTHORIZED'", groups = {"Api"})
    public void c6192874() {
        getUnauthorizedAccountByValues(FakeGenerator.getUserId(),
                FakeGenerator.getInvalidNumber(), USD);
    }

    private void getUnauthorizedAccountByCurrency(String currency) {
        Response<List<AccountModel>> response = accountApiStep.getAccountByIdBankNameAndCurrency(
                VALID_ID_FOR_PAYMENT_SERVICE, BANK_NAME, currency);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    private void getUnauthorizedAccountByValues(String userId, String bankName, String currency) {
        Response<List<AccountModel>> response = accountApiStep.getAccountByIdBankNameAndCurrency(
                userId, bankName, currency);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
