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
public class DisplayingTheDepositsScreenTest extends BaseDepositTest {

    @TestRails(id = "c6032419")
    @Test(description = "Open the page 'Deposits'", groups = {"Functional"})
    public void c6032419() {
        goToDepositsScreen();
        depositsStep.verifyDepositsListIsDisplayed();
    }

    @TestRails(id = "c5982540")
    @Test(description = "Functioning the icon 'Filter'", groups = {"Functional"})
    public void c5982540() {
        goToDepositsScreen();
        depositsStep.tapOnFilterButton();
        filterStep.onFilterScreen();
    }
}
