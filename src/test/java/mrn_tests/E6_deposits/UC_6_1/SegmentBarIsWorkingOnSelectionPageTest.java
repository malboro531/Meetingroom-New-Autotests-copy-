package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;

@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class SegmentBarIsWorkingOnSelectionPageTest extends BaseDepositTest {

    @TestRails(id = "c6019049")
    @Test(description = "Segment bar is working", groups = {"GUI"})
    public void c6019049() {
        goToDepositsScreen();
        depositsStep.onDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.tapOnSavingAccountButton();
        selectionStep.verifySavingAccountSegmentIsOpen();
        selectionStep.tapOnDepositsButton();
        selectionStep.verifyDepositsSegmentIsOpen();
    }
}
