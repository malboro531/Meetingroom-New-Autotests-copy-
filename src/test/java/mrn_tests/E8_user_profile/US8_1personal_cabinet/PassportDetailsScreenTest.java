package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class PassportDetailsScreenTest extends BaseTest {

    @TestRails(id = "C6066971")
    @Test(description = "Check passport details is displayed", groups = {"Functional"})
    public void C6066971() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();

        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();

        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapPassportDetailsButton();

        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();

        passportDetailsScreenStep.tapBackArrowButton();
        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }
    @TestRails(id = "C6066977")
    @Test(description = "Check  Back arrow button on passport details screen", groups = {"Functional"})
    public void C6066977() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();

        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();

        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapPassportDetailsButton();

        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.tapBackArrowButton();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }
}