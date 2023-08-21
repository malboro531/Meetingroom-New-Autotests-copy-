package steps;

import api.pages.PaymentByBankDetailsEnterAmountScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class PaymentByBankDetailsEnterAmountStep {

    protected PaymentByBankDetailsEnterAmountScreen paymentByBankDetailsEnterAmountScreen;

    @Step("On 'Payments by bank details - enter account and amount' screen")
    public void onPaymentsByBankDetailsEnterAmountScreen() {
        paymentByBankDetailsEnterAmountScreen = new PaymentByBankDetailsEnterAmountScreen();
    }

    @Step("Verify that from account is displayed")
    public void verifyFromAccountIsDisplayed() {
        Verify.verifyTrue(paymentByBankDetailsEnterAmountScreen.isFromAccountDisplayed(), "From account is displayed");
    }

    @Step("Verify that enter amount is displayed")
    public void verifyEnterAmountIsDisplayed() {
        Verify.verifyTrue(paymentByBankDetailsEnterAmountScreen.isEnterAmountDisplayed(), "Enter amount is displayed");
    }

    @Step("Tap on from account field")
    public void tapOnFromAccountField() {
        paymentByBankDetailsEnterAmountScreen.tapOnSelectAccount();
    }

    @Step("Tap on enter amount field")
    public void tapOnEnterAmountField() {
        paymentByBankDetailsEnterAmountScreen.tapOnEnterAmountField();
    }

    @Step("Enter {amount} to enter amount field")
    public void enterAmount(String amount) {
        paymentByBankDetailsEnterAmountScreen.enterAmount(amount);
    }

    @Step("Verify that confirm button is enabled")
    public void verifyConfirmButtonIsEnabled() {
        Verify.verifyTrue(paymentByBankDetailsEnterAmountScreen.isConfirmButtonEnabled(), "Confirm button is enabled");
    }

    @Step("Verify that confirm button isn't enabled")
    public void verifyConfirmButtonIsNotEnabled() {
        Verify.verifyFalse(paymentByBankDetailsEnterAmountScreen.isConfirmButtonEnabled(), "Confirm button isn't enabled");
    }

    @Step("Tap on confirm button")
    public void tapOnConfirmButton() {
        paymentByBankDetailsEnterAmountScreen.tapOnConfirmButton();
    }

    @Step("Verify that back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(paymentByBankDetailsEnterAmountScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        paymentByBankDetailsEnterAmountScreen.tapOnBackButton();
    }

    @Step("Tap on account name")
    public void tapOnAccountName() {
        paymentByBankDetailsEnterAmountScreen.tapOnAccountName();
    }

    @Step("Get account number text")
    public String getAccountNumberText() {
        return paymentByBankDetailsEnterAmountScreen.getAccountNumberText();
    }
}
