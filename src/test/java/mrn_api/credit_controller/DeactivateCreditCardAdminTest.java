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
import static constants.enums.Currency.USD;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeactivateCreditCardAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    public String getCreditCardProductId() {
        return DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY,
                String.valueOf(USD)), CreditCardProductModel.class).get(0).getId();
    }

    @TestRails(id = "C6230413")
    @Test(description = "Deactivate credit card, role - ADMIN", groups = {"Api"})
    public void c6230413() {
        CreditCardModel creditCardModel = FakeGenerator.generateFakeCreditCardWithCurrencyUSD();
        creditCardModel.setCardProductId(getCreditCardProductId());
        Response<CreditCardModel> responseCreate = creditCardApiStep.createCreditCard(creditCardModel);
        checkResponseCode(responseCreate, HTTP_OK);
        Response<Void> responseActivate = creditCardApiStep.activateCreditCard(responseCreate.body().getId());
        checkResponseCode(responseActivate, HTTP_OK);
        creditCardApiStep.checkCreditCardActiveStatus(DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_BY_ID,
                responseCreate.body().getId()), CreditCardModel.class).isActive());
        Response<Void> responseDeactivation = creditCardApiStep.deactivateCreditCard(responseCreate.body().getId());
        checkResponseCode(responseDeactivation, HTTP_OK);
        creditCardApiStep.checkCreditCardNotActiveStatus(DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_CARD_BY_ID,
                responseCreate.body().getId()), CreditCardModel.class).isActive());
        checkAll();
        creditCardDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_BY_ID, responseCreate.body().getId());
    }
}
