package api.managers;

import api.models.TokenModel;
import api.services.TokenService;
import constants.ApiDataBase;
import org.apache.logging.log4j.util.Strings;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.*;

public class TokenManager extends BaseManager {

    protected static String token;

    private static TokenModel tokenModel;
    private TokenService tokenService = initialise(ApiDataBase.BASE_URL).create(TokenService.class);

    public void getTokenModel() {
        Call<TokenModel> call = tokenService.getToken(URL_KEYCLOAK, CONTENT_TYPE_KEYCLOAK, CLIENT_ID_KEYCLOAK, USERNAME_KEYCLOAK, PASSWORD_KEYCLOAK, GRANT_TYPE_KEYCLOAK);
        Response<TokenModel> response = getResponse(call);
        tokenModel = response.body();
    }

    public TokenModel getTokenModel(String login, String password) {
        Call<TokenModel> call = tokenService.getToken(URL_KEYCLOAK, CONTENT_TYPE_KEYCLOAK, CLIENT_ID_KEYCLOAK, login, password, GRANT_TYPE_KEYCLOAK);
        Response<TokenModel> response = getResponse(call);
        return tokenModel = response.body();
    }

    public static String getToken() {
        if (tokenModel == null) token = Strings.EMPTY;
        else token = BEARER + tokenModel.getAccessToken();
        return token;
    }

    public String getRefreshToken() {
        assert tokenModel != null;
        return tokenModel.getRefreshToken();
    }

    public void resetToken() {
        tokenModel = null;
    }
}
