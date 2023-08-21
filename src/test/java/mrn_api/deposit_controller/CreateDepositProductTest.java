package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositProductModel;
import api.models.controllers.deposit.PojoDepositProductModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProduct;

import static constants.ApiDataBase.SQL_DELETE_DEPOSIT_PRODUCT_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_DEPOSIT_PRODUCT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

public class CreateDepositProductTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6137058")
    @Test(description = " Create Deposit product , role Admin", groups = {"Api"})
    public void C6137058() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(response, HTTP_OK);
        DepositProductModel depositProductModelSql = depositProductDBManager
                .getById(SQL_SELECT_DEPOSIT_PRODUCT_BY_ID, response.body().getId());
        depositProductApiStep.checkCreatedDepositProductInDataBase(response.body(), depositProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6137060")
    @Test(description = " Create Deposit product, invalid data, role Admin", groups = {"Api"})
    public void C6137060() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModelInvalidData());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6137061")
    @Test(description = " Create Deposit product, non-existent data, role Admin ", groups = {"Api"})
    public void C6137061() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137062")
    @Test(description = "Create two deposit products with valid equal data , role Admin", groups = {"Api"})
    public void C6137062() {
        Response<PojoDepositProductModel> responseOne = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseOne, HTTP_OK);
        String depositProductOneId = responseOne.body().getId();
        Response<PojoDepositProductModel> responseTwo = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseTwo, HTTP_OK);
        String depositProductTwoId = responseTwo.body().getId();
        depositProductApiStep.checkDifferentDepositProductsWithId(depositProductOneId, depositProductTwoId);
        depositProductDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_PRODUCT_BY_ID, depositProductOneId);
        depositProductDBManager.deleteFromDataBaseById(SQL_DELETE_DEPOSIT_PRODUCT_BY_ID, depositProductTwoId);
        checkAll();
    }
}
