package mrn_api.user_controller;

import api.managers.DataBaseManager.DataBaseConnectionManager;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.CODE_CLIENT_ERROR_NOT_FOUND;
import static constants.ApiDataBase.CODE_SUCCESS_OK;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class UpdateUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5942967")
    @Test(description = "User updating by id valid data", groups = {"Api"})
    public void userUpdatingByIdValidData() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5942975")
    @Test(description = "Error updating user by non-existent id", groups = {"Api"})
    public void errorUpdatingUserNonExistentById() {
        String id = "100";
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_NOT_FOUND);
        userApiStep.checkResponseTextBody(response, "Not found User with 100 id");
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
