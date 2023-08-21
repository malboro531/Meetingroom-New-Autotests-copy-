package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_PRODUCT_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateCreditProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6214033")
    @Test(description = " Create Credit product, role Admin", groups = {"Api"})
    public void C6214033() {
        CreditModel creditProduct = FakeGenerator.generateFakeCreditProduct();
        Response<CreditModel> response = creditProductApiStep.createCreditProduct(creditProduct);
        checkResponseCode(response, HTTP_OK);
        CreditModel creditModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PRODUCT_BY_ID,
                response.body().getId()), CreditModel.class);
        creditProductApiStep.checkCreditProductInDataBase(response.body(), creditModelSql);
        checkAll();
        creditProductDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_PRODUCT_BY_ID, response.body().getId());
    }
}
