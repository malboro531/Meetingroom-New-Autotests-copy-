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
public class EmailValidationByCreatingUserTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5944612")
    @Test(description = "User creating with email with hyphen symbol", groups = {"Api"})
    public void userCreatingWithEmailWithHyphenSymbol() {
        createUserPositive("????-##@gmail.com");
    }

    @TestRails(id = "C5944613")
    @Test(description = "User creating with email with low line symbol", groups = {"Api"})
    public void userCreatingWithEmailWithLowLineSymbol() {
        createUserPositive("????_##@gmail.com");
    }

    @TestRails(id = "C5944615")
    @Test(description = "User creating with email with dot symbol", groups = {"Api"})
    public void userCreatingWithEmailWithDotSymbol() {
        createUserPositive("????.##@gmail.com");
    }

    @TestRails(id = "C5941258")
    @Test(description = "Error creating user with existing email", groups = {"Api"})
    public void errorCreatingUserWithExistingEmail() {
        UserModel userDb = FakeGenerator.generateFakeUser();
      //  DataBaseConnectionManager.createFakeUser(userDb);
        createUserNegative(userDb.getEmail(), CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_USER_WITH_PROVIDED_EMAIL_ALREADY_EXISTS);
    }

    @TestRails(id = "C5944626")
    @Test(description = "Error creating user with email without commercial at symbol", groups = {"Api"})
    public void errorCreatingUserWithEmailWithoutCommercialAtSymbol() {
        createUserNegative("????##gmail.com");
    }

    @TestRails(id = "C5944627")
    @Test(description = "Error creating user with email with two commercial at symbol", groups = {"Api"})
    public void errorCreatingUserWithEmailWithTwoCommercialAtSymbol() {
        createUserNegative("????@##@gmail.com");
    }

    @TestRails(id = "C5944628")
    @Test(description = "Error creating user with email with commercial at symbol at the beginning", groups = {"Api"})
    public void errorCreatingUserWithEmailWithCommercialAtSymbolAtTheBeginning() {
        createUserNegative("@????##gmail.com");
    }

    @TestRails(id = "C5944629")
    @Test(description = "Error creating user with email with commercial at symbol at the end", groups = {"Api"})
    public void errorCreatingUserWithEmailWithCommercialAtSymbolAtTheEnd() {
        createUserNegative("????##gmail.com@");
    }

    @TestRails(id = "C5944630")
    @Test(description = "Error creating user with email without dot symbol", groups = {"Api"})
    public void errorCreatingUserWithEmailWithoutDotSymbol() {
        createUserNegative("????##@gmailcom");
    }

    @TestRails(id = "C5944631")
    @Test(description = "Error creating user with email with dot before commercial at symbol", groups = {"Api"})
    public void errorCreatingUserWithEmailWithDotBeforeCommercialAtSymbol() {
        createUserNegative("????.##@gmailcom");
    }

    @TestRails(id = "C5944632")
    @Test(description = "Error creating user with email with dot symbol at the beginning", groups = {"Api"})
    public void errorCreatingUserWithEmailWithDotSymbolAtTheBeginning() {
        createUserNegative(".????##@gmail.com");
    }

    @TestRails(id = "C5944633")
    @Test(description = "Error creating user with email with dot symbol at the end", groups = {"Api"})
    public void errorCreatingUserWithEmailWithDotSymbolAtTheEnd() {
        createUserNegative("????##@gmail.com.");
    }

    @TestRails(id = "C5944634")
    @Test(description = "Error creating user with email with cyrillic symbols", groups = {"Api"})
    public void errorCreatingUserWithEmailWithCyrillicSymbols() {
        createUserNegative("????реально##@gmail.com");
    }

    @TestRails(id = "C5944635")
    @Test(description = "Error creating user with email with restricted special symbols", groups = {"Api"})
    public void errorCreatingUserWithEmailWithRestrictedSpecialSymbols() {
        createUserNegative("????!##@gmail.com");
    }

    @TestRails(id = "C5944636")
    @Test(description = "Error creating user with email with over maximum value", groups = {"Api"})
    public void errorCreatingUserWithEmailWithOverMaximumValue() {
        createUserNegative("????##????##????##????##????##????##????##????##???@gmail.com");
    }

    private void createUserPositive(String email) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setEmail(FakeGenerator.getEmail(email));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void createUserNegative(String email) {
        createUserNegative(email, CODE_CLIENT_ERROR_BAD_REQUEST, ERROR_MESSAGE_INVALID_EMAIL);
    }

    private void createUserNegative(String email, int responseCode, String errorMessage) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setEmail(FakeGenerator.getEmail(email));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, responseCode);
        userApiStep.checkResponseTextBody(response, errorMessage);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
