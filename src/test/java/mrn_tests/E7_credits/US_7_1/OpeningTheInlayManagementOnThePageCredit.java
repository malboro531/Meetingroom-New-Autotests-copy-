package mrn_tests.E7_credits.US_7_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseCreditTest;

import static constants.AllureData.EPIC_7_CREDITS;
import static constants.AllureData.FEATURE_UC_7_1;

@Epic(EPIC_7_CREDITS)
@Feature(FEATURE_UC_7_1)
public class OpeningTheInlayManagementOnThePageCredit extends BaseCreditTest {

    @TestRails(id = "с6024196")
    @Test(description = "Opening the inlay management on the page credit", groups = {"GUI"})
    public void c6024196() {
        goToCreditsScreen();
        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnMortgageButton();
        openCreditsStep.tapOnManagementButton();
        openCreditsStep.verifyManagementScreenIsOpen();
    }
}
