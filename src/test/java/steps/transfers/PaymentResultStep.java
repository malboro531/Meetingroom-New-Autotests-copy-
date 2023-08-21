package steps.transfers;

import api.pages.transfers.ResultScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class PaymentResultStep {

    protected ResultScreen resultScreen;

    @Step("On 'Payment result' screen")
    public void onResultScreen() {
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

    @Step("Verify that transfer result field displays {text}")
    public void verifyResultFieldText(String text) {
        Verify.verifyEquals(text, resultScreen.getTransferResultText(),
                "Result field displays correct message");
    }
}
