package steps;

import api.pages.LoginScreen;
import io.qameta.allure.Step;
import verification.Verify;

import static helpers.WordProcessor.convertToAsterisks;

public class LoginStep {

    protected LoginScreen loginScreen;

    @Step("On LoginScreen")
    public void onLoginScreen() {
        loginScreen = new LoginScreen();
    }

    @Step("Enter login to Login field")
    public void enterLoginToLoginField(String login) {
        loginScreen.enterLogin(login);
    }

    @Step("Tap on login field for visibility keyboard")
    public void tapOnLoginField() {
        loginScreen.tapOnLoginField();
    }

    @Step("Enter password to Password field")
    public void enterPasswordToPasswordField(String password) {
        loginScreen.enterPassword(password);
    }

    @Step("Tap on LogIn Button")
    public void tapOnLogInButton() {
        loginScreen.tapOnLogInButton();
    }

    @Step("Tap on EyeImageView")
    public void tapOnEyeImageView() {
        loginScreen.tapOnEyeImageView();
    }

    @Step("Tap on Back icon")
    public void tapOnBackIcon() {
        loginScreen.tapOnBackIcon();
    }

    @Step("Verify LoginScreen is Open")
    public void verifyLoginScreenIsOpen() {
        loginScreen.verifyPageIsOpened();
    }

    @Step("Verify symbols are correctly in Login field")
    public void verifySymbolsAreCorrectlyInLoginField(String expectedLogin) {
        Verify.verifyEquals(loginScreen.getLogin(), expectedLogin, "Symbols are displaying correctly In LoginField");
    }

    @Step("Verify symbols are correctly in Password field")
    public void verifySymbolsAreCorrectlyInPasswordField(String expectedPassword, boolean isMasked) {
        if (isMasked)
            Verify.verifyEquals(convertToAsterisks(loginScreen.getPassword()), convertToAsterisks(expectedPassword), "Symbols are masked and displaying correctly In LoginField");
        else
            Verify.verifyEquals(loginScreen.getPassword(), expectedPassword, "Symbols are displaying correctly In LoginField");
    }

    @Step("Verify error single message")
    public void verifyErrorMessageSingle(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, loginScreen.getErrorMessageByInput(), "Message is present: " + loginScreen.getErrorMessageByInput());
    }

    @Step("Verify error message under login")
    public void verifyErrorMessageUnderLogin(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, loginScreen.getErrorMessageUnderLoginField(), "Message is present: " + loginScreen.getErrorMessageUnderLoginField());
    }

    @Step("Verify error message under password")
    public void verifyErrorMessageUnderPassword(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, loginScreen.getErrorMessageUnderPasswordField(), "Message is present: " + loginScreen.getErrorMessageUnderPasswordField());
    }

    @Step("Alert poup")
    public void verifyInvalidPopUp(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, loginScreen.getInvalidPopUp(), "Message is present: " + loginScreen.getInvalidPopUp());
    }

    @Step("Tap on ForgotPassword link")
    public void tapOnForgotPasswordLink() {
        loginScreen.tapOnForgotPasswordLink();
    }

    @Step("Tap on Hotline phone number")
    public void tapOnHotlinePhone() {
        loginScreen.tapOnHotlinePhone();
    }
}
