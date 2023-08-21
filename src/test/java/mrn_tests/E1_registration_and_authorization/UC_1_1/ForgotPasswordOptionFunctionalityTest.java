package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class ForgotPasswordOptionFunctionalityTest extends BaseTest {

    @TestRails(id = "C5882709")
    @Test(description = "ON HOLD Press 'Forgot password?'", groups = {"Other"})
    public void c5882709() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.tapOnForgotPasswordLink();
        //TODO — The pop-up screen screen with message "In accordance with security requirements, one-time password recovery is possible only at a bank..." is displayed
    }
}
