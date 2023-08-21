package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class NumberOfNotValidEnterPinCodeTest extends BaseTest {

    @TestRails(id = "C6096308")
    @Test(description = "Check number of not valid enter pin code.", groups = {"Functional"})
    public void C6096308() {
        loginUser();
        setApplicationPasswordScreenSteps.setApplicationPinCode();
        terminateApp();
        beforeMethod();
        enterApplicationPasswordScreenStep.onEnterApplicationPasswordScreen();
        enterApplicationPasswordScreenStep.typeNotValidApplicationPasswordFiveTimes();
        enterApplicationPasswordScreenStep.verifyAlertTheWrongPinCodeFiveTimesDisplayed();
        enterApplicationPasswordScreenStep.tapAlertWrongPinCodeOkButton();
        welcomeStep.onWelcomeScreen();
        welcomeStep.verifyWelcomeScreenIsOpen();
    }
}
