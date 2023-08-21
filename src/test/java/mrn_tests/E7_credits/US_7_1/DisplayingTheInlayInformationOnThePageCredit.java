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
public class DisplayingTheInlayInformationOnThePageCredit extends BaseCreditTest {

    @TestRails(id = "с6024188")
    @Test(description = "Displaying the inlay information on the page Credit", groups = {"GUI"})
    public void c6024188() {
        goToCreditsScreen();
        openCreditsStep.tapOnMortgageButton();
        openInlayInformationStep.onOpenInlayInformationScreen();
        openInlayInformationStep.verifyInformationScreenIsOpen();
    }
}
