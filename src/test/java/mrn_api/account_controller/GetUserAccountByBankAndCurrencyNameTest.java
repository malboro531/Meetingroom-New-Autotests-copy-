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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

public class GetUserAccountByBankAndCurrencyNameTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6188753")
    @Test(description = "Get account by X-User-Id, bank name and currency 'USD', valid values, role 'USER'", groups = {"Api"})
    public void c6188753() {
        getAccountByCurrency(USD);
    }

    @TestRails(id = "C6188778")
    @Test(description = "Get account by X-User-Id, bank name and currency 'EUR', valid values, role 'USER'", groups = {"Api"})
    public void c6188778() {
        getAccountByCurrency(EUR);
    }

    @TestRails(id = "C6188779")
    @Test(description = "Get account by X-User-Id, bank name and currency 'RUB', valid values, role 'USER'", groups = {"Api"})
    public void c6188779() {
        getAccountByCurrency(RUB);
    }

    @TestRails(id = "C6192799")
    @Test(description = "Get account by invalid X-User-Id, bank name and currency, role 'USER'", groups = {"Api"})
    public void c6192799() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getInvalidNumber(),
                        FakeGenerator.getInvalidNumber(), FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6192870")
    @Test(description = "Get account by non-existent X-User-Id, bank name and currency, role 'USER'", groups = {"Api"})
    public void c6192870() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getUserId(),
                        FakeGenerator.getRandomBank(), FakeGenerator.getFakeCurrency());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6192832")
    @Test(description = "Get account by invalid X-User-Id, invalid bank name and non-existent currency, role 'USER'", groups = {"Api"})
    public void c6192832() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getInvalidNumber(),
                        FakeGenerator.getInvalidNumber(), FakeGenerator.getFakeCurrency());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6192868")
    @Test(description = "Get account by non-existent X-User-Id, non-existent bank name and invalid currency, role 'USER'", groups = {"Api"})
    public void c6192868() {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(FakeGenerator.getUserId(),
                        FakeGenerator.getRandomBank(), FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
