package mrn_api.user_controller;

import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.enums.Role.*;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class GetUsersUserTest extends BaseApiTestUsingDataBase {

    @BeforeMethod
    public void initiateToken() {
        authorization(USER);
    }

    private UserModel createUser() {
        authorization(ADMIN);
        Response<UserModel> response = userApiStep.createUser(FakeGenerator.generateFakeUser());
        checkResponseCode(response, HTTP_OK);
        checkAll();
        return response.body();
    }

    @TestRails(id = "C6312831")
    @Test(description = "Get all users, role USER", groups = {"Api"})
    public void c6312831() {
        Response<AllUsersModel> response = userApiStep.getAllUsers(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6224453")
    @Test(description = "Get user information by phone number, role USER", groups = {"Api"})
    public void c6224453() {
        Response<UserModel> response = userApiStep.getUserInfoByPhoneNumber(createUser().getPhone());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
        userApiStep.deleteUser(createUser().getId());
    }

    @TestRails(id = "C6224532")
    @Test(description = "Get user information by phone number, role UNAUTHORIZED", groups = {"Api"})
    public void c6224532() {
        authorization(UNAUTHORIZED);
        Response<UserModel> response = userApiStep.getUserInfoByPhoneNumber(userPhone);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6313034")
    @Test(description = "Get current user, role USER", groups = {"Api"})
    public void c6313034() {
        Response<UserModel> response = userApiStep.getUser();
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6275242")
    @Test(description = "Get user by user id, role USER", groups = {"Api"})
    public void c6275242() {
        Response<UserModel> response = userApiStep.getUserById(createUser().getId());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
        userApiStep.deleteUser(createUser().getId());
    }
}
