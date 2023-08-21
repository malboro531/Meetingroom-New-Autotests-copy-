package api.services;

import api.models.TokenModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiInterfaceServicesData.*;

public interface TokenService {

    @FormUrlEncoded
    @POST
    Call<TokenModel> getToken(@Url String url,
                              @Header(API_CONTENT_TYPE) String contentType,
                              @Field(API_CLIENT_ID) String client_id,
                              @Field(API_USERNAME) String username,
                              @Field(API_PASSWORD) String password,
                              @Field(API_GRANT_TYPE) String grant_type);
}
