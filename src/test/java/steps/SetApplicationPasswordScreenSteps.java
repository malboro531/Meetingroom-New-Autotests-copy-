package steps;

import api.pages.SetApplicationPasswordScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class SetApplicationPasswordScreenSteps {

    protected SetApplicationPasswordScreen setApplicationPasswordScreen;

    @Step("On 'Set application password' screen")
    public void onSetApplicationPasswordScreen() {
        setApplicationPasswordScreen = new SetApplicationPasswordScreen();
    }

    @Step("Verify 'Set Application Password' screen is open")
    public void verifySetApplicationPasswordScreenIsOpen() {
        setApplicationPasswordScreen.verifyPageIsOpened();
    }

    @Step("Tap set new password Button")
    public void tapSetNewPasswordButton() {
        setApplicationPasswordScreen.tapSetNewPasswordButton();
    }

    @Step("Tap Use Password Switch CheckBox")
    public void tapUsePasswordSwitchRadioButton() {
        setApplicationPasswordScreen.tapUsePasswordSwitchRadioButton();
    }

    @Step("Password Switch CheckBox is Checked")
    public void verifyPasswordSwitchRadioButtonIsChecked() {
        Verify.verifyTrue(setApplicationPasswordScreen.isPasswordSwitchRadioButtonChecked(), "Password Switch CheckBox Is Checked");
    }

    @Step("Set application pin code")
    public void setApplicationPinCode() {
        MainStep mainStep = new MainStep();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();

        UserProfileStep userProfileStep = new UserProfileStep();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserSafety();

        UserSafetyScreenSteps userSafetyScreenSteps = new UserSafetyScreenSteps();
        userSafetyScreenSteps.onUserSafetyScreen();
        userSafetyScreenSteps.verifyUserSafetyScreenIsOpened();
        userSafetyScreenSteps.tapSetApplicationPasswordButton();

        SetApplicationPasswordScreenSteps setApplicationPasswordScreenSteps = new SetApplicationPasswordScreenSteps();
        setApplicationPasswordScreenSteps.onSetApplicationPasswordScreen();
        setApplicationPasswordScreenSteps.verifySetApplicationPasswordScreenIsOpen();
        setApplicationPasswordScreenSteps.tapSetNewPasswordButton();

        EnterApplicationPasswordScreenStep enterApplicationPasswordScreenStep = new EnterApplicationPasswordScreenStep();
        enterApplicationPasswordScreenStep.onEnterApplicationPasswordScreen();
        enterApplicationPasswordScreenStep.verifyEnterApplicationPasswordScreenIsOpen();
        enterApplicationPasswordScreenStep.typeApplicationPassword();
        enterApplicationPasswordScreenStep.typeApplicationPassword();
        enterApplicationPasswordScreenStep.confirmPassword();

        setApplicationPasswordScreenSteps.verifySetApplicationPasswordScreenIsOpen();
        setApplicationPasswordScreenSteps.tapUsePasswordSwitchRadioButton();
        setApplicationPasswordScreenSteps.verifyPasswordSwitchRadioButtonIsChecked();
    }
}
