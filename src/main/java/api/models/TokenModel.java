package api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TokenModel {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private int expiresIn;
    @SerializedName("refresh_expires_in")
    private int refreshExpiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("id_token")
    private String idToken;
    @SerializedName("not-before-policy")
    private int notBeforePolicy;
    @SerializedName("session_state")
    private String sessionState;
    private String scope;
}
