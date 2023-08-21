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
import static constants.ApiDataBase.*;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class CreateUserWithoutFieldsAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initialToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C5942442")
    @Test(description = "User creating without patronymic", groups = {"Api"})
    public void c5942442() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPatronymic(null);
        Response<UserModel> responseCreate = userApiStep.createUser(user);
        checkResponseCode(responseCreate, CODE_SUCCESS_OK);
        userApiStep.deleteUser(responseCreate.body().getId());
        checkAll();
    }

    @TestRails(id = "C5944282")
    @Test(description = "User creating without username", groups = {"Api"})
    public void c5944282() {
        createUserNegative("username", HTTP_BAD_REQUEST, ERROR_MESSAGE_USERNAME_CANT_BE_NULL);
    }

    @TestRails(id = "C5942441")
    @Test(description = "Error creating user without first name", groups = {"Api"})
    public void c5942441() {
        createUserNegative("first name", HTTP_BAD_REQUEST, ERROR_MESSAGE_USER_FIRST_NAME_CANT_BE_NULL);
    }

    @TestRails(id = "C5942932")
    @Test(description = "Error creating user without last name", groups = {"Api"})
    public void c5942932() {
        createUserNegative("last name", HTTP_BAD_REQUEST, ERROR_MESSAGE_USER_LAST_NAME_CANT_BE_NULL);
    }

    @TestRails(id = "C5942933")
    @Test(description = "Error creating user without email", groups = {"Api"})
    public void c5942933() {
        createUserNegative("email", HTTP_BAD_REQUEST, ERROR_MESSAGE_EMAIL_CANT_BE_NULL);
    }

    @TestRails(id = "C5942934")
    @Test(description = "Error creating user without phone", groups = {"Api"})
    public void c5942934() {
        createUserNegative("phone", HTTP_BAD_REQUEST, ERROR_MESSAGE_PHONE_NUMBER_CANT_BE_NULL);
    }

    private void createUserNegative(String emptyField, int responseCode, String errorMessage) {
        UserModel user = FakeGenerator.generateFakeUser();
        switch (emptyField) {
            case "username" -> user.setUsername(null);
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
}
