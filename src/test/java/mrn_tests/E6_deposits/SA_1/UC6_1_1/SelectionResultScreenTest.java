package mrn_tests.E6_deposits.SA_1.UC6_1_1;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

public class SelectionResultScreenTest extends BaseDepositTest {

    @BeforeMethod
    public void toDepositScreen() {
        goToDepositsScreen();
        depositsStep.verifyPlusButtonIsDisplayed();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.verifyChooseButtonIsDisplayed();
        selectionStep.tapOnChooseButton();
        selectionResultsStep.onSelectionResultsScreen();
        selectionResultsStep.verifySelectionResultsScreenOpen();
    }

    @TestRails(id = "C6467392")
    @Test(description = "Checking displaying elements on Selection results screen", groups = {"Functional"})
    public void c6467392() {
        selectionResultsStep.verifyCrossButtonIsDisplayed();
        selectionResultsStep.verifyBackButtonIsDisplayed();
        selectionResultsStep.verifySelectionResultsHeaderIsDisplayed();
        selectionResultsStep.verifyDepositProductCardsIsDisplayed();
    }

    @TestRails(id = "C6467407")
    @Test(description = "Return to previous page from Selection results screen", groups = {"Functional"})
    public void c6467407() {
        selectionResultsStep.verifyBackButtonIsDisplayed();
        selectionResultsStep.tapOnBackButton();
        selectionStep.onSelectionScreen();
        selectionStep.verifySelectionScreenIsOpen();
    }

    @TestRails(id = "C6467410")
    @Test(description = "Canceling operation when clicking on Cross Button on Selection results screen", groups = {"Functional"})
    public void C6467410() {
        selectionResultsStep.verifyCrossButtonIsDisplayed();
        selectionResultsStep.tapOnCrossButton();
        selectionResultsStep.verifyAlertFrameIsDisplayed();
        selectionResultsStep.verifyAlertFrameOkButtonIsDisplayed();
        selectionResultsStep.verifyAlertFrameBackButtonIsDisplayed();
    }

    @TestRails(id = "C6467421")
    @Test(description = "Opening Deposit Product Screen when clicking on deposit product card", groups = {"Functional"})
    public void c6467421() {
        selectionResultsStep.verifyDepositProductCardsIsDisplayed();
        selectionResultsStep.tapOnDepositProductCards();
        depositDescriptionsStep.onDepositDescriptionsScreen();
        depositDescriptionsStep.verifyDepositDescriptionsScreenIsOpen();
    }
}
