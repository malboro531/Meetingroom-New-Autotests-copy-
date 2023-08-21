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
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class DeleteUserAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initialToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C5944601")
    @Test(description = "User deleting with existing id", groups = {"Api"})
    public void c5944601() {
        Response<UserModel> responseCreate = userApiStep.createUser(FakeGenerator.generateFakeUser());
        Response<Void> responseDelete = userApiStep.deleteUser(responseCreate.body().getId());
        checkResponseCode(responseDelete, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C5944602")
    @Test(description = "Error deleting user with non-existing id", groups = {"Api"})
    public void c5944602() {
        String fakeId = FakeGenerator.generateUuid();
        Response<Void> response = userApiStep.deleteUser(fakeId);
        checkResponseCode(response, HTTP_NOT_FOUND);
        userApiStep.checkResponseTextBody(response, "Not found User with " + fakeId + " id");
        checkAll();
    }
}
