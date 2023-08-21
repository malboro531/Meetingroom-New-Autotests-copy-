package steps.api;

import api.managers.NotificationManager;
import api.models.controllers.NotificationModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

public class NotificationApiStep {
    private NotificationManager notificationManager = new NotificationManager();

    @Step("Send email notification")
    public Response<Void> sendEmailNotification() {
        return notificationManager.sendEmailNotification();
    }

    @Step("Get email notification")
    public Response<NotificationModel> getEmailNotificationAll() {
        return notificationManager.getEmailNotificationAll();
    }

    @Step("Check email for blocking")
    public Response<String> getCheckEmail() {
        return notificationManager.getCheckEmail();
    }

    @Step("Confirm email notification")
    public Response<String> confirmEmailNotification(int code) {
        return notificationManager.confirmEmailNotification(code);
    }

    public void checkAll() {
        VerifySoft.showAllChecking();
    }
}
