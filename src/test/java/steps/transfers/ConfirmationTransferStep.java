package steps.transfers;

import api.pages.transfers.ConfirmationTransferScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ConfirmationTransferStep {

    protected ConfirmationTransferScreen confirmationTransferScreen;

    @Step("On 'Confirmation transfer' screen")
    public ConfirmationTransferStep onConfirmationTransferScreen() {
        confirmationTransferScreen = new ConfirmationTransferScreen();
        return this;
    }

    @Step("Tap on transfer button")
    public ConfirmationTransferStep tapOnTransferButton() {
        confirmationTransferScreen.tapOnTransferButton();
        return this;
    }

    @Step("Verify that choosen 'destination card' field displays correct data")
    public ConfirmationTransferStep verifyDestinationCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, confirmationTransferScreen.getDestinationCardText(),
                "Destination card field displays correct data");
        return this;
    }

    @Step("Verify that choosen 'source card' field displays correct data")
    public ConfirmationTransferStep verifySourceCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, confirmationTransferScreen.getSourceCardText(),
                "Source card field displays correct data");
        return this;
    }

    @Step("Verify that chosen amount is displayed")
    public ConfirmationTransferStep verifyAmount$IsDisplayed(String amount) {
        Verify.verifyEquals("$ " + amount, confirmationTransferScreen.getAmountText(),
                "Chosen amount is displayed");
        return this;
    }
}
