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
public class LastNameValidationByCreatingUserTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5944878")
    @Test(description = "User creating with single character last name", groups = {"Api"})
    public void userCreatingWithSingleCharacterLastName() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944879")
    @Test(description = "User creating with thirty character last name", groups = {"Api"})
    public void userCreatingWithThirtyCharacterLastName() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944880")
    @Test(description = "User creating with hyphen symbol in last name", groups = {"Api"})
    public void userCreatingWithHyphenSymbolInLastName() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setLastName(FakeGenerator.getModifiedName(user.getLastName(), "-", false));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944881")
    @Test(description = "Error creating user with thirty one character last name", groups = {"Api"})
    public void errorCreatingUserWithThirtyOneCharacterLastName() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setLastName(FakeGenerator.getNameGivenLength("?", 31));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_LAST_NAME);
        checkAll();
    }

    @TestRails(id = "C5944882")
    @Test(description = "Error creating user with cyrillic symbol in last name", groups = {"Api"})
    public void errorCreatingUserWithCyrillicSymbolInLastName() {
        createUserNegative("й", true);
    }

    @TestRails(id = "C5944883")
    @Test(description = "Error creating user with commercial at symbol in last name", groups = {"Api"})
    public void errorCreatingUserWithCommercialAtSymbolInLastName() {
        createUserNegative("@", true);
    }

    @TestRails(id = "C5944884")
    @Test(description = "Error creating user with digits in last name", groups = {"Api"})
    public void errorCreatingUserWithDigitsInLastName() {
        createUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void createUserPositive(String lastName) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setLastName(lastName);
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void createUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setLastName(FakeGenerator.getModifiedName(user.getLastName(), replacementSymbol, replaceTheFirstSymbol));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_LAST_NAME);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
