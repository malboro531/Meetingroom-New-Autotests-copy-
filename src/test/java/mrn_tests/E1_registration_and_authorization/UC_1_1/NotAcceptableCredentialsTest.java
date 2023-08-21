package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.*;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class NotAcceptableCredentialsTest extends BaseTest {

    @TestRails(id = "C5867972")
    @Test(description = "Empty Login and Password fields", groups = {"Functional"})
    public void c5867972() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderLogin("Please fill in a required field");
        loginStep.verifyErrorMessageUnderPassword("Please fill in a required field");
    }

    @TestRails(id = "C5878928")
    @Test(description = "Empty Password field", groups = {"Functional"})
    public void c5878928() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("Please fill in a required field");
    }

    @TestRails(id = "C5878927")
    @Test(description = "Empty Login field", groups = {"Functional"})
    public void c5878927() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderLogin("Please fill in a required field");
    }

    @TestRails(id = "C5883095")
    @Test(description = "Enter login that doesn't start with 111", groups = {"Functional"})
    public void c5883095() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        String tempLogin = "12375869705452312345";
        loginStep.enterLoginToLoginField(tempLogin);
        loginStep.verifySymbolsAreCorrectlyInLoginField(tempLogin);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderLogin("The login must start with 111");
    }

    @TestRails(id = "C5867975")
    @Test(description = "Enter special symbols", groups = {"Functional"})
    public void c5867975() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        String tempLogin = "111(@%!705452312345";
        String tempPassword = "1(@%!86970512345";
        loginStep.enterLoginToLoginField(tempLogin);
        loginStep.verifySymbolsAreCorrectlyInLoginField(tempLogin);
        loginStep.enterPasswordToPasswordField(tempPassword);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(tempPassword, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("Use only letters and numbers");
    }

    @TestRails(id = "C5867982")
    @Test(description = "Credentials are entered incorrectly 2 times", groups = {"Other"})
    public void c5867982() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        String fakeLogin = FakeGenerator.getRandomNumber();
        String fakePassword = FakeGenerator.getRandomNumber();
        for (int i = 0; i < 2; i++) {
            loginStep.enterLoginToLoginField(fakeLogin);
            loginStep.verifySymbolsAreCorrectlyInLoginField(fakeLogin);
            loginStep.enterPasswordToPasswordField(fakePassword);
            loginStep.verifySymbolsAreCorrectlyInPasswordField(fakePassword, true);
            loginStep.tapOnLogInButton();
        }
        //TODO this pop-up doesn't exist --- loginStep.verifyInvalidPopUp("Invalid login details");
    }
}
