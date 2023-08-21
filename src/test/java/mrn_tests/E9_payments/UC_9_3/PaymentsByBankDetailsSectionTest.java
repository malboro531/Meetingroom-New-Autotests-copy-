package mrn_tests.E9_payments.UC_9_3;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.*;
import steps.transfers.ConfirmationPaymentByBankDetailsStep;
import steps.transfers.PaymentResultStep;

import static constants.GlobalData.*;
import static driver.manager.DriverManager.closeDeviceKeyboard;

public class PaymentsByBankDetailsSectionTest extends BaseTest {

    private static final String TAXPAYER_ID_NUMBER = "1111111111";
    private static final String ACCOUNT_NUMBER = "88888888888888888888";
    private static final String BANK_ID_CODE = "333222111";
    private static final String BAD_BIC = "111111111";
    private static final String SWIFT_CODE = "deltbank";

    private PaymentsStep paymentsStep = new PaymentsStep();
    private PaymentsByBankDetailsStep paymentsByBankDetailsStep = new PaymentsByBankDetailsStep();
    private PaymentByBankDetailsErrorAlertStep paymentByBankDetailsErrorAlertStep = new PaymentByBankDetailsErrorAlertStep();
    private PaymentByBankDetailsEnterAmountStep paymentByBankDetailsEnterAmountStep = new PaymentByBankDetailsEnterAmountStep();
    private ConfirmationPaymentByBankDetailsStep confirmationPaymentByBankDetailsStep = new ConfirmationPaymentByBankDetailsStep();
    private PaymentResultStep paymentResultStep = new PaymentResultStep();

    @BeforeMethod
    public void openAppAndTransferToPaymentByBankDetails() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnPaymentsButton();
        paymentsStep.onPaymentsScreen();
        paymentsStep.tapOnPaymentsByBankDetails();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
    }

    @TestRails(id = "C6384895")
    @Test(description = "Filling fields on Payments by bank details screen")
    public void c6384895() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.verifyNextButtonIsEnabled();
    }

    @TestRails(id = "C6384913")
    @Test(description = "Displaying of new fields after next button tap")
    public void c6384913() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.verifyBankNameIsDisplayed();
        paymentsByBankDetailsStep.verifyPayeeIsDisplayed();
        paymentsByBankDetailsStep.verifyNextButtonIsEnabled();
    }

    @TestRails(id = "C6384914")
    @Test(description = "Displaying error alert")
    public void c6384914() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BAD_BIC);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsErrorAlertStep.onPaymentByBankDetailsErrorAlert();
        paymentByBankDetailsErrorAlertStep.verifyAlertTitleText(PAYMENT_BY_BANK_DETAILS_ERROR_ALERT_TITLE);
        paymentByBankDetailsErrorAlertStep.verifyAlertMessageText(PAYMENT_BY_BANK_DETAILS_ERROR_ALERT_MESSAGE);
    }

    @TestRails(id = "C6384921")
    @Test(description = "Displaying of the screen with the account selection and the payment amount")
    public void c6384921() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.verifyConfirmButtonIsNotEnabled();
        paymentByBankDetailsEnterAmountStep.verifyFromAccountIsDisplayed();
        paymentByBankDetailsEnterAmountStep.verifyEnterAmountIsDisplayed();
        paymentByBankDetailsEnterAmountStep.verifyBackButtonIsEnabled();
    }

    @TestRails(id = "C6384922")
    @Test(description = "Come back from the screen with the account selection and the payment amount")
    public void c6384922() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.tapOnBackButton();

        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.verifyPaymentByBankDetailsTitleIsDisplayed();
    }

    @TestRails(id = "C6384918")
    @Test(description = "Displaying the 'Payment confirmation' screen when creating a payment")
    public void c6384918() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        String swift = paymentsByBankDetailsStep.getSwiftCodeText();
        String bankName = paymentsByBankDetailsStep.getNameOfBankText();
        String payee = paymentsByBankDetailsStep.getPayeeText();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.tapOnFromAccountField();
        String fromAccount = paymentByBankDetailsEnterAmountStep.getAccountNumberText();
        paymentByBankDetailsEnterAmountStep.tapOnAccountName();
        paymentByBankDetailsEnterAmountStep.tapOnEnterAmountField();
        paymentByBankDetailsEnterAmountStep.enterAmount(AMOUNT_100);
        closeDeviceKeyboard();
        paymentByBankDetailsEnterAmountStep.tapOnConfirmButton();

        confirmationPaymentByBankDetailsStep.onConfirmationPaymentByBankDetailsScreen();
        confirmationPaymentByBankDetailsStep.verifyBackButtonIsEnabled();
        confirmationPaymentByBankDetailsStep.verifyPayButtonIsEnabled();
        confirmationPaymentByBankDetailsStep.verifyPayConfirmationTitleIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyFromAccountHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyFromAccountText(fromAccount);
        confirmationPaymentByBankDetailsStep.verifyFromAmountHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyAmountText(AMOUNT_100);
        confirmationPaymentByBankDetailsStep.verifyPayeeHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyPayeeText(payee);
        confirmationPaymentByBankDetailsStep.verifyTaxpayerHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyTaxpayerText(TAXPAYER_ID_NUMBER);
        confirmationPaymentByBankDetailsStep.verifyAccountNumberHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyAccountNumberText(ACCOUNT_NUMBER);
        confirmationPaymentByBankDetailsStep.verifyBicHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyBicText(BANK_ID_CODE);
        confirmationPaymentByBankDetailsStep.verifySwiftHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifySwiftText(swift);
        confirmationPaymentByBankDetailsStep.verifyBankNameHeaderIsDisplayed();
        confirmationPaymentByBankDetailsStep.verifyBankNameText(bankName);
    }

    @TestRails(id = "C6384919")
    @Test(description = "Coming back from 'Payment confirmation' screen")
    public void c6384919() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.tapOnFromAccountField();
        paymentByBankDetailsEnterAmountStep.tapOnAccountName();
        paymentByBankDetailsEnterAmountStep.enterAmount(AMOUNT_100);
        closeDeviceKeyboard();
        paymentByBankDetailsEnterAmountStep.tapOnConfirmButton();

        confirmationPaymentByBankDetailsStep.onConfirmationPaymentByBankDetailsScreen();
        confirmationPaymentByBankDetailsStep.tapToBackButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.verifyFromAccountIsDisplayed();
    }

    @TestRails(id = "C6384920")
    @Test(description = "Confirm payment bu bank details creating")
    public void c6384920() {
        paymentsByBankDetailsStep.enterTaxpayerIdNumber(TAXPAYER_ID_NUMBER);
        paymentsByBankDetailsStep.enterAccountNumber(ACCOUNT_NUMBER);
        paymentsByBankDetailsStep.enterBankIdCode(BANK_ID_CODE);
        paymentsByBankDetailsStep.enterSwiftCode(SWIFT_CODE);
        closeDeviceKeyboard();
        paymentsByBankDetailsStep.tapOnNextButton();
        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.tapOnNextButton();

        paymentByBankDetailsEnterAmountStep.onPaymentsByBankDetailsEnterAmountScreen();
        paymentByBankDetailsEnterAmountStep.tapOnFromAccountField();
        paymentByBankDetailsEnterAmountStep.tapOnAccountName();
        paymentByBankDetailsEnterAmountStep.enterAmount(AMOUNT_100);
        closeDeviceKeyboard();
        paymentByBankDetailsEnterAmountStep.tapOnConfirmButton();

        confirmationPaymentByBankDetailsStep.onConfirmationPaymentByBankDetailsScreen();
        confirmationPaymentByBankDetailsStep.tapToPayButton();

        paymentResultStep.onResultScreen();
        paymentResultStep.verifyBackToMainMenuButtonIsEnabled();
        paymentResultStep.verifyResultFieldText("Payment successful!");
        paymentResultStep.tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
    }
}
