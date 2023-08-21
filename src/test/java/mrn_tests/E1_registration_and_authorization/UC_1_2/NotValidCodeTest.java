package mrn_tests.E1_registration_and_authorization.UC_1_2;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_2;
import static constants.GlobalData.*;
import static helpers.WordProcessor.generateCodeByLength;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_2)
public class NotValidCodeTest extends BaseTest {

    @TestRails(id = "C5868565")
    @Test(description = "Enter an invalid code 1 time", groups = {"Functional"})
    public void c5868565() {
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
        confirmationCodeStep.enterConfirmationCodeToField(getExactlyInvalidConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();
        confirmationCodeStep.verifyErrorTextEquals("Invalid code entered. You have 4 attempts left.");
    }

    @TestRails(id = "C5868568")
    @Test(description = "Enter an invalid code 4 times", groups = {"Functional"})
    public void c5868568() {
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
        for (int i = 0; i < 4; i++) {
            confirmationCodeStep.onConfirmScreen();
            confirmationCodeStep.verifyConfirmScreenIsOpen();
            confirmationCodeStep.enterConfirmationCodeToField(getExactlyInvalidConfirmCode());
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyErrorTextEquals("Invalid code entered. You have 1 attempts left.");
    }

    @TestRails(id = "C5880042")
    @Test(description = "Enter an invalid code 5 times", groups = {"Functional"})
    public void c5880042() {
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
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.onConfirmScreen();
            confirmationCodeStep.verifyConfirmScreenIsOpen();
            confirmationCodeStep.enterConfirmationCodeToField(getExactlyInvalidConfirmCode());
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyGetErrorTextTitle("You entered the wrong code 5 times");
    } // Bug report created

    @TestRails(id = "C5868579")
    @Test(description = "Input 5 digits in the Code field", groups = {"Functional"})
    public void c5868579() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        String tempCode = generateCodeByLength(5);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.verifySymbolsAreCorrectlyInConfirmationField(tempCode.substring(0, 4));
    }

    @TestRails(id = "C5942737")
    @Test(description = "The confirmation code invalid after 5 minutes", groups = {"Functional"})
    public void c5942737() {
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
        confirmationCodeStep.verifyExpirationCountdownContains("Code expiration");
        String code = getConfirmCode();
        confirmationCodeStep.waitUntilExpirationCountdownOver();
        confirmationCodeStep.enterConfirmationCodeToField(code);
        confirmationCodeStep.tapOnConfirmButton();
        confirmationCodeStep.verifyErrorTextEquals("Invalid code entered. You have 4 attempts left.");
    }
}
