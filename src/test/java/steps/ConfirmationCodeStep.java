package steps;

import api.pages.ConfirmationCodeScreen;
import api.widgets.ErrorFrame;
import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.transfers.CommonStep;
import verification.Verify;
import verification.VerifySoft;

import java.time.Duration;

import static constants.GlobalData.*;

public class ConfirmationCodeStep extends CommonStep {

    protected ConfirmationCodeScreen confirmationCodeScreen;
    protected ErrorFrame errorFrame;

    @Step("On 'ConfirmationCodeScreen'")
    public void onConfirmScreen() {
        confirmationCodeScreen = new ConfirmationCodeScreen();
    }

    @Step("Verify 'ConfirmationCodeScreen' is open")
    public void verifyConfirmScreenIsOpen() {
        confirmationCodeScreen.verifyPageIsOpened();
    }

    @Step("Tap on 'Choose how to receive confirmation code' link")
    public void tapOnChooseHowToReceiveConfirmationCodeLink() {
        confirmationCodeScreen.tapOnChooseHowToReceiveConfirmationCodeLink();
    }

    @Step("Tap on 'Confirm' button")
    public void tapOnConfirmButton() {
        confirmationCodeScreen.tapOnConfirmButton();
    }

    @Step("Tap on 'Confirm' button to confirm transfer")
    public void tapOnConfirmTransferButton() {
        confirmationCodeScreen.tapOnConfirmTransferButton();
    }

    @Step("Tap on 'Back' icon")
    public void tapOnBackIcon() {
        confirmationCodeScreen.tapOnBackIcon();
    }

    @Step("Tap on 'Confirm field'")
    public void tapOnConfirmField() {
        confirmationCodeScreen.tapOnConfirmField();
    }

    @Step("Tap on 'Back' icon")
    public void enterConfirmationCodeToField(String confirmationCode) {
        confirmationCodeScreen.enterConfirmationCodeToField(confirmationCode);
    }

    @Step("Tap on 'Change method' button")
    public void tapOnChangeMethodButton() {
        confirmationCodeScreen.tapOnChangeMethodButton();
    }

    @Step("Tap on 'Repeat later' button")
    public void tapOnRepeatLaterButton() {
        confirmationCodeScreen.tapOnRepeatLaterButton();
    }

    @Step("Verify symbols in confirmation field")
    public void verifySymbolsAreCorrectlyInConfirmationField(String expectedCode) {
        Verify.verifyEquals(confirmationCodeScreen.getConfirmationCode(), expectedCode, "Symbols are displaying correctly In ConfirmationField");
    }

    @Step("Tap on \"Send again\" button")
    public void tapOnSendAgain() {
        confirmationCodeScreen.tapOnSendAgain();
    }

    @Step("Wait 10 seconds after the countdown has started")
    public void waitSecondCode() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(confirmationCodeScreen.getExpirationTextView(), CODE_EXPIRATION_10_SECONDS));
        verifyExpirationCountdownEquals(CODE_EXPIRATION_10_SECONDS);
    }

    @Step("Verify expiration countdown contains")
    public void verifyExpirationCountdownContains(String expectedText) {
        Verify.verifyTrue(confirmationCodeScreen.getExpirationCountdownText().contains(expectedText), "Text on expiration countdown contains: " + expectedText);
    }

    @Step("Verify expiration countdown equals")
    public void verifyExpirationCountdownEquals(String expectedText) {
        Verify.verifyEquals(confirmationCodeScreen.getExpirationCountdownText(), expectedText, "Text on expiration countdown equals: " + expectedText);
    }

    @Step("Verify error text equals")
    public void verifyErrorTextEquals(String expectedText) {
        Verify.verifyEquals(confirmationCodeScreen.getErrorText(), expectedText, "Error text equals: " + expectedText);
    }

    @Step("Verify 'Invalid code entered. You have n attempts left.'")
    public void verifyErrorTextEqualsQuantityAttemptsLeft(int attemptsLeft) {
        Verify.verifyEquals(confirmationCodeScreen.getErrorText(), String.format("Invalid code entered. You have %d" +
                " attempts left.", attemptsLeft), "Error text equals: " + String.format("Invalid code entered." +
                " You have %d attempts left.", attemptsLeft));
    }

    @Step("Verify error alert equals")
    public void verifyGetErrorTextTitle(String expectedText) {
        Verify.verifyEquals(confirmationCodeScreen.getErrorTextTitle(), expectedText, "Error text equals: " + expectedText);
    }

    @Step("Wait until expiration countdown over")
    public void waitUntilExpirationCountdownOver() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMinutes(5));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(confirmationCodeScreen.getExpirationTextView(), CODE_EXPIRATION_START));
        verifyExpirationCountdownEquals(CODE_EXPIRATION_START);
    }

    @Step("Wait until second expiration countdown over")
    public void waitUntilSecondExpirationCountdownOver() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMinutes(5));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(confirmationCodeScreen.getExpirationTextView(), CODE_HAS_EXPIRED));
        verifyExpirationCountdownEquals(CODE_HAS_EXPIRED);
    }

    public void errorFrameSwitchToIt() {
        errorFrame = confirmationCodeScreen.getErrorFrame();
    }

    public void errorFrameVerifyErrorTextTitle(String expectedText) {
        Verify.verifyEquals(errorFrame.getErrorTextTitle(), expectedText, "Error text on error frame equals: " + expectedText);
    }

    public void errorFrameTapOnChangeMethodLink() {
        errorFrame.tapOnChangeMethodLink();
    }

    public void errorFrameTapOnRepeatLaterLink() {
        errorFrame.tapOnRepeatLaterLink();
    }

    @Step("Verify repeatLaterButton is enabled")
    public void verifyRepeatLaterButtonIsEnabled() {
        Verify.verifyTrue(confirmationCodeScreen.isRepeatLaterButtonEnabled(), "repeatLaterButton is enabled");
    }

    @Step("Verify changeMethodButton is enabled")
    public void verifyChangeMethodButtonIsEnabled() {
        Verify.verifyTrue(confirmationCodeScreen.isChangeMethodButtonEnabled(), "changeMethodButton is enabled");
    }

    @Step("Email is displayed")
    public void verifyEmailIsDisplayed() {
        VerifySoft.verifyTrueSoft(confirmationCodeScreen.idEmailDisplayed(), "Email is displayed");
    }

    @Step("Code field is displayed")
    public void verifyCodeFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(confirmationCodeScreen.isConfirmInputFieldDisplayed(), "Code field is displayed");
    }

    @Step("Send again is displayed")
    public void verifySendAgainIsDisplayed() {
        VerifySoft.verifyTrueSoft(confirmationCodeScreen.isSendAgainButtonDisplayed(), "Send again is displayed");
    }
}