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
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.*;

@Feature(API_DEPOSIT_CONTROLLER)
public class DepositUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6135495")
    @Test(description = "Get deposit by id with valid data, role Unauthorized", groups = {"Api"})
    public void C6135495() {
        Response<DepositModel> response = depositApiStep
                .getDepositById(VALID_ID_FOR_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6135497")
    @Test(description = "Get deposit by id with non-existent data, role Unauthorized", groups = {"Api"})
    public void C6135497() {
        Response<DepositModel> response = depositApiStep
                .getDepositById(VALID_ID_FOR_NON_EXISTENT_DEPOSIT);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
