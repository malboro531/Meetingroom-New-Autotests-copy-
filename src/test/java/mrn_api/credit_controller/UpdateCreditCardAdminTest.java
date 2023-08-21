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

import static constants.ApiDataBase.*;
import static constants.enums.Currency.RUB;
import static constants.enums.Currency.USD;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class UpdateCreditCardAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    public String getCreditCardProductId() {
        return DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId();
    }

    @TestRails(id = "C6230300")
    @Test(description = "Update credit card, valid data, role - ADMIN", groups = {"Api"})
    public void c6230300() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_OK);
        creditCardModel.setHolderName(String.valueOf(RUB));
        Response<CreditCardModel> responseUpdate = creditCardApiStep
                .updateCreditCard(responseCreate.body().getId(), creditCardModel);
        CreditCardModel creditCardModelSQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_BY_ID,
                responseCreate.body().getId()), CreditCardModel.class);
        creditCardApiStep.checkCreditCardInDataBase(responseUpdate.body(), creditCardModelSQL);
        checkAll();
        creditCardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_BY_ID, responseCreate.body().getId());
    }
}
