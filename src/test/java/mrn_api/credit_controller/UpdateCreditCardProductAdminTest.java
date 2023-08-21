package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditCardProductModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_CARD_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class UpdateCreditCardProductAdminTest extends BaseApiTestUsingDataBase {
    private CreditCardProductModel creditCardProduct = FakeGenerator.generateFakeCreditCardProduct();

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6220976")
    @Test(description = "Update credit card product, role - ADMIN", groups = {"Api"})
    public void c6220976() {
        Response<CreditCardProductModel> responseCreate = creditCardProductApiStep
                .createCreditCardProduct(creditCardProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        creditCardProduct.setLoyaltyProgram(FakeGenerator.getRandomString());
        Response<CreditCardProductModel> responseUpdate = creditCardProductApiStep
                .updateCreditCardProduct(responseCreate.body().getId(), creditCardProduct);
        checkResponseCode(responseUpdate, HTTP_OK);
        CreditCardProductModel creditCardProductModelSql = DataBaseAbstractManager.getInfoFromDB
                (String.format(SQL_SELECT_CREDIT_CARD_PRODUCT_BY_ID, responseUpdate.body().getId()), CreditCardProductModel.class);
        creditCardProductApiStep.checkCreditCardProductInDataBase(responseUpdate.body(), creditCardProductModelSql);
        checkAll();
        creditCardProductDBManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID,
                responseUpdate.body().getId());
    }
}
