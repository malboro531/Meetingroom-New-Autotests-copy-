package api.services;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static constants.ApiEndpoints.SEND_PUSH_NOTIFICATION;
import static constants.ApiInterfaceServicesData.API_AUTHORIZATION;

public interface PushNotificationService {

    // FIXME
    @POST(SEND_PUSH_NOTIFICATION)
    Call<Void> sendPushNotification(@Header(API_AUTHORIZATION) String token);
}
