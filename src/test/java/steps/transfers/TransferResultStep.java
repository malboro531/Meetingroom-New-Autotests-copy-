package steps.transfers;

import api.pages.transfers.ResultScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class TransferResultStep {

    protected ResultScreen resultScreen;

    @Step("On 'Transfer result' screen")
    public TransferResultStep onTransferResultScreen() {
        resultScreen = new ResultScreen();
        return this;
    }

    @Step("Tap to 'back to main menu' button")
    public TransferResultStep tapToBackToMainMenuButton() {
        resultScreen.tapToBackToMainMenuButton();
        return this;
    }

    @Step("Verify that 'Back to main menu' button is enabled")
    public TransferResultStep verifyIsBackToMainButtonEnabled() {
        Verify.verifyTrue(resultScreen.isBackToMainButtonEnabled(),
                "Back to main menu button is enabled");
        return this;
    }

    @Step("Verify that transfer result field displays correct text")
    public TransferResultStep verifyResultFieldDisplaysCorrectText(String text) {
        Verify.verifyEquals(text, resultScreen.getTransferResultText(),
                "Result field displays correct text");
        return this;
    }
}
