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
public class PatronymicValidationByCreatingUserTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5944885")
    @Test(description = "User creating with single character patronymic", groups = {"Api"})
    public void userCreatingWithSingleCharacterPatronymic() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 1));
    }

    @TestRails(id = "C5944886")
    @Test(description = "User creating with thirty character patronymic", groups = {"Api"})
    public void userCreatingWithThirtyCharacterPatronymic() {
        createUserPositive(FakeGenerator.getNameGivenLength("?", 30));
    }

    @TestRails(id = "C5944887")
    @Test(description = "User creating with hyphen symbol in patronymic", groups = {"Api"})
    public void userCreatingWithHyphenSymbolInPatronymic() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPatronymic(FakeGenerator.getModifiedName(user.getPatronymic(), "-", false));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    @TestRails(id = "C5944888")
    @Test(description = "Error creating user with thirty one character patronymic", groups = {"Api"})
    public void errorCreatingUserWithThirtyOneCharacterPatronymic() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPatronymic(FakeGenerator.getNameGivenLength("?", 31));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PATRONYMIC);
        checkAll();
    }

    @TestRails(id = "C5944889")
    @Test(description = "Error creating user with cyrillic symbol in patronymic", groups = {"Api"})
    public void errorCreatingUserWithCyrillicSymbolInPatronymic() {
        createUserNegative("й", true);
    }

    @TestRails(id = "C5944890")
    @Test(description = "Error creating user with commercial at symbol in patronymic", groups = {"Api"})
    public void errorCreatingUserWithCommercialAtSymbolInPatronymic() {
        createUserNegative("@", true);
    }

    @TestRails(id = "C5944891")
    @Test(description = "Error creating user with digits in patronymic", groups = {"Api"})
    public void errorCreatingUserWithDigitsInPatronymic() {
        createUserNegative(FakeGenerator.getNameGivenLength("#", 1), true);
    }

    private void createUserPositive(String patronymic) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPatronymic(patronymic);
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void createUserNegative(String replacementSymbol, boolean replaceTheFirstSymbol) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPatronymic(FakeGenerator.getModifiedName(user.getPatronymic(), replacementSymbol, replaceTheFirstSymbol));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PATRONYMIC);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
