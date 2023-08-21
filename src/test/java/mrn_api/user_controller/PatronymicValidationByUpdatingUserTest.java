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
public class PatronymicValidationByUpdatingUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5944905")
    @Test(description = "User updating with single character patronymic", groups = {"Api"})
    public void userUpdatingWithSingleCharacterPatronymic() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944906")
    @Test(description = "User updating with thirty character patronymic", groups = {"Api"})
    public void userUpdatingWithThirtyCharacterPatronymic() {
        updateUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944907")
    @Test(description = "User updating with hyphen symbol in patronymic", groups = {"Api"})
    public void userUpdatingWithHyphenSymbolInPatronymic() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPatronymic(FakeGenerator.getModifiedName(user.getPatronymic(), "-", false));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944908")
    @Test(description = "Error updating user with thirty one character patronymic", groups = {"Api"})
    public void errorUpdatingUserWithThirtyOneCharacterPatronymic() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPatronymic(FakeGenerator.getNameGivenLength("?", 31));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PATRONYMIC);
        checkAll();
    }

    @TestRails(id = "C5944909")
    @Test(description = "Error updating user with cyrillic symbol in patronymic", groups = {"Api"})
    public void errorUpdatingUserWithCyrillicSymbolInPatronymic() {
        updateUserNegative("й", true);
    }

    @TestRails(id = "C5944910")
    @Test(description = "Error updating user with commercial at symbol in patronymic", groups = {"Api"})
    public void errorUpdatingUserWithCommercialAtSymbolInPatronymic() {
        updateUserNegative("@", true);
    }

    @TestRails(id = "C5944911")
    @Test(description = "Error updating user with digits in patronymic", groups = {"Api"})
    public void errorUpdatingUserWithDigitsInPatronymic() {
        updateUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void updateUserPositive(String patronymic) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPatronymic(patronymic);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void updateUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPatronymic(FakeGenerator.getModifiedName(user.getPatronymic(), replacementSymbol, replaceTheFirstSymbol));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PATRONYMIC);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
