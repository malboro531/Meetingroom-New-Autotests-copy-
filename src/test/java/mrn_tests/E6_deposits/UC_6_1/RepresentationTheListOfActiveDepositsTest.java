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
public class RepresentationTheListOfActiveDepositsTest extends BaseDepositTest {

    @TestRails(id = "c5979453")
    @Test(description = "Tap on inlay Deposits. The list of deposits is displayed", groups = {"GUI"})
    public void c5979453() {
        goToDepositsScreen();
        depositsStep.onDepositsScreen();
        depositsStep.verifyDepositsListIsDisplayed();
    }
}
