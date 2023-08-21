package steps.cards;

import api.widgets.AlertFrame;
import io.qameta.allure.Step;
import verification.Verify;

public class BlockCardStep {

    public AlertFrame alertFrame;

    @Step("On 'Block card frame'")
    public void onBlockCardFrame() {
        alertFrame = new AlertFrame();
    }

    @Step("Verify that alert title text is '{text}'")
    public void verifyAlertTitleText(String text) {
        Verify.verifyEquals(text, alertFrame.getAlertTitleText(), "Alert title text is correct");
    }

    @Step("Verify that alert message text is '{message}'")
    public void verifyAlertMessageText(String message) {
        Verify.verifyEquals(message, alertFrame.getAlertMessageText(), "Alert message text is correct");
    }

    @Step("Tap on cancel button")
    public void tapOnCancelButton() {
        alertFrame.tapOnCancelButton();
    }

    @Step("Tap on confirm button")
    public void tapOnConfirmButton() {
        alertFrame.tapOnConfirmButton();
    }
}
