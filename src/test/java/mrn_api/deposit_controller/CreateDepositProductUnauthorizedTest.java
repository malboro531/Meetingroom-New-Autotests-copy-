package mrn_api.deposit_controller;

import api.models.controllers.deposit.PojoDepositProductModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProduct;

import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class CreateDepositProductUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6137067")
    @Test(description = "Create Deposit product , role Unauthorized", groups = {"Api"})
    public void C6137067() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137069")
    @Test(description = " Create Deposit product, non-existent data, role Unauthorized ", groups = {"Api"})
    public void C6137069() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137070")
    @Test(description = "Create two deposit products with valid equal data , role Unauthorized", groups = {"Api"})
    public void C6137070() {
        Response<PojoDepositProductModel> responseOne = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseOne, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
