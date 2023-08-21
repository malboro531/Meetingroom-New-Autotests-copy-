package steps.transfers;

import api.pages.transfers.ResultScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class AddAutoPayResultStep {

    protected ResultScreen resultScreen;

    @Step("On 'Add auto pay result' screen")
    public void onAutoPayResultScreen() {
        resultScreen = new ResultScreen();
    }

    @Step("Tap to 'back to main menu' button")
    public void tapToBackToMainMenuButton() {
        resultScreen.tapToBackToMainMenuButton();
    }

    @Step("Verify that 'Back to main menu' button is enabled")
    public void verifyBackToMainMenuButtonIsEnabled() {
        Verify.verifyTrue(resultScreen.isBackToMainButtonEnabled(),
                "Back to main menu button is enabled");
    }

    @Step("Verify that add auto pay result field displays {text}")
    public void verifyResultFieldText(String text) {
        Verify.verifyEquals(text, resultScreen.getTransferResultText(),
                "Result field displays correct message");
    }
}
