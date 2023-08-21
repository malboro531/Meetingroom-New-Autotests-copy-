package steps.transfers;

import api.pages.transfers.ConfirmationByAccountTransferScreen;
import api.pages.transfers.ConfirmationByPhoneTransferScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ConfirmationByAccountTransferStep {

    protected ConfirmationByAccountTransferScreen confirmationByAccountTransferScreen;

    @Step("On 'Confirmation by account transfer' screen")
    public void onConfirmationByAccountTransferScreen() {
        confirmationByAccountTransferScreen = new ConfirmationByAccountTransferScreen();
    }

    @Step("Verify that 'From account' field displays correct data")
    public void verifyFromAccountFieldText(String fromAccount) {
        Verify.verifyEquals(fromAccount, confirmationByAccountTransferScreen.getFromAccountText(),
                "From account field displays correct data");
    }

    @Step("Verify that 'To account' field displays correct data")
    public void verifyToAccountFieldText(String toAccount) {
        Verify.verifyEquals(toAccount, confirmationByAccountTransferScreen.getToAccountText(),
                "To account field displays correct data");
    }


    @Step("Verify that 'Recipient' field displays correct data")
    public void verifyRecipientFieldText(String recipient) {
        Verify.verifyEquals(recipient, confirmationByAccountTransferScreen.getRecipient(),
                "Recipient field displays correct data");
    }

    @Step("Verify that 'Amount' field displays correct data")
    public void verifyAmountFieldText(String amount) {
        Verify.verifyEquals("$ " + amount, confirmationByAccountTransferScreen.getAmountText(),
                "Amount field displays correct data");
    }

    @Step("Verify that 'Transfer assignment' field displays correct data")
    public void verifyTransferAssignmentFieldText(String message) {
        Verify.verifyEquals(message, confirmationByAccountTransferScreen.getAssignmentText(),
                "Transfer assignment field displays correct data");
    }

    @Step("Tap on 'Transfer' button")
    public void tapOnTransferButton() {
        confirmationByAccountTransferScreen.tapOnTransferButton();
    }
}
