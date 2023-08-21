package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditModel;
import api.services.TestRails;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToCreditModel;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6100019")
    @Test(description = "Get credit product by id with valid data, role Admin", groups = {"Api"})
    public void c6100019() {
        Response<CreditModel> responseCreate = creditProductApiStep
                .createCreditProduct(JsonToCreditModel.getPojoCreditProductModel());
        Response<CreditModel> response = creditProductApiStep.getCreditProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        CreditModel creditModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PRODUCT_BY_ID,
                responseCreate.body().getId()), CreditModel.class);
        creditProductApiStep.checkCreditProductInDataBase(response.body(), creditModelSql);
        checkAll();
    }

    @TestRails(id = "C6214041")
    @Test(description = "Get all credit products, role - ADMIN", groups = {"Api"})
    public void c6214041() {
        Response<AllCreditAccountsModel> response = creditProductApiStep
                .getAllCreditProducts(0, 200, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditProductApiStep.checkCountOfAllCreditProducts(creditProductDBManager.getCountAllCreditProducts(),
                response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6100020")
    @Test(description = "Get all active credit products", groups = {"Api"})
    public void c6100020() {
        Response<AllCreditAccountsModel> response = creditProductApiStep
                .getAllActiveCreditProducts(0, 100, "");
        checkResponseCode(response, HTTP_OK);
        creditProductApiStep.checkAllActiveCreditProducts(response.body());
        checkAll();
    }
}
