package steps.api;

import api.managers.AuthenticationManager;
import io.qameta.allure.Step;
import retrofit2.Response;

public class AuthenticationApiStep {

    private AuthenticationManager authenticationManager = new AuthenticationManager();

    @Step("User logout")
    public Response<Void> userLogout(String refreshToken) {
        return authenticationManager.userLogout(refreshToken);
    }

}
