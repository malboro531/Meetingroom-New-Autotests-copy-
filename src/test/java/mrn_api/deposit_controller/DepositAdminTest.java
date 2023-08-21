package mrn_api.deposit_controller;

import api.models.controllers.deposit.DepositModel;
import api.services.TestRails;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_DEPOSIT_CONTROLLER;
import static constants.GlobalData.VALID_ID_FOR_EXISTENT_DEPOSIT;
import static constants.GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@Feature(API_DEPOSIT_CONTROLLER)
public class DepositAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6135489")
    @Test(description = "Get deposit by id with valid data, role Admin", groups = {"Api"})
    public void C6135489() {
        Response<DepositModel> response = depositApiStep
                .getDepositById(VALID_ID_FOR_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6135491")
    @Test(description = "Get deposit by id with non-existent data, role Admin", groups = {"Api"})
    public void C6135491() {
        Response<DepositModel> response = depositApiStep
                .getDepositById(VALID_ID_FOR_NON_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
