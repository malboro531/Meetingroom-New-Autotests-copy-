package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.VALID_PASSWORD_USER;
import static helpers.WordProcessor.generateLoginByLength;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class LoginLengthTest extends BaseTest {

    @TestRails(id = "C5878898")
    @Test(description = "Enter 6-symbol login", groups = {"Functional"})
    public void c5878898() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(generateLoginByLength(6));
        loginStep.verifySymbolsAreCorrectlyInLoginField(generateLoginByLength(6));
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderLogin("Login length cannot be less than 7 characters");
    }

    @TestRails(id = "C5878753")
    @Test(description = "Enter 7-symbol login", groups = {"Functional"})
    public void c5878753() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(generateLoginByLength(7));
        loginStep.verifySymbolsAreCorrectlyInLoginField(generateLoginByLength(7));
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5879013")
    @Test(description = "Enter 10-symbol login", groups = {"Functional"})
    public void c5879013() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(generateLoginByLength(10));
        loginStep.verifySymbolsAreCorrectlyInLoginField(generateLoginByLength(10));
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5878907")
    @Test(description = "Enter 20-symbol login", groups = {"Functional"})
    public void c5878907() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(generateLoginByLength(20));
        loginStep.verifySymbolsAreCorrectlyInLoginField(generateLoginByLength(20));
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }
}
