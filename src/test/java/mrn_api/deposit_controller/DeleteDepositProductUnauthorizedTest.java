package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositProductModel;
import api.services.TestRails;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_DEPOSIT_PRODUCT_CONTROLLER;
import static constants.GlobalData.VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT;
import static constants.GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT;
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DeleteDepositProductUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6137111")
    @Test(description = "Delete deposit product by id with valid data, role Unauthorized", groups = {"Api"})
    public void C6137111() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137113")
    @Test(description = "Delete deposit product by id with non-existent data, role Unauthorized", groups = {"Api"})
    public void C6137113() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137114")
    @Test(description = "Delete previously deleted deposit product by id with valid data, role Unauthorized", groups = {"Api"})
    public void C6137114() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
