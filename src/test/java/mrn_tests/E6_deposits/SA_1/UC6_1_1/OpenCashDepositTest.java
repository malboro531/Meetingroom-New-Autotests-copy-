package mrn_tests.E6_deposits.SA_1.UC6_1_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.GlobalData.*;

@Epic(EPIC_6_DEPOSITS)
public class OpenCashDepositTest extends BaseDepositTest {

    @BeforeMethod
    public void toDepositScreen() {
        goToDepositsScreen();
    }

    @TestRails(id = "C6460306")
    @Test(description = "Checking for active deposits, deposits doesn't exist", groups = {"Functional"})
    public void c6460306() {
        verifyNavigationButtonIsDisplayed();
        depositsStep.verifyEmptyDepositPageDisplaysCorrectText(EMPTY_DEPOSITS_PAGE_TEXT);
    }

    @TestRails(id = "C6460316")
    @Test(description = "Checking for active deposits, deposits doesn't exist", groups = {"Functional"})
    public void c6460316() {
        verifyNavigationButtonIsDisplayed();
        depositsStep.verifyDepositsListIsDisplayed();
    }

    @TestRails(id = "C6460409")
    @Test(description = "Open Selection screen with Plus button", groups = {"Functional"})
    public void c6460409() {
        depositsStep.verifyPlusButtonIsDisplayed();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.verifySelectionScreenIsOpen();
    }

    @TestRails(id = "C6460318")
    @Test(description = "Open Selection screen and verify options for choosing deposit", groups = {"Functional"})
    public void c6460318() {
        goToSelectionScreenAndCheckDepositChoosingOptions();
    }

    @TestRails(id = "C6460389")
    @Test(description = "Checking return button on Selection screen", groups = {"Functional"})
    public void c6460389() {
        depositsStep.verifyPlusButtonIsDisplayed();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.verifySelectionScreenIsOpen();
        selectionStep.verifyBackButtonIsDisplayed();
        selectionStep.tapOnBackButton();
        depositsStep.onDepositsScreen();
        depositsStep.verifyDepositsScreenIsOpen();
    }

    @TestRails(id = "C6460781")
    @Test(description = "Checking default selection currency - 'RUB'", groups = {"Functional"})
    public void c6460781() {
        goToSelectionScreenAndCheckDepositChoosingOptions();
        selectionStep.verifyCurrencyValueChangesCorrectly(RUB);
    }

    @TestRails(id = "C6460798")
    @Test(description = "Checking selection currency - 'USD'", groups = {"Functional"})
    public void c6460798() {
        goToSelectionScreenAndCheckDepositChoosingOptions();
        selectionStep.tapOnCurrencyDropdown();
        selectionStep.chooseUsdCurrency();
        selectionStep.verifyCurrencyValueChangesCorrectly(USD);
    }

    @TestRails(id = "C6460799")
    @Test(description = "Checking selection currency - 'EUR'", groups = {"Functional"})
    public void c6460799() {
        goToSelectionScreenAndCheckDepositChoosingOptions();
        selectionStep.tapOnCurrencyDropdown();
        selectionStep.chooseEurCurrency();
        selectionStep.verifyCurrencyValueChangesCorrectly(EUR);
    }
}
