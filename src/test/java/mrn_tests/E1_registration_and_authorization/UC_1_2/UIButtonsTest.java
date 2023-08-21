package mrn_tests.E1_registration_and_authorization.UC_1_2;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_2;
import static constants.GlobalData.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_2)
public class UIButtonsTest extends BaseTest {

    @TestRails(id = "C5869561")
    @Test(description = "Displaying the validity period of the code", groups = {"Functional"})
    public void c5869561() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.verifyExpirationCountdownContains("Code expiration 04:5");
        confirmationCodeStep.waitUntilExpirationCountdownOver();
    }

    @TestRails(id = "C5869577")
    @Test(description = "Press 'Back' button", groups = {"Functional"})
    public void c5869577() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.tapOnBackIcon();
        loginStep.verifyLoginScreenIsOpen();
    }

    @TestRails(id = "C5880047")
    @Test(description = "Press 'Change the way' button", groups = {"Functional"})
    public void c5880047() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.enterConfirmationCodeToField(getExactlyInvalidConfirmCode());
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.errorFrameSwitchToIt();
        confirmationCodeStep.errorFrameVerifyErrorTextTitle(WRONG_CODE_FIVE_TIMES);
        confirmationCodeStep.errorFrameTapOnChangeMethodLink();
        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.verifyConfirmationCodeOptionsScreenIsOpen();
    }

    @TestRails(id = "C5868576")
    @Test(description = "Press \"Try later\" button", groups = {"Functional"})
    public void c5868576() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.enterConfirmationCodeToField(getExactlyInvalidConfirmCode());
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.errorFrameSwitchToIt();
        confirmationCodeStep.errorFrameVerifyErrorTextTitle(WRONG_CODE_FIVE_TIMES);
        confirmationCodeStep.errorFrameTapOnRepeatLaterLink();
        welcomeStep.verifyWelcomeScreenIsOpen();
    }
}
