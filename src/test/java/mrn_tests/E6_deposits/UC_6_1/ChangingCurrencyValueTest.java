package mrn_tests.E6_deposits.UC_6_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseDepositTest;

import static constants.AllureData.EPIC_6_DEPOSITS;
import static constants.AllureData.FEATURE_UC_6_1;
import static constants.SettingData.*;


@Epic(EPIC_6_DEPOSITS)
@Feature(FEATURE_UC_6_1)
public class ChangingCurrencyValueTest extends BaseDepositTest {

    @TestRails(id = "c6037159")
    @Test(description = "Tap on any currency. Chosen currency displays in the window.", groups = {"GUI"})
    public void c6037159() {
        goToDepositsScreen();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.tapOnCurrencyDropdown();
        selectionStep.chooseUsdCurrency();
        selectionStep.verifyCurrencyValueChangesCorrectly(USD_CURRENCY);
        selectionStep.tapOnCurrencyDropdown();
        selectionStep.chooseEurCurrency();
        selectionStep.verifyCurrencyValueChangesCorrectly(EUR_CURRENCY);
    }
}
