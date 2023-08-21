package api.managers;

import api.managers.DataBaseManager.DataBaseConnectionManager;
import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import api.services.UserService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;
import static constants.ApiDataBase.CODE_SUCCESS_OK;

public class UserManager extends BaseManager {

    private UserService userService = initialise(BASE_URL).create(UserService.class);

    public Response<Void> deleteUser(String id) {
        Call<Void> call = userService.deleteUser(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<UserModel> getUsersById(String userId) {
        Call<UserModel> call = userService.getUserById(TokenManager.getToken(), userId);
        return getResponse(call);
    }

    public Response<AllUsersModel> getUsers(int page, int size, String sort) {
        Call<AllUsersModel> call = userService.getAllUsers(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public <T> Response<T> createUser(UserModel user) {
        Call<UserModel> call = userService.createUser(TokenManager.getToken(), user);
        Response<UserModel> response = getResponse(call);
        if (response.code() == CODE_SUCCESS_OK) {
            DataBaseConnectionManager.addId(response.body().getId());
        }
        return (Response<T>) response;
    }

    public Response<Void> updateUserById(String id, UserModel user) {
        Call<Void> call = userService.updateUserById(TokenManager.getToken(), id, user);
        return getResponse(call);
    }

    public Response<UserModel> getUser() {
        Call<UserModel> call = userService.getUser(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<UserModel> getUserInfoByPhoneNumber(String phone) {
        Call<UserModel> call = userService.getUserInfoByPhoneNumber(TokenManager.getToken(), phone);
        return getResponse(call);
    }
}
