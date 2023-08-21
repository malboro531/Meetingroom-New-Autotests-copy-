package mrn_tests.E9_payments.UC_9_5;

import api.services.TestRails;
import driver.manager.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.*;
import steps.transfers.AddAutoPayResultStep;
import steps.transfers.AutoPayDetailsStep;

import static constants.GlobalData.*;

public class AutoPaymentsTest extends BaseTest {

    private PaymentsStep paymentsStep = new PaymentsStep();
    private AutoPaymentsStep autoPaymentsStep = new AutoPaymentsStep();
    private AdditionAutoPaymentStep additionAutoPaymentStep = new AdditionAutoPaymentStep();
    private NewAutoPayStep newAutoPayStep = new NewAutoPayStep();
    private NewAutoPayAdditionalStep newAutoPayAdditionalStep = new NewAutoPayAdditionalStep();
    private AutoPayDetailsStep autoPayDetailsStep = new AutoPayDetailsStep();
    private AddAutoPayResultStep addAutoPayResultStep = new AddAutoPayResultStep();

    @BeforeMethod
    public void openAppAndTransferToAutoPayments() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnPaymentsButton();
        paymentsStep.onPaymentsScreen();
        paymentsStep.tapOnAutoPayments();
    }

    @TestRails(id = "C6425040")
    @Test(description = "Displaying information on auto payments screen")
    public void c6425040() {
        autoPaymentsStep.onAutoPaymentsScreen();
        autoPaymentsStep.verifyAutoPaymentsTitleText(AUTO_PAYMENTS_TITLE);
        autoPaymentsStep.verifyBackButtonIsEnabled();
        autoPaymentsStep.verifyAddAutoPayButtonEnabled();
    }

    @TestRails(id = "C6425041")
    @Test(description = "Come back from Auto payments screen")
    public void c6425041() {
        autoPaymentsStep.onAutoPaymentsScreen();
        autoPaymentsStep.tapOnBackButton();
        paymentsStep.onPaymentsScreen();
        paymentsStep.verifyPaymentsTitleText(PAYMENTS_TITLE);
    }

    @TestRails(id = "C6430675")
    @Test(description = "Add auto pay 'Transfer from card to card', valid data")
    public void c6430675() {
        autoPaymentsStep.onAutoPaymentsScreen();
        autoPaymentsStep.tapOnAddAutoPayButton();

        additionAutoPaymentStep.onAdditionAutoPaymentScreen();
        additionAutoPaymentStep.tapOnTransferFromCardToCardButton();

        newAutoPayStep.onNewAutoPayScreen();
        newAutoPayStep.enterAutoPayNameToField(ACCOUNT_CREATED);
        newAutoPayStep.tapOnFromCardField();
        newAutoPayStep.tapOnFromCardClickableArea();
        newAutoPayStep.enterAmountToField(AMOUNT_100_WITH_ONE_NULL);
        newAutoPayStep.enterToCardToField(VALID_CARD_NUMBER);
        DriverManager.closeDeviceKeyboard();
        newAutoPayStep.tapOnNextButton();

        newAutoPayAdditionalStep.onNewAutoPayAdditionalScreen();
        newAutoPayAdditionalStep.verifyNewAutoPayAdditionalTitleText(NEW_AUTOPAY_TITLE);
        newAutoPayAdditionalStep.verifyBackButtonIsEnabled();
        newAutoPayAdditionalStep.verifyConfirmButtonIsNotEnabled();
        newAutoPayAdditionalStep.verifyNextPaymentDateTitleIsDisplayed();
        newAutoPayAdditionalStep.verifyFrequencyTitleIsDisplayed();
        newAutoPayAdditionalStep.tapOnSelectDateField();
        newAutoPayAdditionalStep.selectNextMonth();
        newAutoPayAdditionalStep.tapOnSelectFrequencyField();
        String frequency = newAutoPayAdditionalStep.getFrequencyText();
        newAutoPayAdditionalStep.tapOnMonthlyButton();
        newAutoPayAdditionalStep.verifyConfirmButtonIsEnabled();
        String nextPaymentDate = newAutoPayAdditionalStep.getNextPaymentDateText();
        newAutoPayAdditionalStep.tapOnConfirmButton();

        autoPayDetailsStep.onAutoPayDetailsScreen();
        autoPayDetailsStep.verifyAutoPayDetailsTitleText(AUTOPAY_DETAILS_TITLE);
        autoPayDetailsStep.verifyBackButtonIsEnabled();
        autoPayDetailsStep.verifyAutoPayNameTextIsCorrect(ACCOUNT_CREATED);
        autoPayDetailsStep.verifyFromCardTitleIsDisplayed();
        autoPayDetailsStep.verifyAmountTitleIsDisplayed();
        autoPayDetailsStep.verifyAmountIsCorrect(AMOUNT_100_WITH_ONE_NULL);
        autoPayDetailsStep.verifyToCardTitleIsDisplayed();
        autoPayDetailsStep.verifyToCardIsCorrect(VALID_CARD_NUMBER);
        autoPayDetailsStep.verifyBankNameTitleIsDisplayed();
        autoPayDetailsStep.verifyNextPaymentDateIsDisplayed();
        autoPayDetailsStep.verifyNextPaymentDateIsCorrect(nextPaymentDate);
        autoPayDetailsStep.verifyFrequencyIsDisplayed();
        autoPayDetailsStep.verifyFrequencyIsCorrect(frequency);
        autoPayDetailsStep.tapOnAddAutoPayButton();

        addAutoPayResultStep.onAutoPayResultScreen();
        addAutoPayResultStep.verifyBackToMainMenuButtonIsEnabled();
        addAutoPayResultStep.verifyResultFieldText("Autopay added successfully");
        addAutoPayResultStep.tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
    }
}
