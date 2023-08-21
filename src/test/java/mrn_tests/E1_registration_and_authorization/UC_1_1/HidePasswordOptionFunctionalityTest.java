package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class HidePasswordOptionFunctionalityTest extends BaseTest {

    @TestRails(id = "C5868139")
    @Test(description = "Press 'Hide the password'", groups = {"Other"})
    public void c5868139() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnEyeImageView();
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, false);
        loginStep.tapOnEyeImageView();
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
    }

    @TestRails(id = "C5868138")
    @Test(description = "Press 'Show password' button", groups = {"Functional"})
    public void c5868138() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnEyeImageView();
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, false);
    }
}
