package steps;

import api.pages.ChangePasswordScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import verification.Verify;
import verification.VerifySoft;

import java.util.concurrent.TimeoutException;

public class ChangePasswordStep {

    protected ChangePasswordScreen changePasswordScreen;

    @Step("On 'ChangePasswordScreen'")
    public void onChangePasswordScreen() {
        changePasswordScreen = new ChangePasswordScreen();
    }

    @Step("Verify 'ChangePasswordScreen' is open")
    public void verifyChangePasswordScreenIsOpen() {
        changePasswordScreen.verifyPageIsOpened();
    }

    @Step("Tap on enter password field on change password screen")
    public void tapOnEnterPasswordField() {
        changePasswordScreen.tapOnEnterPasswordField();
    }

    @Step("Verify massage Enter old password")
    public void verifyOldPasswordTitleTextField(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, changePasswordScreen.getOldPasswordTitleTextField(), "Message is present: " + changePasswordScreen.getOldPasswordTitleTextField());
    }

    @Step("Verify massage Enter new password")
    public void verifyNewPasswordTitleTextField(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, changePasswordScreen.getNewPasswordTitleTextField(), "Message is present: " + changePasswordScreen.getNewPasswordTitleTextField());
    }

    @Step("Verify massage Reply new password")
    public void verifyReplayNewPasswordTitleTextField(String expectedMessage) {
        Verify.verifyEquals(expectedMessage, changePasswordScreen.getReplayNewPasswordTitleTextField(), "Message is present: " + changePasswordScreen.getReplayNewPasswordTitleTextField());
    }

    @Step("Verify Enter old password is displayed")
    public void verifyDisplayedEnterOldPassword() {
        VerifySoft.verifyTrueSoft(changePasswordScreen.isDisplayedOldPassword(), "Enter old password is displayed");
    }

    @Step("Verify Enter new password is displayed")
    public void verifyDisplayedEnterNewPassword() {
        VerifySoft.verifyTrueSoft(changePasswordScreen.isDisplayedNewPassword(), "Enter new password is displayed");
    }

    @Step("Verify Replay new password is displayed")
    public void verifyDisplayedReplayNewPassword() {
        VerifySoft.verifyTrueSoft(changePasswordScreen.isDisplayedReplayNewPassword(), "Replay new password is displayed");
    }

    public void verifyConfirmButtonIsNotEnabled() {
        VerifySoft.verifyFalseSoft(changePasswordScreen.isConfirmButtonEnabled(), "Button confirm is not enabled");
    }
}