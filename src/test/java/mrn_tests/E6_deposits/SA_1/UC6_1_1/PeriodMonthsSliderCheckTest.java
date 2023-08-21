package mrn_tests.E6_deposits.SA_1.UC6_1_1;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

public class PeriodMonthsSliderCheckTest extends BaseDepositTest {

    private static final String MIN_PERIOD_MONTHS_VALUE = "3";
    private static final String MAX_PERIOD_MONTHS_VALUE = "36";
    private static final String INVALID_PERIOD_MONTHS_VALUE = "11111";

    @BeforeMethod
    public void toDepositScreen() {
        goToDepositsScreen();
        goToSelectionScreenAndCheckDepositChoosingOptions();
    }

    @TestRails(id = "C6465496")
    @Test(description = "Checking Period months slider start position", groups = {"Functional"})
    public void c6465496() {
        selectionStep.verifyPeriodMonthsValueEquals(MIN_PERIOD_MONTHS_VALUE);
    }

    @TestRails(id = "C6460452")
    @Test(description = "Move Period months slider left and right", groups = {"Functional"})
    public void c6460452() {
        selectionStep.swipePeriodMonthsSliderToRight();
        selectionStep.verifyPeriodMonthsValueNotEquals(MIN_PERIOD_MONTHS_VALUE);
        selectionStep.swipePeriodMonthsSliderToLeft();
        selectionStep.getPeriodMonthsValue();
        selectionStep.verifyPeriodMonthsValueEquals(selectionStep.getPeriodMonthsValue());
    }

    @TestRails(id = "C6465497")
    @Test(description = "Move Period months slider to max value", groups = {"Functional"})
    public void c6465497() {
        selectionStep.swipePeriodMonthsSliderToMaxRight();
        selectionStep.verifyPeriodMonthsValueEquals(MAX_PERIOD_MONTHS_VALUE);
    }

    @TestRails(id = "C6516545")
    @Test(description = "Enter min value in 'Period months' field", groups = {"Functional"})
    public void c6516545() {
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthSlideBar(MIN_PERIOD_MONTHS_VALUE);
        selectionStep.verifyPeriodMonthsValueEquals(MIN_PERIOD_MONTHS_VALUE);
    }

    @TestRails(id = "C6516546")
    @Test(description = "Enter max value in 'Period months' field", groups = {"Functional"})
    public void c6516546() {
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthSlideBar(MAX_PERIOD_MONTHS_VALUE);
        selectionStep.verifyPeriodMonthsValueEquals(MAX_PERIOD_MONTHS_VALUE);
    }

    @TestRails(id = "C6467480")
    @Test(description = "Enter invalid value in 'Period months' field", groups = {"Functional"})
    public void C6467480() {
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthSlideBar(INVALID_PERIOD_MONTHS_VALUE);
        selectionStep.checkTextInputError();
    }
}
