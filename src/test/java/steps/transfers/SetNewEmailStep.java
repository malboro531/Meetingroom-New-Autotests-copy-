package steps.transfers;

import api.pages.transfers.SetNewEmailScreen;
import io.qameta.allure.Step;

public class SetNewEmailStep {

    protected SetNewEmailScreen setNewEmailScreen;

    @Step("On 'SetNewEmailScreen'")
    public void onSetNewEmailScreen() {
        setNewEmailScreen = new SetNewEmailScreen();
    }

    @Step("Enter new Email in editTextField")
    public void enterNewEmail(String newEmail) {
        setNewEmailScreen.enterNewEmail(newEmail);
    }

    @Step("Enter old Email in editTextField")
    public void enterOldEmail(String oldEmail) {
        setNewEmailScreen.enterOldEmail(oldEmail);
    }

    @Step("Enter Save button")
    public void tapPrimaryButton() {
        setNewEmailScreen.tapPrimaryButton();
    }
}
