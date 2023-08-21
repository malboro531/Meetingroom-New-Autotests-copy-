package mrn_tests.E1_registration_and_authorization.UC_1_3;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_3;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;
import static helpers.WordProcessor.generateCodeByLength;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_3)
public class VerificationCodeMethod extends BaseTest {

    @TestRails(id = "C5868554")
    @Test(description = "Choose Verification code receiving method (SMS)", groups = {"Automated"})
    public void c5868554() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnSmsRadioButton();
        confirmationCodeOptionsStep.verifySmsRadioButtonIsChecked();
        confirmationCodeOptionsStep.tapOnProceedIcon();
    }

    @TestRails(id = "C5868556")
    @Test(description = "Choose Verification code receiving method (EMAIL)", groups = {"Automated"})
    public void c5868556() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnEmailRadioButton();
        confirmationCodeOptionsStep.verifyEmailRadioButtonIsChecked();
        confirmationCodeOptionsStep.tapOnProceedIcon();
    }

    @TestRails(id = "C5868558")
    @Test(description = "Choose Verification code receiving method (PUSH-NOTIFICATION)", groups = {"Automated"})
    public void c5868558() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnPushRadioButton();
        confirmationCodeOptionsStep.verifyPushRadioButtonIsChecked();
        confirmationCodeOptionsStep.tapOnProceedIcon();
    }

    @TestRails(id = "C5868572")
    @Test(description = "Change the Verification code receiving method via pop-up window", groups = {"Automated"})
    public void c5868572() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();

        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();

        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();

        String tempCode = generateCodeByLength(4);
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.enterConfirmationCodeToField(tempCode);
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.errorFrameSwitchToIt();
        confirmationCodeStep.errorFrameVerifyErrorTextTitle("You entered the wrong code 5 times");
        confirmationCodeStep.errorFrameTapOnChangeMethodLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.verifyConfirmationCodeOptionsScreenIsOpen();
        // TODO  Expected result - The screen with methods is displayed, the previous option is unavailable for N-time
    }

    @TestRails(id = "C5869589")
    @Test(description = "Return to Code OrderConfirmationScreen Page via \"Back\" button")
    public void c5869589() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnBackIcon();

        confirmationCodeStep.onConfirmScreen();
    }

    @TestRails(id = "C5882806")
    @Test(description = "Return to Code OrderConfirmationScreen Page via \"Back\" button with changed method")
    public void c5882806() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnEmailRadioButton();
        confirmationCodeOptionsStep.tapOnBackIcon();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.verifySmsRadioButtonIsChecked();
    }

    @TestRails(id = "C5882766")
    @Test(description = "Can't select unavailable method")
    public void c5882766() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnSmsRadioButton();
        confirmationCodeOptionsStep.verifySmsRadioButtonIsNotChecked();
    }

    @TestRails(id = "C5882811")
    @Test(description = "Countdown is still displayed after app reloading")
    public void c5882811() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();

        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.verifySymbolsAreCorrectlyInLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.verifySymbolsAreCorrectlyInPasswordField(VALID_PASSWORD_USER, true);
        loginStep.tapOnLogInButton();

        String tempCode = generateCodeByLength(4);
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.enterConfirmationCodeToField(tempCode);
            confirmationCodeStep.tapOnConfirmButton();
        }

        confirmationCodeStep.errorFrameSwitchToIt();
        confirmationCodeStep.errorFrameVerifyErrorTextTitle("You entered the wrong code 5 times");
        confirmationCodeStep.errorFrameTapOnChangeMethodLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();

        // TODO  countdown is missing
    }

    @TestRails(id = "C5882838")
    @Test(description = "Radio button is becoming inactive after choosing another one")
    public void c5882838() {
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
        confirmationCodeStep.tapOnChooseHowToReceiveConfirmationCodeLink();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.tapOnEmailRadioButton();
        confirmationCodeOptionsStep.verifyEmailRadioButtonIsChecked();
        confirmationCodeOptionsStep.verifySmsRadioButtonIsNotChecked();
    }
}
