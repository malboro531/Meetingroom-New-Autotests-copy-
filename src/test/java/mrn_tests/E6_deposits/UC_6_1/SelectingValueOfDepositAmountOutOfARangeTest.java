package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;
import static constants.SettingData.DEPOSIT_AMOUNT;

@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class SelectingValueOfDepositAmountOutOfARangeTest extends BaseDepositTest {

    @TestRails(id = "c6019057")
    @Test(description = "The slider bar is moving. Value in the line 'Deposit amount' changes correctly.",
            groups = {"GUI"})
    public void c6019057() {
        goToDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(DEPOSIT_AMOUNT);
        selectionStep.verifyDepositAmountValueChangesCorrectly(DEPOSIT_AMOUNT);
    }
}
