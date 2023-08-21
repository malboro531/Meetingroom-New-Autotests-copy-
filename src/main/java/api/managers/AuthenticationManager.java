package api.managers;

import api.services.AuthenticationService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class AuthenticationManager extends BaseManager {

    private AuthenticationService authenticationService = initialise(BASE_URL).create(AuthenticationService.class);

    public Response<Void> auth(String token) {
        Call<Void> call = authenticationService.userAuthentication(token);
        return getResponse(call);
    }

    public Response<Void> userLogout(String refreshToken) {
        Call<Void> call = authenticationService.userLogout(refreshToken);
        return getResponse(call);
    }
}
