package mrn_api.user_controller;

import api.managers.DataBaseManager.DataBaseConnectionManager;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class UpdateUserWithoutFieldsTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5942977")
    @Test(description = "User updating without patronymic", groups = {"Api"})
    public void userUpdatingWithoutPatronymic() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPatronymic(null);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @Ignore
    @TestRails(id = "C5943033")
    @Test(description = "Error updating user without id", groups = {"Api"})
    public void errorUpdatingUserWithoutId() {
        updateUserNegative("id", CODE_CLIENT_ERROR_BAD_REQUEST, "User id can't be null.");
    }

    @TestRails(id = "C5942980")
    @Test(description = "Error updating user without first name", groups = {"Api"})
    public void errorUpdatingUserWithoutFirstName() {
        updateUserNegative("first name", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_USER_FIRST_NAME_CANT_BE_NULL);
    }

    @TestRails(id = "C5942981")
    @Test(description = "Error updating user without last name", groups = {"Api"})
    public void errorUpdatingUserWithoutLastName() {
        updateUserNegative("last name", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_USER_LAST_NAME_CANT_BE_NULL);
    }

    @TestRails(id = "C5942982")
    @Test(description = "Error updating user without email", groups = {"Api"})
    public void errorUpdatingUserWithoutEmail() {
        updateUserNegative("email", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_EMAIL_CANT_BE_NULL);
    }

    @TestRails(id = "C5942983")
    @Test(description = "Error updating user without phone", groups = {"Api"})
    public void errorUpdatingUserWithoutPhone() {
        updateUserNegative("phone", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_PHONE_NUMBER_CANT_BE_NULL);
    }

    private void updateUserNegative(String emptyField, int responseCode, String errorMessage) {
        UserModel user = FakeGenerator.generateFakeUser();
        switch (emptyField) {
            case "id" -> user.setId(null);
            case "first name" -> user.setFirstName(null);
            case "last name" -> user.setLastName(null);
            case "email" -> user.setEmail(null);
            case "phone" -> user.setPhone(null);
        }
        Response<Void> response = userApiStep.createUser(user);
        checkResponseCode(response, responseCode);
        userApiStep.checkResponseTextBody(response, errorMessage);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
