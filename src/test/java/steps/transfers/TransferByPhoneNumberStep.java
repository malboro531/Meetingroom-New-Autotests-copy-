package steps.transfers;

import api.pages.transfers.TransferByPhoneNumberScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class TransferByPhoneNumberStep {
     protected TransferByPhoneNumberScreen transferByPhoneNumberScreen;

     @Step("On Transfer by phone number screen")
     public void onTransferByPhoneNumberScreen() {
          transferByPhoneNumberScreen = new TransferByPhoneNumberScreen();
     }

     @Step("Verify that 'Continue' button is not enabled")
     public void verifyContinueButtonNotEnabled() {
          Verify.verifyFalse(transferByPhoneNumberScreen.isContinueButtonEnabled(),
                  "Continue button is not enabled");
     }

     @Step("Tap on 'From account' field for visibility of keyboard")
     public void tapOnFromAccountField () {
          transferByPhoneNumberScreen.tapOnFromAccountField();
     }

     @Step("Choose account")
     public void tapOnClickableAreaForAccountSelection() {
          transferByPhoneNumberScreen.tapOnClickableAreaForAccountSelection();
     }

     @Step("Tap on 'Phone number' field for visibility of keyboard")
     public void tapOnPhoneNumberField() {
          transferByPhoneNumberScreen.tapOnPhoneNumberField();
     }

     @Step("Enter phone to 'Phone number' field")
     public void enterPhoneToPhoneNumberField(String phoneNumber) {
          transferByPhoneNumberScreen.enterPhoneToPhoneNumberField(phoneNumber);
     }

     @Step("Tap 'Continue'")
     public void tapToContinueButton() {
          transferByPhoneNumberScreen.tapToContinueButton();
     }
}
