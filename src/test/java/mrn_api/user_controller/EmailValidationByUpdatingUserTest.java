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
public class EmailValidationByUpdatingUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5944738")
    @Test(description = "User updating with email with hyphen symbol", groups = {"Api"})
    public void userUpdatingWithEmailWithHyphenSymbol() {
        updateUserPositive("????-##@gmail.com");
    }

    @TestRails(id = "C5944739")
    @Test(description = "User updating with email with low line symbol", groups = {"Api"})
    public void userUpdatingWithEmailWithLowLineSymbol() {
        updateUserPositive("????_##@gmail.com");
    }

    @TestRails(id = "C5944740")
    @Test(description = "User updating with email with dot symbol", groups = {"Api"})
    public void userUpdatingWithEmailWithDotSymbol() {
        updateUserPositive("????.##@gmail.com");
    }

    @Ignore
    @TestRails(id = "C5944741")
    @Test(description = "Error updating user with existing email", groups = {"Api"})
    public void errorUpdatingUserWithExistingEmail() {
        UserModel userDb = FakeGenerator.generateFakeUser();
        //DataBaseConnectionManager.createFakeUser(userDb);

        updateUserNegative(userDb.getEmail(), CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_USER_WITH_PROVIDED_EMAIL_ALREADY_EXISTS);
    }

    @TestRails(id = "C5944742")
    @Test(description = "Error updating user with email without commercial at symbol", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithoutCommercialAtSymbol() {
        updateUserNegative("????##gmail.com");
    }

    @TestRails(id = "C5944743")
    @Test(description = "Error updating user with email with two commercial at symbol", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithTwoCommercialAtSymbol() {
        updateUserNegative("????@##@gmail.com");
    }

    @TestRails(id = "C5944744")
    @Test(description = "Error updating user with email with commercial at symbol at the beginning", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithCommercialAtSymbolAtTheBeginning() {
        updateUserNegative("@????##gmail.com");
    }

    @TestRails(id = "C5944745")
    @Test(description = "Error updating user with email without commercial at symbol at the end", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithCommercialAtSymbolAtTheEnd() {
        updateUserNegative("????##gmail.com@");
    }

    @TestRails(id = "C5944746")
    @Test(description = "Error updating user with email without dot symbol", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithoutDotSymbol() {
        updateUserNegative("????##@gmailcom");
    }

    @TestRails(id = "C5944747")
    @Test(description = "Error updating user with email with dot before commercial at symbol", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithDotBeforeCommercialAtSymbol() {
        updateUserNegative("????.##@gmailcom");
    }

    @TestRails(id = "C5944748")
    @Test(description = "Error updating user with email with dot symbol at the beginning", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithDotSymbolAtTheBeginning() {
        updateUserNegative(".????##@gmail.com");
    }

    @TestRails(id = "C5944749")
    @Test(description = "Error updating user with email with dot symbol at the end", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithDotSymbolAtTheEnd() {
        updateUserNegative("????##@gmail.com.");
    }

    @TestRails(id = "C5944750")
    @Test(description = "Error updating user with email with cyrillic symbols", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithCyrillicSymbols() {
        updateUserNegative("????реально##@gmail.com");
    }

    @TestRails(id = "C5944751")
    @Test(description = "Error updating user with email with restricted special symbols", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithRestrictedSpecialSymbols() {
        updateUserNegative("????!##@gmail.com");
    }

    @TestRails(id = "C5944752")
    @Test(description = "Error updating user with email with over maximum value", groups = {"Api"})
    public void errorUpdatingUserWithEmailWithOverMaximumValue() {
        updateUserNegative("????##????##????##????##????##????##????##????##???@gmail.com");
    }

    private void updateUserPositive(String email) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setEmail(FakeGenerator.getEmail(email));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void updateUserNegative(String email) {
        updateUserNegative(email, CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_EMAIL);
    }

    private void updateUserNegative(String email, int responseCode, String errorMessage) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setEmail(FakeGenerator.getEmail(email));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, responseCode);
        userApiStep.checkResponseTextBody(response, errorMessage);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
