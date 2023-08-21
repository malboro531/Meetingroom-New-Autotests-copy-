package mrn_api.user_controller;

import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class FirstNameValidationByCreatingUserTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5944786")
    @Test(description = "User creating with single character first name", groups = {"Api"})
    public void userCreatingWithSingleCharacterFirstName() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944787")
    @Test(description = "User creating with thirty character first name", groups = {"Api"})
    public void userCreatingWithThirtyCharacterFirstName() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944788")
    @Test(description = "User creating with hyphen symbol in first name", groups = {"Api"})
    public void userCreatingWithHyphenSymbolInFirstName() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setFirstName(FakeGenerator.getModifiedName(user.getFirstName(), "-", false));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944789")
    @Test(description = "Error creating user with thirty one character first name", groups = {"Api"})
    public void errorCreatingUserWithThirtyOneCharacterFirstName() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setFirstName(FakeGenerator.getNameGivenLength("?", 31));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_FIRST_NAME);
        checkAll();
    }

    @TestRails(id = "C5944790")
    @Test(description = "Error creating user with cyrillic symbol in first name", groups = {"Api"})
    public void errorCreatingUserWithCyrillicSymbolInFirstName() {
        createUserNegative("й", true);
    }

    @TestRails(id = "C5944791")
    @Test(description = "Error creating user with commercial at symbol in first name", groups = {"Api"})
    public void errorCreatingUserWithCommercialAtSymbolInFirstName() {
        createUserNegative("@", true);
    }

    @TestRails(id = "C5944792")
    @Test(description = "Error creating user with digits in first name", groups = {"Api"})
    public void errorCreatingUserWithDigitsInFirstName() {
        createUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void createUserPositive(String firstName) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setFirstName(firstName);
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void createUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setFirstName(FakeGenerator.getModifiedName(user.getFirstName(), replacementSymbol, replaceTheFirstSymbol));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_FIRST_NAME);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
