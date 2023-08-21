package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;
import static constants.SettingData.PERIOD;

@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class SelectingValueOfPeriodOutOfARangeTest extends BaseDepositTest {

    @TestRails(id = "c6019066")
    @Test(description = "The slider bar is moving. Value in the line 'Period' changes correctly.",
            groups = {"GUI"})
    public void c6019066() {
        goToDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthsSlideBar(PERIOD);
        selectionStep.verifyPeriodValueChangesCorrectly(PERIOD);
    }
}
