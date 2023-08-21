package api.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static constants.ApiDataBase.USER_AUTHENTICATION;
import static constants.ApiDataBase.USER_LOGOUT;
import static constants.ApiInterfaceServicesData.API_AUTHORIZATION;
import static constants.ApiInterfaceServicesData.API_REFRESH_TOKEN;

public interface AuthenticationService {

    @GET(USER_AUTHENTICATION)
    Call<Void> userAuthentication(@Header(API_AUTHORIZATION) String token);

    @POST(USER_LOGOUT)
    Call<Void> userLogout(@Header(API_REFRESH_TOKEN) String refreshToken);
}
