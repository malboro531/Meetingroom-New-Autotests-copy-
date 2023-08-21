package steps;

import api.pages.PaymentsByBankDetailsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class PaymentsByBankDetailsStep {

    protected PaymentsByBankDetailsScreen paymentsByBankDetailsScreen;

    @Step("On 'Payments by bank details' screen")
    public void onPaymentsByBankDetailsScreen() {
        paymentsByBankDetailsScreen = new PaymentsByBankDetailsScreen();
    }

    @Step("Verify that payment by bank details title is displayed")
    public void verifyPaymentByBankDetailsTitleIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isPaymentByBankDetailsTitleDisplayed(), "Payment by bank details title is displayed");
    }

    @Step("Verify that taxpayer identification number is displayed")
    public void verifyTaxpayerIdNumberIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isTaxpayerIdNumberDisplayed(), "Taxpayer identification number is displayed");
    }

    @Step("Verify that account number is displayed")
    public void verifyAccountNumberIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isAccountNumberDisplayed(), "Account number is displayed");
    }

    @Step("Verify that bank identification code is displayed")
    public void verifyBankIdCodeIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isBankIdCodeDisplayed(), "Bank identification code is displayed");
    }

    @Step("Verify that swift code is displayed")
    public void verifySwiftCodeIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isSwiftCodeDisplayed(), "Swift code is displayed");
    }

    @Step("Verify that back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Verify that next button is not enabled")
    public void verifyNextButtonIsNotEnabled() {
        Verify.verifyFalse(paymentsByBankDetailsScreen.isNextButtonEnabled(), "Next button isn't enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        paymentsByBankDetailsScreen.tapOnBackButton();
    }

    @Step("Tap on next button")
    public void tapOnNextButton() {
        paymentsByBankDetailsScreen.tapOnNextButton();
    }

    @Step("Verify that next button is enabled")
    public void verifyNextButtonIsEnabled() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isNextButtonEnabled(), "Next button is enabled");
    }

    @Step("Enter {taxpayerNumber} to taxpayer identification number field")
    public void enterTaxpayerIdNumber(String taxpayerNumber) {
        paymentsByBankDetailsScreen.enterTaxpayerIdNumber(taxpayerNumber);
    }

    @Step("Enter {number} to account number field")
    public void enterAccountNumber(String number) {
        paymentsByBankDetailsScreen.enterAccountNumber(number);
    }

    @Step("Enter {code} to bank identification code field")
    public void enterBankIdCode(String code) {
        paymentsByBankDetailsScreen.enterBankIdCode(code);
    }

    @Step("Enter {swift} to swift code field")
    public void enterSwiftCode(String swift) {
        paymentsByBankDetailsScreen.enterSwiftCode(swift);
    }

    @Step("Verify that name of bank is displayed")
    public void verifyBankNameIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isBankNameDisplayed(), "Name of bank is displayed");
    }

    @Step("Verify that payee is displayed")
    public void verifyPayeeIsDisplayed() {
        Verify.verifyTrue(paymentsByBankDetailsScreen.isPayeeDisplayed(), "Payee is displayed");
    }

    public String getSwiftCodeText() {
        return paymentsByBankDetailsScreen.getSwiftText();
    }

    public String getNameOfBankText() {
        return paymentsByBankDetailsScreen.getNameOfBankText();
    }

    public String getPayeeText() {
        return paymentsByBankDetailsScreen.getPayeeText();
    }
}
