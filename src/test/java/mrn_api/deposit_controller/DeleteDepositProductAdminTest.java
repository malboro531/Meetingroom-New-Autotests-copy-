package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositProductModel;
import api.models.controllers.deposit.PojoDepositProductModel;
import api.services.TestRails;
import constants.GlobalData;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProduct;

import static constants.AllureData.API_DEPOSIT_PRODUCT_CONTROLLER;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DeleteDepositProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6137102")
    @Test(description = "Delete deposit product by id with valid data, role Admin", groups = {"Api"})
    public void C6137102() {
        Response<PojoDepositProductModel> responseCreateDepositProduct = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseCreateDepositProduct, HTTP_OK);
        depositProductApiStep.deleteDepositProductByID(responseCreateDepositProduct.body().getId());
        Response<DepositProductModel> responseIsDepositProductExist = depositProductApiStep
                .getDepositProductById(responseCreateDepositProduct.body().getId());
        checkResponseCode(responseIsDepositProductExist, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137104")
    @Test(description = "Delete deposit product by id with non-existent data, role Admin", groups = {"Api"})
    public void C6137104() {
        Response<DepositProductModel> responseDeleteDepositProduct = depositProductApiStep
                .deleteDepositProductByID(GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositProduct, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137105")
    @Test(description = "Delete previously deleted deposit product by id with valid data, role Admin", groups = {"Api"})
    public void C6137105() {
        Response<PojoDepositProductModel> responseCreateDepositProduct = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseCreateDepositProduct, HTTP_OK);
        depositProductApiStep.deleteDepositProductByID(responseCreateDepositProduct.body().getId());
        Response<DepositProductModel> responseDeleteDepositProduct = depositProductApiStep
                .deleteDepositProductByID(responseCreateDepositProduct.body().getId());
        checkResponseCode(responseDeleteDepositProduct, HTTP_NOT_FOUND);
        checkAll();
    }
}
