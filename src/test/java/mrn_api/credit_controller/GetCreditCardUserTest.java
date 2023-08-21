package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllCreditCardsModel;
import api.models.controllers.CreditCardModel;
import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_CARD_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY;
import static constants.GlobalData.VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER;
import static constants.enums.Currency.USD;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditCardUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6230411")
    @Test(description = "Get all credit cards of current user, valid data, role - USER", groups = {"Api"})
    public void c6230411() {
        Response<AllCreditCardsModel> response = creditCardApiStep
                .getAllCreditCardsOfCurrentUser(0, 10, Strings.EMPTY);

        checkResponseCode(response, HTTP_OK);
        creditCardApiStep.checkAllCreditCards(creditCardDataBaseManager
                .getCountAllById(userId), response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6230324")
    @Test(description = "Get credit card by id, valid data, role - USER", groups = {"Api"})
    public void c6230324() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId());
        creditCardModel.setAccountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_USER);
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_OK);
        Response<CreditCardModel> response = creditCardApiStep.getCreditCardById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
        creditCardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_BY_ID, responseCreate.body().getId());
    }
}
