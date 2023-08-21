package steps;

import api.pages.TwoButtonsConfirmationScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class TwoButtonsConfirmationScreenStep {

    protected TwoButtonsConfirmationScreen twoButtonsConfirmationScreen;

    @Step("On 'Confirmation' screen")
    public void onConfirmationScreen() {
        twoButtonsConfirmationScreen = new TwoButtonsConfirmationScreen();
    }

    @Step("Verify 'Confirmation' screen is open")
    public void verifyConfirmationScreenIsOpened() {
        twoButtonsConfirmationScreen.verifyPageIsOpened();
    }

    @Step("Tap Reject Button")
    public void tapRejectButton() {
        twoButtonsConfirmationScreen.tapRejectBackButton();
    }

    @Step("Verify Reject Button Displayed")
    public void verifyRejectButtonDisplayed() {
        Verify.verifyTrue(twoButtonsConfirmationScreen.isrejectButtonDisplayed(), "verify reject Button Is Displayed");
    }

    @Step(" Verify apply Button Is Displayed")
    public void verifyApplyButtonDisplayed() {
        Verify.verifyTrue(twoButtonsConfirmationScreen.isApplyButtonDisplayed(), "verify apply Button Is Displayed");
    }
}