package steps.transfers;

import api.pages.transfers.AmountScreen;
import api.pages.transfers.ConfirmationTransferScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class AmountStep {

    protected AmountScreen amountScreen;

    @Step("On 'Confirmation transfer' screen")
    public AmountStep onAmountScreen() {
        amountScreen = new AmountScreen();
        return this;
    }

    @Step("Tap on confirm button")
    public AmountStep tapOnConfirmButton() {
        amountScreen.tapOnConfirmButton();
        return this;
    }

    @Step("Tap on arrow button")
    public AmountStep tapOnArrowButton() {
        amountScreen.tapOnArrowButton();
        return this;
    }

    @Step("Tap on cross button")
    public AmountStep tapOnCrossButton() {
        amountScreen.tapOnCrossButton();
        return this;
    }

    @Step("Enter amount {amount} to amount field")
    public AmountStep enterAmountToAmountField(String amount) {
        amountScreen.enterAmount(amount);
        return this;
    }

    @Step("Verify that helper message is correct")
    public AmountStep verifyHelperMessageIsCorrect(String helperMessage) {
        Verify.verifyEquals(helperMessage, amountScreen.getHelperMessageText(),
                "Helper message is correct");
        return this;
    }

    @Step("Verify that error message is correct")
    public AmountStep verifyErrorMessageIsCorrect(String errorMessage) {
        Verify.verifyEquals(errorMessage, amountScreen.getErrorMessageText(),
                "Error message is correct");
        return this;
    }

    @Step("Verify that 'confirm button' is not enabled")
    public AmountStep verifyConfirmButtonIsNotEnabled() {
        Verify.verifyFalse(amountScreen.isConfirmButtonEnabled(), "Confirm button is not enabled");
        return this;
    }
}

