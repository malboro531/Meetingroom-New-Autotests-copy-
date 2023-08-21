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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DeleteDepositProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6137106")
    @Test(description = "Delete deposit product by id with valid data, role User", groups = {"Api"})
    public void C6137106() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137108")
    @Test(description = "Delete deposit product by id with non-existent data, role User", groups = {"Api"})
    public void C6137108() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137110")
    @Test(description = "Delete previously deleted deposit product by id with valid data, role User", groups = {"Api"})
    public void C6137110() {
        Response<DepositProductModel> responseDeleteDepositModel =
                depositProductApiStep.deleteDepositProductByID(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseDeleteDepositModel, HTTP_FORBIDDEN);
        checkAll();
    }
}
