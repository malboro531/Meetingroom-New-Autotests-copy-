package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditCardModel;
import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY;
import static constants.enums.Currency.USD;
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class CreateCreditCardUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    public String getCreditCardProductId() {
        return DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId();
    }

    @TestRails(id = "C6312879")
    @Test(description = "Create Credit card, valid data, role - Unauthorized", groups = {"Api"})
    public void c6312879() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
