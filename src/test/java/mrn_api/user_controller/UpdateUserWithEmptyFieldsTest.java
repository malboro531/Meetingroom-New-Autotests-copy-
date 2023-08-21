package mrn_api.user_controller;

import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
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
public class UpdateUserWithEmptyFieldsTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @Ignore
    @TestRails(id = "C5944917")
    @Test(description = "Error updating user with empty id", groups = {"Api"})
    public void errorUpdatingUserWithEmptyId() {
        updateUserNegative("id", CODE_CLIENT_ERROR_BAD_REQUEST, "Invalid id.");
    }

    @TestRails(id = "C5944918")
    @Test(description = "Error updating user with empty first name", groups = {"Api"})
    public void errorUpdatingUserWithEmptyFirstName() {
        updateUserNegative("first name", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_FIRST_NAME);
    }

    @TestRails(id = "C5944919")
    @Test(description = "Error updating user with empty last name", groups = {"Api"})
    public void errorUpdatingUserWithEmptyLastName() {
        updateUserNegative("last name", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_LAST_NAME);
    }

    @TestRails(id = "C5944920")
    @Test(description = "Error updating user with empty patronymic", groups = {"Api"})
    public void errorUpdatingUserWithEmptyPatronymic() {
        updateUserNegative("patronymic", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_PATRONYMIC);
    }

    @TestRails(id = "C5944921")
    @Test(description = "Error updating user with empty email", groups = {"Api"})
    public void errorUpdatingUserWithEmptyEmail() {
        updateUserNegative("email", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_EMAIL);
    }

    @TestRails(id = "C5944922")
    @Test(description = "Error updating user with empty phone", groups = {"Api"})
    public void errorUpdatingUserWithEmptyPhone() {
        updateUserNegative("phone", CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
    }

    private void updateUserNegative(String emptyField, int responseCode, String errorMessage) {
        UserModel user = FakeGenerator.generateFakeUser();
        switch (emptyField) {
            case "id" -> user.setId(Strings.EMPTY);
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

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
