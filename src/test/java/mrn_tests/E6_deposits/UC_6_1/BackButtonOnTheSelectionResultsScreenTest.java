package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;
import static constants.SettingData.DEPOSIT_AMOUNT;
import static constants.SettingData.PERIOD;

@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class BackButtonOnTheSelectionResultsScreenTest extends BaseDepositTest {

    @TestRails(id = "c6019432")
    @Test(description = "Tap on 'Back' button. 'Selection' page is opened." +
            "Earlier chosen parameters are saved", groups = {"GUI"})
    public void c6019432() {
        goToDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.cleanDepositAmountBar();
        selectionStep.enterValueDepositAmountSlideBar(DEPOSIT_AMOUNT);
        selectionStep.cleanPeriodMonthsBar();
        selectionStep.enterValueInPeriodMonthsSlideBar(PERIOD);
        selectionStep.tapOnChooseButton();
        selectionResultsStep.onSelectionResultsScreen();
        selectionResultsStep.tapOnBackButton();
        selectionStep.verifyEarlierChosenParametersSaved(DEPOSIT_AMOUNT, PERIOD);
    }
}
