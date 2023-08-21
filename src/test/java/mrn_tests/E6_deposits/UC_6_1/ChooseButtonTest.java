package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;
import static helpers.FakeGenerator.getDepositAmount;
import static helpers.FakeGenerator.getPeriod;

@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class ChooseButtonTest extends BaseDepositTest {

    @TestRails(id = "c6019076")
    @Test(description = "The page with selection result opened", groups = {"Functional"})
    public void c6019076() {
        goToDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(getDepositAmount());
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthsSlideBar(getPeriod());
        selectionStep.tapOnChooseButton();
        selectionResultsStep.onSelectionResultsScreen();
    }
}
