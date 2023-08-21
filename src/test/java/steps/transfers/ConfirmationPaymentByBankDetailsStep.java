package steps.transfers;

import api.pages.transfers.ConfirmationByAccountTransferScreen;
import api.pages.transfers.ConfirmationPaymentByBankDetailsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ConfirmationPaymentByBankDetailsStep {

    protected ConfirmationPaymentByBankDetailsScreen confirmationPaymentByBankDetailsScreen;

    @Step("On 'Confirmation payment by bank details' screen")
    public void onConfirmationPaymentByBankDetailsScreen() {
        confirmationPaymentByBankDetailsScreen = new ConfirmationPaymentByBankDetailsScreen();
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Verify pay button is enabled")
    public void verifyPayButtonIsEnabled() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isPayButtonEnabled(), "Pay button is enabled");
    }

    @Step("Tap to pay confirmation button")
    public void tapToPayButton() {
        confirmationPaymentByBankDetailsScreen.tapToPayButton();
    }

    @Step("Tap on back button")
    public void tapToBackButton() {
        confirmationPaymentByBankDetailsScreen.tapToBackButton();
    }

    @Step("Verify that pay confirmation title is displayed")
    public void verifyPayConfirmationTitleIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isPaymentConfirmationTitleDisplayed(),
                "Confirmation title is displayed");
    }

    @Step("Verify that from account header is displayed")
    public void verifyFromAccountHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isFromAccountHeaderDisplayed(), "From account header is displayed");
    }

    @Step("Verify from account field displays {fromAccount}")
    public void verifyFromAccountText(String fromAccount) {
        Verify.verifyEquals(fromAccount, confirmationPaymentByBankDetailsScreen.getFromAccountText(),"From account is correct");
    }

    @Step("Verify that from amount header is displayed")
    public void verifyFromAmountHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isAmountHeaderDisplayed(), "From amount header is displayed");
    }

    @Step("Verify from amount field displays {amount}")
    public void verifyAmountText(String amount) {
        Verify.verifyEquals("₽ " + amount, confirmationPaymentByBankDetailsScreen.getAmountText(), "Amount is correct");
    }

    @Step("Verify that payee header is displayed")
    public void verifyPayeeHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isPayeeHeaderDisplayed(), "Payee header is displayed");
    }

    @Step("Verify payee field displays {payee}")
    public void verifyPayeeText(String payee) {
        Verify.verifyEquals(payee, confirmationPaymentByBankDetailsScreen.getPayeeText(),"Payee is correct");
    }

    @Step("Verify that taxpayer header is displayed")
    public void verifyTaxpayerHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isTaxpayerHeaderDisplayed(), "Taxpayer header is displayed");
    }

    @Step("Verify taxpayer field displays {taxpayer}")
    public void verifyTaxpayerText(String taxpayer) {
        Verify.verifyEquals(taxpayer, confirmationPaymentByBankDetailsScreen.getTaxpayerText(),"Taxpayer is correct");
    }

    @Step("Verify that account number header is displayed")
    public void verifyAccountNumberHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isAccountNumberDisplayed(), "Account number header is displayed");
    }

    @Step("Verify account number field displays {accountNumber}")
    public void verifyAccountNumberText(String accountNumber) {
        Verify.verifyEquals(accountNumber, confirmationPaymentByBankDetailsScreen.getAccountNumberText(),"Account number is correct");
    }

    @Step("Verify that bic header is displayed")
    public void verifyBicHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isBicDisplayed(), "Bic header is displayed");
    }

    @Step("Verify bic field displays {bic}")
    public void verifyBicText(String bic) {
        Verify.verifyEquals(bic, confirmationPaymentByBankDetailsScreen.getBicText(),"Bic is correct");
    }

    @Step("Verify that swift header is displayed")
    public void verifySwiftHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isSwiftDisplayed(), "Swift header is displayed");
    }

    @Step("Verify swift field displays {swift}")
    public void verifySwiftText(String swift) {
        Verify.verifyEquals(swift, confirmationPaymentByBankDetailsScreen.getSwiftText(),"Swift is correct");
    }

    @Step("Verify that bank name header is displayed")
    public void verifyBankNameHeaderIsDisplayed() {
        Verify.verifyTrue(confirmationPaymentByBankDetailsScreen.isBankNameDisplayed(), "Bank name header is displayed");
    }

    @Step("Verify bank name field displays {bankName}")
    public void verifyBankNameText(String bankName) {
        Verify.verifyEquals(bankName, confirmationPaymentByBankDetailsScreen.getBankNameText(),"Bank name is correct");
    }
}
