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
public class OpeningThePageChooseCredit extends BaseCreditTest {

    @TestRails(id = "с6045121")
    @Test(description = "Opening the page 'Choose Credit'", groups = {"Functional"})
    public void c6045121() {
        goToCreditsScreen();
        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnChooseCreditButton();
        openChooseCreditStep.onTheOpenChooseCreditScreen();
        openChooseCreditStep.verifyChooseCreditScreenIsOpen();
    }
}
