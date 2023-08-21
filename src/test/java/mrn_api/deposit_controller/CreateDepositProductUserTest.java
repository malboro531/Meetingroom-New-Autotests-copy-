package mrn_api.deposit_controller;

import api.models.controllers.deposit.PojoDepositProductModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProduct;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class CreateDepositProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6137063")
    @Test(description = "Create Deposit product , role User", groups = {"Api"})
    public void C6137063() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137065")
    @Test(description = "Create Deposit product, non-existent data, role User ", groups = {"Api"})
    public void C6137065() {
        Response<PojoDepositProductModel> response = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137066")
    @Test(description = "Create two deposit products with valid equal data , role User", groups = {"Api"})
    public void C6137066() {
        Response<PojoDepositProductModel> responseOne = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseOne, HTTP_FORBIDDEN);
        checkAll();
    }
}
