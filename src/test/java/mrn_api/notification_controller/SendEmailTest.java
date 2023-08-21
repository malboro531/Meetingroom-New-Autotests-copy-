package mrn_api.notification_controller;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTest;

import static constants.AllureData.API_NOTIFICATION_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.GlobalData.*;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_NOTIFICATION_CONTROLLER)
public class SendEmailTest extends BaseApiTest {

    @TestRails(id = "C5953737")
    @Test(description = "Send email notification", groups = {"Api"})
    public void sendNotification() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        Response<Void> response = notificationApiStep.sendEmailNotification();
        checkResponseCode(response, HTTP_OK);
        notificationApiStep.checkAll();
    }

}
