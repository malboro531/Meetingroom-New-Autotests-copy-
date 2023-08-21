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
public class LastNameValidationByUpdatingUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5944897")
    @Test(description = "User updating with single character last name", groups = {"Api"})
    public void userUpdatingWithSingleCharacterLastName() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944899")
    @Test(description = "User updating with thirty character last name", groups = {"Api"})
    public void userUpdatingWithThirtyCharacterLastName() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944900")
    @Test(description = "User updating with hyphen symbol in last name", groups = {"Api"})
    public void userUpdatingWithHyphenSymbolInLastName() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setLastName(FakeGenerator.getModifiedName(user.getLastName(), "-", false));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944901")
    @Test(description = "Error updating user with thirty one character last name", groups = {"Api"})
    public void errorUpdatingUserWithThirtyOneCharacterLastName() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setLastName(FakeGenerator.getNameGivenLength("?", 31));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_LAST_NAME);
        checkAll();
    }

    @TestRails(id = "C5944902")
    @Test(description = "Error updating user with cyrillic symbol in last name", groups = {"Api"})
    public void errorUpdatingUserWithCyrillicSymbolInLastName() {
        updateUserNegative("й", true);
    }

    @TestRails(id = "C5944903")
    @Test(description = "Error updating user with commercial at symbol in last name", groups = {"Api"})
    public void errorUpdatingUserWithCommercialAtSymbolInLastName() {
        updateUserNegative("@", true);
    }

    @TestRails(id = "C5944904")
    @Test(description = "Error updating user with digits in last name", groups = {"Api"})
    public void errorUpdatingUserWithDigitsInLastName() {
        updateUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void updateUserPositive(String lastName) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setLastName(lastName);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void updateUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setLastName(FakeGenerator.getModifiedName(user.getLastName(), replacementSymbol, replaceTheFirstSymbol));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_LAST_NAME);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
