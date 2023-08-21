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
public class DisplayingTheDepositDetailsScreenTest extends BaseDepositTest {

    @TestRails(id = "c5983600")
    @Test(description = "The page with details of deposit is opening", groups = {"Functional"})
    public void c5983600() {
        goToDepositsScreen();
        depositsStep.openTheFirstDeposit();
        depositDetailsStep.onDepositDetailsScreen();
    }
}
