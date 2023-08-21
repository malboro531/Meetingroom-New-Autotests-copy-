package api.services;

import api.models.controllers.NotificationModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.API_AUTHORIZATION;

public interface NotificationService {


    @GET(SEND_EMAIL_NOTIFICATION)
    Call<Void> sendEmailNotification(@Header(API_AUTHORIZATION) String token);

    @GET(GET_EMAIL_NOTIFICATION)
    Call<NotificationModel> getEmailNotification(@Header(API_AUTHORIZATION) String token);

    @GET(CHECK_EMAIL)
    Call<String> getCheckEmail(@Header(API_AUTHORIZATION) String token);

    @POST(CONFIRM_EMAIL_NOTIFICATION)
    Call<String> confirmEmailNotification(@Header(API_AUTHORIZATION) String token, @Body int code);
}
