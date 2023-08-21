package steps.transfers;

import api.pages.transfers.DetailsForTransferByPhoneNumberScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class DetailsForTransferByPhoneNumberStep {

    protected DetailsForTransferByPhoneNumberScreen detailsForTransferByPhoneNumberScreen;

    @Step("On details for transfer by phone number screen")
    public void onDetailsForTransferByPhoneNumberScreen() {
        detailsForTransferByPhoneNumberScreen = new DetailsForTransferByPhoneNumberScreen();
    }

    @Step("Verify that 'Confirm' button is not enabled")
    public void verifyConfirmButtonNotEnabled() {
        Verify.verifyFalse(detailsForTransferByPhoneNumberScreen.isConfirmButtonEnabled(),
                "Continue button is not enabled");
    }

    @Step("Tap on 'Enter Amount' field")
    public void tapOnEnterAmountField() {
        detailsForTransferByPhoneNumberScreen.tapOnEnterAmountField();
    }

    @Step("Enter amount to 'Enter Amount' field")
    public void enterSumToEnterAmountField(String sum) {
        detailsForTransferByPhoneNumberScreen.enterSumToEnterAmountField(sum);
    }

    @Step("Tap on 'Transfer Assignment' field")
    public void tapOnTransferAssignmentField() {
        detailsForTransferByPhoneNumberScreen.tapOnTransferAssignmentField();
    }

    @Step("Enter information to 'Transfer Assignment' field")
    public void enterMessageToTransferAssignmentField(String message) {
        detailsForTransferByPhoneNumberScreen.enterMessageToTransferAssignmentField(message);
    }

    @Step("Tap on confirm button")
    public void tapOnConfirmButton() {
        detailsForTransferByPhoneNumberScreen.tapOnConfirmButton();
    }
}
