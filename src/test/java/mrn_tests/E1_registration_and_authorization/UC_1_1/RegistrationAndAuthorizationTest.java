package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class RegistrationAndAuthorizationTest extends BaseTest {

    @TestRails(id = "C5867956")
    @Test(description = "User registration with the credentials registered in the System", groups = {"Smoke", "Sanity"})
    public void c5867956() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
    }

    @TestRails(id = "C5867980")
    @Test(description = "User registration with credentials not registered in the System", groups = {"Smoke", "Sanity"})
    public void c5867980() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(NOT_VALID_LOGIN);
        loginStep.verifySymbolsAreCorrectlyInLoginField(NOT_VALID_LOGIN);
        loginStep.enterPasswordToPasswordField(NOT_VALID_PASSWORD);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(NOT_VALID_PASSWORD, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5882617")
    @Test(description = "User registration with registered login and not registered password", groups = {"Smoke", "Sanity"})
    public void c5882617() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.verifyWelcomeScreenIsOpen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(NOT_VALID_PASSWORD);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(NOT_VALID_PASSWORD, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5882621")
    @Test(description = "User registration with registered password and not registered login", groups = {"Smoke", "Sanity"})
    public void c5882621() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(NOT_VALID_LOGIN);
        loginStep.verifySymbolsAreCorrectlyInLoginField(NOT_VALID_LOGIN);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();
        loginStep.verifyErrorMessageUnderPassword("You have entered a non-existent login and/or password. Please enter again");
    }

    @TestRails(id = "C5867970")
    @Test(description = "Cancel registration", groups = {"Functional"})
    public void c5867970() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.tapOnBackIcon();
        welcomeStep.verifyWelcomeScreenIsOpen();
    }
}
