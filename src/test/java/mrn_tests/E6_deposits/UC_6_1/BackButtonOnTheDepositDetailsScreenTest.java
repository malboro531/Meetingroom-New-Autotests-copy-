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
public class BackButtonOnTheDepositDetailsScreenTest extends BaseDepositTest {

    @TestRails(id = "c5983640")
    @Test(description = "Checking the functioning of arrow Back", groups = {"Functional"})
    public void c5983640() {
        goToDepositsScreen();
        depositsStep.openTheFirstDeposit();
        depositDetailsStep.onDepositDetailsScreen();
        depositDetailsStep.tapOnBackButton();
        productsStep.verifyDepositsInlayIsOpen();
    }
}
