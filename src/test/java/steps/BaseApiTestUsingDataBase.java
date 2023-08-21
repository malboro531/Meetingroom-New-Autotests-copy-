package steps;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.managers.DataBaseManager.DataBaseConnectionManager;
import api.managers.UserManager;
import api.models.controllers.*;
import constants.enums.Currency;
import constants.enums.Role;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import retrofit2.Response;
import verification.VerifySoft;

import java.util.ArrayList;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.*;
import static java.net.HttpURLConnection.HTTP_OK;

public class BaseApiTestUsingDataBase extends BaseApiTest {

    protected String userId;
    protected String passportId;
    protected String addressId;
    protected String firstName;
    protected String lastName;
    protected String userPhone;
    protected List<String> listOfCreatedAccount = new ArrayList<>();
    protected int DEFAULT_PAGE_DB_REQUEST = 0;
    protected int DEFAULT_SIZE_DB_REQUEST = 10;
    protected String DEFAULT_SORT_DB_REQUEST = Strings.EMPTY;

    public void authorization(Role userRole) {
        switch (userRole) {
            case ADMIN -> tokenManager.getTokenModel(VALID_LOGIN_ADMIN, VALID_PASSWORD_ADMIN);
            case USER -> tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
            case UNAUTHORIZED -> {
                tokenManager.resetToken();
                return;
            }
        }
        UserManager userManager = new UserManager();

        userId = userManager.getUser().body().getId();
        passportId = String.valueOf(DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID, userId),
                PassportModel.class).getId());
        addressId = String.valueOf(DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID, userId),
                AddressModel.class).getId());
        firstName = userManager.getUser().body().getFirstName();
        lastName = userManager.getUser().body().getLastName();
        userPhone = userManager.getUser().body().getPhone();
    }

    public Response<AccountModel> createAccount() {
        CurrencyType currencyType = new CurrencyType(Currency.EUR.getCurrency());
        Response<AccountModel> response = accountApiStep.createAccount(currencyType);
        return response;
    }

    @BeforeClass
    public void baseDbBeforeClass() {
        DataBaseConnectionManager.createConnection();
    }

   @AfterSuite
    public void removeCreatedAccounts() {
        listOfCreatedAccount
                .forEach(accountDbManager::deleteAccount);
        listOfCreatedAccount.clear();
        DataBaseConnectionManager.closeConnection();
    }

    public void getAccountByCurrency(String currency) {
        Response<List<AccountModel>> response = accountApiStep
                .getAccountByIdBankNameAndCurrency(VALID_ID_FOR_PAYMENT_SERVICE, BANK_NAME, currency);
        checkResponseCode(response, HTTP_OK);
        List<AccountModel> sqlAccount = DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_ACCOUNT_BY_BANK_NAME_AND_CURRENCY,
                VALID_ID_FOR_PAYMENT_SERVICE, BANK_NAME, currency), AccountModel.class);
        VerifySoft.verifyEqualsSoft(response.body(), sqlAccount, ERROR_MESSAGE_INVALID_CURRENCY_NAME);
    }

    public Response<CardProductModel> createCardProduct() {
        CardProductModel cardProductModel = FakeGenerator.generateFakeCardProduct();
        Response<CardProductModel> response = cardProductApiStep.createCardProduct(cardProductModel);
        checkResponseCode(response, HTTP_OK);
        return response;
    }
}
