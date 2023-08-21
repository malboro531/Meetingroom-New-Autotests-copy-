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
import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class FirstNameValidationByUpdatingUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5944800")
    @Test(description = "User updating with single character first name", groups = {"Api"})
    public void userUpdatingWithSingleCharacterFirstName() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944801")
    @Test(description = "User updating with thirty character first name", groups = {"Api"})
    public void userUpdatingWithThirtyCharacterFirstName() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944802")
    @Test(description = "User updating with hyphen symbol in first name", groups = {"Api"})
    public void userUpdatingWithHyphenSymbolInFirstName() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setFirstName(FakeGenerator.getModifiedName(user.getFirstName(), "-", false));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944803")
    @Test(description = "Error updating user with thirty one character first name", groups = {"Api"})
    public void errorUpdatingUserWithThirtyOneCharacterFirstName() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setFirstName(FakeGenerator.getNameGivenLength("?", 31));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_FIRST_NAME);
        checkAll();
    }

    @TestRails(id = "C5944804")
    @Test(description = "Error updating user with cyrillic symbol in first name", groups = {"Api"})
    public void errorUpdatingUserWithCyrillicSymbolInFirstName() {
        updateUserNegative("й", true);
    }

    @TestRails(id = "C5944805")
    @Test(description = "Error updating user with commercial at symbol in first name", groups = {"Api"})
    public void errorUpdatingUserWithCommercialAtSymbolInFirstName() {
        updateUserNegative("@", true);
    }

    @TestRails(id = "C5944806")
    @Test(description = "Error updating user with digits in first name", groups = {"Api"})
    public void errorUpdatingUserWithDigitsInFirstName() {
        updateUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void updateUserPositive(String firstName) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setFirstName(firstName);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void updateUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setFirstName(FakeGenerator.getModifiedName(user.getFirstName(), replacementSymbol, replaceTheFirstSymbol));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_FIRST_NAME);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
