package mrn_tests.E6_deposits.SA_1.UC6_1_1;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

public class DepositDescriptionsScreenTest extends BaseDepositTest {

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
        selectionResultsStep.verifyDepositProductCardsIsDisplayed();
        selectionResultsStep.tapOnDepositProductCards();
        depositDescriptionsStep.onDepositDescriptionsScreen();
        depositDescriptionsStep.verifyDepositDescriptionsScreenIsOpen();
    }

    @TestRails(id = "C6462757")
    @Test(description = "Checking displaying elements on Deposit Descriptions screen", groups = {"Functional"})
    public void c6462757() {
        depositDescriptionsStep.verifyDepositNameIsDisplayed();
        depositDescriptionsStep.verifyBackButtonIsDisplayed();
        depositDescriptionsStep.verifyCrossButtonIsDisplayed();
        depositDescriptionsStep.verifyNextButtonIsDisplayed();
        depositDescriptionsStep.verifyDepositDescriptionTitleIsDisplayed();
        depositDescriptionsStep.verifyDepositDescriptionIsDisplayed();
        depositDescriptionsStep.verifyDepositConditionsIsDisplayed();
        depositDescriptionsStep.verifyBackToSelectionButtonIsDisplayed();
    }

    @TestRails(id = "C6462758")
    @Test(description = "Return to previous page from Deposit Descriptions screen", groups = {"Functional"})
    public void c6462758() {
        depositDescriptionsStep.verifyBackButtonIsDisplayed();
        depositDescriptionsStep.tapOnBackButton();
        selectionResultsStep.onSelectionResultsScreen();
        selectionResultsStep.verifySelectionResultsScreenOpen();
    }

    @TestRails(id = "C6462909")
    @Test(description = "Opening Select account screen when clicking on Next button", groups = {"Functional"})
    public void c6462909() {
        depositDescriptionsStep.verifyNextButtonIsDisplayed();
        depositDescriptionsStep.tapOnNextButton();
        selectAccountStep.onSelectAccountScreen();
        selectAccountStep.verifySelectAccountScreenIsOpen();
    }

    @TestRails(id = "C6463071")
    @Test(description = "Return to previous page when clicking on Back to Selection button", groups = {"Functional"})
    public void c6463071() {
        depositDescriptionsStep.verifyBackToSelectionButtonIsDisplayed();
        depositDescriptionsStep.tapOnBackToSelectionButton();
        selectionResultsStep.onSelectionResultsScreen();
        selectionResultsStep.verifySelectionResultsScreenOpen();
    }
}
