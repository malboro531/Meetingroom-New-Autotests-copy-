package steps.transfers;

import api.pages.transfers.ConfirmationByPhoneTransferScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ConfirmationByPhoneTransferStep {

    protected ConfirmationByPhoneTransferScreen confirmationByPhoneTransferScreen;

    @Step("On 'Confirmation by phone transfer' screen")
    public void onConfirmationByPhoneTransferScreen() {
        confirmationByPhoneTransferScreen = new ConfirmationByPhoneTransferScreen();
    }

    @Step("Verify that 'From account' field displays correct data")
    public void verifyFromAccountFieldText(String account) {
        Verify.verifyEquals(account, confirmationByPhoneTransferScreen.getFromAccountText(),
                "From account field displays correct data");
    }

    @Step("Verify that 'Phone number' field displays correct data")
    public void verifyPhoneNumberFieldText(String number) {
        Verify.verifyEquals(number, confirmationByPhoneTransferScreen.getPhoneNumberText(),
                "Phone number field displays correct data");
    }

    @Step("Verify that 'Amount' field displays correct data")
    public void verifyAmountFieldText(String amount) {
        Verify.verifyEquals("$ " + amount, confirmationByPhoneTransferScreen.getAmountText(),
                "Amount field displays correct data");
    }

    @Step("Verify that 'Transfer assignment' field displays correct data")
    public void verifyTransferAssignmentFieldText(String message) {
        Verify.verifyEquals(message, confirmationByPhoneTransferScreen.getTransferAssignmentText(),
                "Transfer assignment field displays correct data");
    }

    @Step("Tap on 'Transfer' button")
    public void tapOnTransferButton() {
        confirmationByPhoneTransferScreen.tapOnTransferButton();
    }
}

