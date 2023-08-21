package mrn_tests.E6_deposits.SA_1.UC6_1_1;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

public class DepositAmountSliderCheckTest extends BaseDepositTest {

    private static final String MIN_DEPOSIT_AMOUNT_SUM = "500";
    private static final String MAX_DEPOSIT_AMOUNT_SUM = "10,000,000";
    private static final String INVALID_DEPOSIT_AMOUNT_VALUE = "111,111,111,111,111";

    @BeforeMethod
    public void toDepositScreen() {
        goToDepositsScreen();
        goToSelectionScreenAndCheckDepositChoosingOptions();
    }

    @TestRails(id = "C6460442")
    @Test(description = "Move Deposit amount slider left and right", groups = {"Functional"})
    public void c6460442() {
        selectionStep.swipeDepositAmountSliderToRight();
        selectionStep.verifyDepositAmountValueNotEquals(MIN_DEPOSIT_AMOUNT_SUM);
        selectionStep.swipeDepositAmountSliderToLeft();
        selectionStep.getDepositAmountValue();
        selectionStep.verifyDepositAmountValueEquals(selectionStep.getDepositAmountValue());
    }

    @TestRails(id = "C6460805")
    @Test(description = "Move Deposit amount slider to max sum", groups = {"Functional"})
    public void c6460805() {
        selectionStep.swipeDepositAmountSliderToMaxRight();
        selectionStep.verifyDepositAmountValueEquals(MAX_DEPOSIT_AMOUNT_SUM);
    }

    @TestRails(id = "C6460804")
    @Test(description = "Checking Deposit amount slider start position", groups = {"Functional"})
    public void c6460804() {
        selectionStep.verifyDepositAmountValueEquals(MIN_DEPOSIT_AMOUNT_SUM);
    }

    @TestRails(id = "C6465485")
    @Test(description = "Enter min value in 'Deposit amount' field", groups = {"Functional"})
    public void c6465485() {
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(MIN_DEPOSIT_AMOUNT_SUM);
        selectionStep.verifyDepositAmountValueEquals(MIN_DEPOSIT_AMOUNT_SUM);
    }

    @TestRails(id = "C6465486")
    @Test(description = "Enter max value in 'Deposit amount' field", groups = {"Functional"})
    public void C6465486() {
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(MAX_DEPOSIT_AMOUNT_SUM);
        selectionStep.verifyDepositAmountValueEquals(MAX_DEPOSIT_AMOUNT_SUM);
    }

    @TestRails(id = "C6467484")
    @Test(description = "Enter invalid value in 'Deposit amount' field", groups = {"Functional"})
    public void C6467484() {
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(INVALID_DEPOSIT_AMOUNT_VALUE);
        selectionStep.checkTextInputError();
    }
}
