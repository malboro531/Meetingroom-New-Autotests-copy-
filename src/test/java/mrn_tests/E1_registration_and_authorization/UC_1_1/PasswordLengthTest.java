package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.VALID_LOGIN_USER;
import static helpers.WordProcessor.generatePasswordByLength;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class PasswordLengthTest extends BaseTest {

    @TestRails(id = "C5878926")
    @Test(description = "Enter 6-symbol password", groups = {"Functional"})
    public void c5878926() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(generatePasswordByLength(6));
        loginStep.verifySymbolsAreCorrectlyInPasswordField(generatePasswordByLength(6), true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("Password length cannot be less than 7 characters");
    }

    @TestRails(id = "C5878908")
    @Test(description = "Enter 7-symbol password", groups = {"Functional"})
    public void c5878908() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(generatePasswordByLength(7));
        loginStep.verifySymbolsAreCorrectlyInPasswordField(generatePasswordByLength(7), true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5878946")
    @Test(description = "Enter 10-symbol password", groups = {"Functional"})
    public void c5878946() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(generatePasswordByLength(10));
        loginStep.verifySymbolsAreCorrectlyInPasswordField(generatePasswordByLength(10), true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5878937")
    @Test(description = "Enter 20-symbol password", groups = {"Functional"})
    public void c5878937() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(generatePasswordByLength(20));
        loginStep.verifySymbolsAreCorrectlyInPasswordField(generatePasswordByLength(20), true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }
}
