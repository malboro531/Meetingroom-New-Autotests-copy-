package steps.transfers;

import api.pages.transfers.TransferByAccountNumberScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class TransferByAccountNumberStep {
    protected TransferByAccountNumberScreen transferByAccountNumberScreen;

    @Step("On Transfer by account number screen")
    public void onTransferByPhoneNumberScreen() {
        transferByAccountNumberScreen = new TransferByAccountNumberScreen();
    }

    @Step("Verify that 'Next' button is not enabled")
    public void verifyNextButtonNotEnabled() {
        Verify.verifyFalse(transferByAccountNumberScreen.isNextButtonEnabled(),
                "Next button is not enabled");
    }

    @Step("Enter account to 'From account' field")
    public void enterAccountToFromAccountField() {
        transferByAccountNumberScreen.tapToFromAccountField();
    }

    @Step("Choose from account")
    public void tapOnClickableAreaForFromAccountSelection() {
        transferByAccountNumberScreen.tapOnClickableAreaForAccountSelection();
    }

    @Step("Tap to 'To account' field for keyboard visibility")
    public void tapToToAccountField() {
        transferByAccountNumberScreen.tapToToAccountField();
    }

    @Step("Enter account to 'To account' field")
    public void enterAccountToToAccountField(String toAccount) {
        transferByAccountNumberScreen.enterAccountToToAccountField(toAccount);
    }

    @Step("Tap to 'Next' button")
    public void tapToNextButton() {
        transferByAccountNumberScreen.tapToNextButton();
    }

    @Step("Get 'From account' text")
    public String getFromAccountText() {
        return transferByAccountNumberScreen.getFromAccountText();
    }

    @Step("Get 'Recipient' text")
    public String getRecipientText() {
        return transferByAccountNumberScreen.getRecipientsName();
    }
}
