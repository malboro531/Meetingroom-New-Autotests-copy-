package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditCardModel;
import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER;
import static constants.enums.Currency.USD;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class CreateCreditCardUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    public String getCreditCardProductId() {
        return DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId();
    }

    @TestRails(id = "C6230299")
    @Test(description = "Create Credit card, valid data, role - USER", groups = {"Api"})
    public void c6230299() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_OK);
        CreditCardModel creditCardModelSQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_BY_ID,
                responseCreate.body().getId()), CreditCardModel.class);
        creditCardApiStep.checkCreditCardInDataBase(responseCreate.body(), creditCardModelSQL);
        checkAll();
        creditCardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_BY_ID, responseCreate.body().getId());
    }

    @TestRails(id = "C6312840")
    @Test(description = "Create Credit card with invalid account_id, role - USER", groups = {"Api"})
    public void c6312840() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.getRandomString());
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312842")
    @Test(description = "Create Credit card with not existing account_id, role - USER", groups = {"Api"})
    public void C6312842() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.generateUuid());
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6312898")
    @Test(description = "Create Credit card with empty account_id, role - USER", groups = {"Api"})
    public void c6312898() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.generateUuid());
        creditCardModel.setCardProductId(Strings.EMPTY);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312843")
    @Test(description = "Create Credit card with invalid card_product_id, role - USER", groups = {"Api"})
    public void c6312843() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(FakeGenerator.getRandomString());
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312845")
    @Test(description = "Create Credit card with not existing card_product_id, role - USER", groups = {"Api"})
    public void c6312845() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(FakeGenerator.generateUuid());
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6312899")
    @Test(description = "Create Credit card with empty card_product_id, role - USER", groups = {"Api"})
    public void c6312899() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(Strings.EMPTY);
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312852")
    @Test(description = "Create Credit card with empty holder_name, role - USER", groups = {"Api"})
    public void c6312852() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        creditCardModel.setHolderName(Strings.EMPTY);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }
}
