package mrn_api.user_controller;

import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
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
public class CreateUserWithEmptyFieldsAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C5942125")
    @Test(description = "User creating with empty userName", groups = {"Api"})
    public void c5942125() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setUsername(Strings.EMPTY);
        Response<Void> response = userApiStep.createUser(user);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5941270")
    @Test(description = "Error creating user with empty first name", groups = {"Api"})
    public void c5941270() {
        createUserNegative("first name", HTTP_BAD_REQUEST, ERROR_MESSAGE_INVALID_FIRST_NAME);
    }

    @TestRails(id = "C5942061")
    @Test(description = "Error creating user with empty last name", groups = {"Api"})
    public void c5942061() {
        createUserNegative("last name", HTTP_BAD_REQUEST, ERROR_MESSAGE_INVALID_LAST_NAME);
    }

    @TestRails(id = "C5942062")
    @Test(description = "Error creating user with empty patronymic", groups = {"Api"})
    public void c5942062() {
        createUserNegative("patronymic", HTTP_BAD_REQUEST, ERROR_MESSAGE_INVALID_PATRONYMIC);
    }

    @TestRails(id = "C5942063")
    @Test(description = "Error creating user with empty email", groups = {"Api"})
    public void c5942063() {
        createUserNegative("email", HTTP_BAD_REQUEST, ERROR_MESSAGE_INVALID_EMAIL);
    }

    @TestRails(id = "C5942064")
    @Test(description = "Error creating user with empty phone", groups = {"Api"})
    public void c5942064() {
        createUserNegative("phone", HTTP_BAD_REQUEST, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
    }

    private void createUserNegative(String emptyField, int responseCode, String errorMessage) {
        UserModel user = FakeGenerator.generateFakeUser();
        switch (emptyField) {
            case "first name" -> user.setFirstName(Strings.EMPTY);
            case "last name" -> user.setLastName(Strings.EMPTY);
            case "patronymic" -> user.setPatronymic(Strings.EMPTY);
            case "email" -> user.setEmail(Strings.EMPTY);
            case "phone" -> user.setPhone(Strings.EMPTY);
        }
        Response<Void> response = userApiStep.createUser(user);
        checkResponseCode(response, responseCode);
        userApiStep.checkResponseTextBody(response, errorMessage);
        checkAll();
    }
}
