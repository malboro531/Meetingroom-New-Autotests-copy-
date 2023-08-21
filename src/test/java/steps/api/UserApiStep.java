package steps.api;

import api.managers.UserManager;
import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;
import verification.VerifySoft;

public class UserApiStep {

    UserManager userManager = new UserManager();

    @Step("Delete user by id")
    public Response<Void> deleteUser(String id) {
        return userManager.deleteUser(id);
    }

    @Step("Update user by id")
    public Response<Void> updateUserById(String id, UserModel user) {
        return userManager.updateUserById(id, user);
    }

    @Step("Create user")
    public <T> Response<T> createUser(UserModel user) {
        return userManager.createUser(user);
    }

    @Step("Get current user by token")
    public Response<UserModel> getUser(){
        return userManager.getUser();
    }

    @Step("Get user by id")
    public Response<UserModel> getUserById(String userId) {
        return userManager.getUsersById(userId);
    }

    @Step("Compare user")
    public void checkUser(UserModel user, UserModel userModelSql) {
        VerifySoft.verifyEqualsSoft(user.getId(), userModelSql.getId(), "");
        VerifySoft.verifyEqualsSoft(user.getFirstName(), userModelSql.getFirstName(), "");
        VerifySoft.verifyEqualsSoft(user.getLastName(), userModelSql.getLastName(), "");
        VerifySoft.verifyEqualsSoft(user.getPatronymic(), userModelSql.getPatronymic(), "");
        VerifySoft.verifyEqualsSoft(user.getEmail(), userModelSql.getEmail(), "");
        VerifySoft.verifyEqualsSoft(user.getPhone(), userModelSql.getPhone(), "");
    }

    @Step("Check count of user in Data Base")
    public void checkAllUsers(Integer dbCount, Integer responseCount) {
        Verify.verifyEquals(dbCount, responseCount, "Count of users in DataBase matches with response count");
    }

    @Step("Get all users")
    public Response<AllUsersModel> getAllUsers(int page, int size, String sort) {
        return userManager.getUsers(page, size, sort);
    }

    @Step("Check response text")
    public <T> void checkResponseTextBody(Response<T> response, String expectedMessage) {
        VerifySoft.verifyEqualsSoft(userManager.getErrorMessage(response), expectedMessage, "");
    }

    @Step("Get user information by phone number")
    public Response<UserModel> getUserInfoByPhoneNumber(String phone) {
        return userManager.getUserInfoByPhoneNumber(phone);
    }

    @Step("Verify that all fields in response body 'get user personal data' are not null")
    public void verifyFieldsNotNull(UserModel userModel) {
        Verify.verifyNotNull(userModel.getId(), "There is id in response body");
        Verify.verifyNotNull(userModel.getUsername(), "There is user name in response body");
        Verify.verifyNotNull(userModel.getFirstName(), "There is first name in response body");
        Verify.verifyNotNull(userModel.getLastName(), "There is last name in response body");
        Verify.verifyNotNull(userModel.getPatronymic(), "There is patronymic in response body");
        Verify.verifyNotNull(userModel.getEmail(), "There is email in response body");
        Verify.verifyNotNull(userModel.getPhone(), "There is phone in response body");
    }
}
