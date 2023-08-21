package steps;

import api.pages.EnterApplicationPasswordScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class EnterApplicationPasswordScreenStep {

    protected EnterApplicationPasswordScreen enterApplicationPasswordScreen;

    @Step("On 'EnterApplicationPasswordScreen' screen")
    public void onEnterApplicationPasswordScreen() {
        enterApplicationPasswordScreen = new EnterApplicationPasswordScreen();
    }

    @Step("Verify 'EnterApplicationPasswordScreen' screen is open")
    public void verifyEnterApplicationPasswordScreenIsOpen() {
        enterApplicationPasswordScreen.verifyPageIsOpened();
    }

    @Step("Is Alert: The Wrong Pin Code Five Times Displayed()")
    public void verifyAlertTheWrongPinCodeFiveTimesDisplayed() {
        Verify.verifyTrue(enterApplicationPasswordScreen.isAlertTheWrongPinCodeFiveTimesDisplayed(), "Alert You Entered The Wrong Pin Code Five Times Is Displayed");
    }

    @Step("Tap  Ok Button on alert You Entered The Wrong Pin Code Five Times ")
    public void tapAlertWrongPinCodeOkButton() {
        enterApplicationPasswordScreen.tapAlertWrongPinCodeOkButton();
    }

    @Step("Type Application Pin code")
    public void typeApplicationPassword() {
        enterApplicationPasswordScreen.tapNumber1();
        enterApplicationPasswordScreen.tapNumber9();
        enterApplicationPasswordScreen.tapNumber3();
        enterApplicationPasswordScreen.tapNumber0();
        enterApplicationPasswordScreen.tapNumberOk();
    }

    @Step("Type 5 times not valid Pin Code")
    public void typeNotValidApplicationPasswordFiveTimes() {
        for (int i = 0; i < 5; i++) {
            enterApplicationPasswordScreen.tapNumber1();
            enterApplicationPasswordScreen.tapNumber2();
            enterApplicationPasswordScreen.tapNumber3();
            enterApplicationPasswordScreen.tapNumber4();
            enterApplicationPasswordScreen.tapNumberOk();
            if (i < 4) confirmPassword();
        }
    }

    @Step("Confirm Password after set up")
    public void confirmPassword() {
        enterApplicationPasswordScreen.tapConfirmPassword();
    }
}
