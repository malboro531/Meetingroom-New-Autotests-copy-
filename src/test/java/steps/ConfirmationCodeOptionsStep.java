package steps;

import api.pages.ConfirmationCodeOptionsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ConfirmationCodeOptionsStep {

    protected ConfirmationCodeOptionsScreen confirmationCodeOptionsScreen;

    @Step("On ConfirmationCodeOptionsScreen")
    public void onConfirmationCodeOptionsScreen() {
        confirmationCodeOptionsScreen = new ConfirmationCodeOptionsScreen();
    }

    @Step("Verify ConfirmationCodeOptionsScreen is open")
    public void verifyConfirmationCodeOptionsScreenIsOpen() {
        confirmationCodeOptionsScreen.verifyPageIsOpened();
    }

    @Step("Tap on Back button")
    public void tapOnBackIcon() {
        confirmationCodeOptionsScreen.tapOnBackIcon();
    }

    @Step("Tap on Proceed button")
    public void tapOnProceedIcon() {
        confirmationCodeOptionsScreen.tapOnProceedButton();
    }

    @Step("Tap on smsRadioButton")
    public void tapOnSmsRadioButton() {
        confirmationCodeOptionsScreen.tapOnSmsRadioButton();
    }

    @Step("Tap on pushRadioButton")
    public void tapOnPushRadioButton() {
        confirmationCodeOptionsScreen.tapOnPushRadioButton();
    }

    @Step("Tap on emailRadioButton")
    public void tapOnEmailRadioButton() {
        confirmationCodeOptionsScreen.tapOnEmailRadioButton();
    }

    @Step("Verify smsRadioButton is checked")
    public void verifySmsRadioButtonIsChecked() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isSmsRadioButtonChecked(), "smsRadioButton is checked");
    }

    @Step("Verify smsRadioButton is not checked")
    public void verifySmsRadioButtonIsNotChecked() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isSmsRadioButtonNotChecked(), "smsRadioButton is not checked");
    }

    @Step("Verify pushRadioButton is checked")
    public void verifyPushRadioButtonIsChecked() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isPushRadioButtonChecked(), "pushRadioButton is checked");
    }

    @Step("Verify pushRadioButton is not checked")
    public void verifyPushRadioButtonIsNotChecked() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isPushRadioButtonNotChecked(), "pushRadioButton is " +
                "not checked");
    }

    @Step("Verify emailRadioButton is checked")
    public void verifyEmailRadioButtonIsChecked() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isEmailRadioButtonChecked(), "emailRadioButton is checked");
    }

    @Step("Verify proceedButton is enabled")
    public void verifyProceedButtonIsEnabled() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isProceedButtonEnabled(), "proceedButton is enabled");
    }

    @Step("Verify backIcon is enabled")
    public void verifyBackIconIsEnabled() {
        Verify.verifyTrue(confirmationCodeOptionsScreen.isBackIconEnabled(), "backIcon is enabled");
    }
}
