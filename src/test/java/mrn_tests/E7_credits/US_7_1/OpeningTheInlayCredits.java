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
public class OpeningTheInlayCredits extends BaseCreditTest {

    @TestRails(id = "с6024179")
    @Test(description = "Opening the Inlay Credits.", groups = {"Functional"})
    public void c6024179() {
        goToCreditsScreen();
        openCreditsStep.onOpenCreditScreen();
        productsStep.verifyCreditsInlayIsOpen();
    }
}
