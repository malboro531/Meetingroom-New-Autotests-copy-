package api.managers;

import api.models.controllers.NotificationModel;
import api.services.NotificationService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class NotificationManager extends BaseManager {
    private NotificationService notificationService = initialise(BASE_URL).create(NotificationService.class);

    public Response<Void> sendEmailNotification() {
        Call<Void> call = notificationService.sendEmailNotification(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<NotificationModel> getEmailNotificationAll() {
        Call<NotificationModel> call = notificationService.getEmailNotification(TokenManager.getToken());
        Response<NotificationModel> response = getResponse(call);
        return response;
    }

    public Response<String> getCheckEmail() {
        Call<String> call = notificationService.getCheckEmail(TokenManager.getToken());
        Response<String> response = getResponse(call);
        return response;
    }

    public Response<String> confirmEmailNotification(int code) {
        Call<String> call = notificationService.confirmEmailNotification(TokenManager.getToken(), code);
        return getResponse(call);
    }

}
