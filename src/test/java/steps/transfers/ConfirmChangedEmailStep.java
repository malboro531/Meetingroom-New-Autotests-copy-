package steps.transfers;

import api.pages.transfers.EmailSuccessChangedScreen;
import io.qameta.allure.Step;

public class ConfirmChangedEmailStep {

    protected EmailSuccessChangedScreen emailSuccessChangedScreen;

    @Step("On 'Email successfully has changed screen'")
    public void onEmailSuccessChangedScreen() {
        emailSuccessChangedScreen = new EmailSuccessChangedScreen();
    }

    @Step("Verify 'Email successfully has changed'")
    public void verifyEmailSuccessChangedScreenOpen() {
        emailSuccessChangedScreen.verifyPageIsOpened();
    }

    @Step("Tap button 'Confirm'")
    public void tapOnConfirmButton() {
        emailSuccessChangedScreen.tapConfirmButton();
    }
}
