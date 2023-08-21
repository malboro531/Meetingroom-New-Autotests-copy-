package mrn_tests.E9_payments.UC_9_1;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseTest;
import steps.PaymentsByBankDetailsStep;
import steps.PaymentsStep;

import static constants.GlobalData.PAYMENTS_TITLE;
import static verification.VerifySoft.showAllChecking;

public class PaymentSectionTest extends BaseTest {

    private PaymentsStep paymentsStep = new PaymentsStep();
    private PaymentsByBankDetailsStep paymentsByBankDetailsStep = new PaymentsByBankDetailsStep();

    @BeforeMethod
    public void openApp() {
        loginUser();
        mainStep.onMainScreen();
    }

    @TestRails(id = "C6384892")
    @Test(description = "Displaying the 'Payment' icon on the Main page", groups = {"GUI"})
    public void c6384892() {
        mainStep.verifyPaymentsButtonIsEnabled();
        showAllChecking();
    }

    @TestRails(id = "C6384932")
    @Test(description = "Displaying information on Payments screen", groups = {"GUI"})
    public void c6384932() {
        mainStep.tapOnPaymentsButton();
        paymentsStep.onPaymentsScreen();
        paymentsStep.verifyPaymentsTitleText(PAYMENTS_TITLE);
        paymentsStep.verifyAddTemplateIsEnabled();
        paymentsStep.verifyAutoPayIsEnabled();
        paymentsStep.verifyPaymentByBankDetailsIsEnabled();
        paymentsStep.verifyBankFeesIsEnabled();
        paymentsStep.verifyTemplatesIsEnabled();
        paymentsStep.verifyAutoPaymentsIsEnabled();
        paymentsStep.verifyCreditPaymentsIsEnabled();
        paymentsStep.verifyOtherIsEnabled();
        showAllChecking();
    }

    @TestRails(id = "C6384931")
    @Test(description = "Back transfer from Payment by bank details screen", groups = {"GUI"})
    public void c6384931() {
        mainStep.tapOnPaymentsButton();
        paymentsStep.onPaymentsScreen();
        paymentsStep.tapOnPaymentsByBankDetails();

        paymentsByBankDetailsStep.onPaymentsByBankDetailsScreen();
        paymentsByBankDetailsStep.verifyPaymentByBankDetailsTitleIsDisplayed();
        paymentsByBankDetailsStep.verifyTaxpayerIdNumberIsDisplayed();
        paymentsByBankDetailsStep.verifyAccountNumberIsDisplayed();
        paymentsByBankDetailsStep.verifyBankIdCodeIsDisplayed();
        paymentsByBankDetailsStep.verifySwiftCodeIsDisplayed();
        paymentsByBankDetailsStep.verifyNextButtonIsNotEnabled();
        paymentsByBankDetailsStep.verifyBackButtonIsEnabled();
        paymentsByBankDetailsStep.tapOnBackButton();

        paymentsStep.onPaymentsScreen();
        paymentsStep.verifyPaymentsTitleText(PAYMENTS_TITLE);
        showAllChecking();
    }
}
