package mrn_tests.E1_registration_and_authorization.UC_1_2;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_2;
import static constants.GlobalData.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_2)
public class ConfirmCodeTest extends BaseTest {

    @TestRails(id = "C5868543")
    @Test(description = "Confirm the code by SMS", groups = {"Smoke", "Sanity"})
    public void c5868543() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();
        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnSmsRadioButton();
        confirmationCodeOptionsStep.verifySmsRadioButtonIsChecked();
        //TODO — functionality doesn't exist yet
    }

    @TestRails(id = "C5868548")
    @Test(description = "Confirm the code by E-MAIL and user is redirected to \"Change password\" screen", groups = {"Smoke", "Sanity"})
    public void c5868548() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();
        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnEmailRadioButton();
        confirmationCodeOptionsStep.verifyEmailRadioButtonIsChecked();
        confirmationCodeOptionsStep.tapOnProceedIcon();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();
        changePasswordStep.onChangePasswordScreen();
        changePasswordStep.verifyChangePasswordScreenIsOpen();
    }

    @TestRails(id = "C5868550")
    @Test(description = "Confirm the code by PUSH notification", groups = {"Smoke", "Sanity"})
    public void c5868550() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();
        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnPushRadioButton();
        confirmationCodeOptionsStep.verifyPushRadioButtonIsChecked();
        //TODO — functionality doesn't exist yet
    }

    @TestRails(id = "C5880477")
    @Test(description = "Numeric keyboard is displayed and the user is allowed to input only digits", groups = {"Functional"})
    public void c5880477() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.tapOnLoginField();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.tapOnConfirmField();
        keyboardIsShown();
    }

    @TestRails(id = "C5880055")
    @Test(description = "Press \"Send again\" button", groups = {"Functional"})
    public void c5880055() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        String firstCode = getConfirmCode();
        confirmationCodeStep.tapOnSendAgain();
        confirmationCodeStep.waitSecondCode();
        String secondCode = getConfirmCode();
        Assert.assertFalse(secondCode.equals(firstCode), "Second code not sent");
    }

    @TestRails(id = "C5950322")
    @Test(description = "The confirmation code sent again after 5 minutes", groups = {"Functional"})
    public void c5950322() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        String firstCode = getConfirmCode();
        confirmationCodeStep.waitUntilExpirationCountdownOver();
        confirmationCodeStep.waitSecondCode();
        String secondCode = getConfirmCode();
        Assert.assertFalse(secondCode.equals(firstCode), "Second code not sent");
    }

    @TestRails(id = "C5950379")
    @Test(description = "The countdown changes to the message \"Code has expired\" ", groups = {"Functional"})
    public void с5950379() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.waitUntilExpirationCountdownOver();
        confirmationCodeStep.waitUntilSecondExpirationCountdownOver();
    }
}