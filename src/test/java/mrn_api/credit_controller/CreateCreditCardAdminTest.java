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
import static constants.enums.Currency.USD;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

public class CreateCreditCardAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    public String getCreditCardProductId() {
        return DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId();
    }

    @TestRails(id = "C6230298")
    @Test(description = "Create Credit card, valid data, role - ADMIN", groups = {"Api"})
    public void c6230298() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_OK);
        CreditCardModel creditCardModelSQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_BY_ID,
                responseCreate.body().getId()), CreditCardModel.class);
        creditCardApiStep.checkCreditCardInDataBase(responseCreate.body(), creditCardModelSQL);
        checkAll();
        creditCardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_BY_ID, responseCreate.body().getId());
    }

    @TestRails(id = "C6312861")
    @Test(description = "Create Credit card with invalid account_id, role - ADMIN", groups = {"Api"})
    public void c6312861() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.getRandomString());
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312862")
    @Test(description = "Create Credit card with not existing account_id, role - ADMIN", groups = {"Api"})
    public void c6312862() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.generateUuid());
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6312900")
    @Test(description = "Create Credit card with empty account_id, role - ADMIN", groups = {"Api"})
    public void c6312900() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setAccountId(FakeGenerator.generateUuid());
        creditCardModel.setCardProductId(Strings.EMPTY);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312865")
    @Test(description = "Create Credit card with invalid card_product_id, role - ADMIN", groups = {"Api"})
    public void c6312865() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(FakeGenerator.getRandomString());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312867")
    @Test(description = "Create Credit card with not existing card_product_id, role - ADMIN", groups = {"Api"})
    public void c6312867() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(FakeGenerator.generateUuid());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6312902")
    @Test(description = "Create Credit card with empty card_product_id, role - ADMIN", groups = {"Api"})
    public void c6312902() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(Strings.EMPTY);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6312869")
    @Test(description = "Create Credit card with empty holder_name, role - ADMIN", groups = {"Api"})
    public void c6312869() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setHolderName(Strings.EMPTY);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_BAD_REQUEST);
        checkAll();
    }
}
