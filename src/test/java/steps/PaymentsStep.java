package steps;

import api.pages.PaymentsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class PaymentsStep {

    protected PaymentsScreen paymentsScreen;

    @Step("On 'Payments' screen")
    public void onPaymentsScreen() {
        paymentsScreen = new PaymentsScreen();
    }

    @Step("Verify payments title text is '{text}'")
    public void verifyPaymentsTitleText(String text) {
        Verify.verifyEquals(paymentsScreen.getPaymentsTitleText(), text, "Payments title text is correct");
    }

    @Step("Verify that add template button is enabled")
    public void verifyAddTemplateIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isAddTemplateEnabled(), "Add template button is enabled");
    }

    @Step("Verify that add auto pay button is enabled")
    public void verifyAutoPayIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isAddAutoPayEnabled(), "Auto pay button is enabled");
    }

    @Step("Verify that payment by bank details field is enabled")
    public void verifyPaymentByBankDetailsIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isPaymentByBankDetailsEnabled(), "Payment by bank details field is enabled");
    }

    @Step("Verify that bank fees field is enabled")
    public void verifyBankFeesIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isBankFeesEnabled(), "Bank fees field is enabled");
    }

    @Step("Verify that templates is enabled")
    public void verifyTemplatesIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isTemplatesEnabled(), "Templates field is enabled");
    }

    @Step("Verify that auto payments field is enabled")
    public void verifyAutoPaymentsIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isAutoPaymentsEnabled(), "Auto payments field is enabled");
    }

    @Step("Verify that credit payments field is enabled")
    public void verifyCreditPaymentsIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isCreditPaymentsEnabled(), "Credit payments field is enabled");
    }

    @Step("Verify that other field is enabled")
    public void verifyOtherIsEnabled() {
        Verify.verifyTrue(paymentsScreen.isOtherEnabled(), "Other field is enabled");
    }

    @Step("Tap on payments by bank details field")
    public void tapOnPaymentsByBankDetails() {
        paymentsScreen.tapOnPaymentByBankDetailsField();
    }

    @Step("Tap on auto payments field")
    public void tapOnAutoPayments() {
        paymentsScreen.tapOnAutoPaymentsField();
    }
}
