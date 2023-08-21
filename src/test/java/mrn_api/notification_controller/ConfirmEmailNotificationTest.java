package mrn_api.notification_controller;

import api.managers.TokenManager;
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
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_NOTIFICATION_CONTROLLER)
public class ConfirmEmailNotificationTest extends BaseApiTest {

    @TestRails(id = "C5953886")
    @Test(description = "Confirm email notification", groups = {"Api"})
    public void confirmEmailNotification() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        int code = Integer.parseInt(notificationApiStep.getEmailNotificationAll().body().getCode());
        Response<String> response = notificationApiStep.confirmEmailNotification(code);
        VerifySoft.verifyTrueSoft(Boolean.parseBoolean(response.body()), "Wrong code sent or more than 1 minute has passed.");
        checkResponseCode(response, HTTP_OK);
        notificationApiStep.checkAll();
    }

}
