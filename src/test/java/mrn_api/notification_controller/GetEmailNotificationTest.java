package mrn_api.notification_controller;

import api.models.controllers.NotificationModel;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTest;

import static constants.AllureData.API_NOTIFICATION_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.GlobalData.*;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_NOTIFICATION_CONTROLLER)
public class GetEmailNotificationTest extends BaseApiTest {

    @TestRails(id = "C5953882")
    @Test(description = "Get all fields from email notification", groups = {"Api"})
    public void getNotificationAll() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        Response<NotificationModel> response = notificationApiStep.getEmailNotificationAll();
        checkResponseCode(response, HTTP_OK);
        notificationApiStep.checkAll();
    }
}
