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

public class UpdateCreditProductAdminTest extends BaseApiTestUsingDataBase {
    private CreditModel creditProduct = FakeGenerator.generateFakeCreditProduct();

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6214038")
    @Test(description = "Update credit product, role - ADMIN", groups = {"Api"})
    public void c6214038() {
        Response<CreditModel> responseCreate = creditProductApiStep.createCreditProduct(creditProduct);
        checkResponseCode(responseCreate, HTTP_OK);
        creditProduct.setCreditName(FakeGenerator.getRandomString());
        Response<CreditModel> responseUpdate = creditProductApiStep
                .updateCreditProduct(responseCreate.body().getId(), creditProduct);
        checkResponseCode(responseUpdate, HTTP_OK);
        CreditModel creditModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PRODUCT_BY_ID,
                responseUpdate.body().getId()), CreditModel.class);
        creditProductApiStep.checkCreditProductInDataBase(responseUpdate.body(), creditModelSql);
        checkAll();
        creditProductDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_PRODUCT_BY_ID,
                responseUpdate.body().getId());
    }
}
