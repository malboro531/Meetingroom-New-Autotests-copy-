package api.services;

import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface UserService {

    @DELETE(DELETE_USER_BY_ID)
    Call<Void> deleteUser(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_USER_BY_ID)
    Call<UserModel> getUserById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String userId);

    @GET(GET_ALL_USERS)
    Call<AllUsersModel> getAllUsers(@Header(API_AUTHORIZATION) String token,
                                    @Query(API_PAGE) int page,
                                    @Query(API_SIZE) int size,
                                    @Query(API_SORT) String sort);

    @POST(CREATE_USER)
    Call<UserModel> createUser(@Header(API_AUTHORIZATION) String token, @Body UserModel user);

    @PUT(UPDATE_USER_BY_ID)
    Call<Void> updateUserById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body UserModel user);

    @GET(GET_USER)
    Call<UserModel> getUser(@Header(API_AUTHORIZATION) String token);

    @GET(GET_USER_INFO_BY_PHONE_NUMBER)
    Call<UserModel> getUserInfoByPhoneNumber(@Header(API_AUTHORIZATION) String token, @Path(API_PHONE) String phone);
}
