package mrn_api.user_controller;

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
public class CreateUserAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C5941159")
    @Test(description = "User creating with valid data", groups = {"Api"})
    public void c5941159() {
        Response<UserModel> responseCreate = userApiStep.createUser(FakeGenerator.generateFakeUser());
        checkResponseCode(responseCreate, HTTP_OK);
        userApiStep.deleteUser(responseCreate.body().getId());
        checkAll();
    }
}
