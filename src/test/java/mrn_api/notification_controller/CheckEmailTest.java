package mrn_api.notification_controller;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTest;
import verification.VerifySoft;

import static constants.AllureData.API_NOTIFICATION_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_NOTIFICATION_CONTROLLER)
public class CheckEmailTest extends BaseApiTest {

    @TestRails(id = "C5953883")
    @Test(description = "Check email for blocking", groups = {"Api"})
    public void getCheckEmail() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        Response<String> response = notificationApiStep.getCheckEmail();
        VerifySoft.verifyFalseSoft(Boolean.parseBoolean(response.body()), "Email blocked");
        checkResponseCode(response, HTTP_OK);
        notificationApiStep.checkAll();

    }
}
