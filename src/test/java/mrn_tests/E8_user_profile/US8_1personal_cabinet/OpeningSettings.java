package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;

@Epic(EPIC_8_USER_PROFILE)
public class OpeningSettings extends BaseTest {

    @TestRails(id = "с6032498")
    @Test(description = "Opening settings", groups = {"Functional"})
    public void c6032498() {
        loginUser();
        promoStep.tapOnSettingsButton();
        homeSettingsStep.onHomeSettingsScreen();
        homeSettingsStep.verifyIsHomeSettingsIsOpen();
    }
}