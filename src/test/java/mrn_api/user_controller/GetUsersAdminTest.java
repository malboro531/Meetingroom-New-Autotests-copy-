package mrn_api.user_controller;

import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class GetUsersAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6312830")
    @Test(description = "Get all users, role Admin", groups = {"Api"})
    public void c6312830() {
        Response<AllUsersModel> response = userApiStep.getAllUsers(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6223923")
    @Test(description = "Get user information by phone number, role Admin", groups = {"Api"})
    public void c6223923() {
        Response<UserModel> response = userApiStep.getUserInfoByPhoneNumber(userPhone);
        userApiStep.verifyFieldsNotNull(response.body());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6312988")
    @Test(description = "Get current user, role Admin", groups = {"Api"})
    public void c6312988() {
        Response<UserModel> response = userApiStep.getUser();
        userApiStep.verifyFieldsNotNull(response.body());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6316693")
    @Test(description = "Get user by user id, role Admin", groups = {"Api"})
    public void c6316693() {
        Response<UserModel> user = userApiStep.createUser(FakeGenerator.generateFakeUser());
        String userId = user.body().getId();
        Response<UserModel> response = userApiStep.getUserById(userId);
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body());
        userApiStep.deleteUser(response.body().getId());
        checkAll();
    }
}
