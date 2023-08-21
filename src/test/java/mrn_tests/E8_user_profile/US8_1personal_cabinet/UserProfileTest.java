package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class UserProfileTest extends BaseTest {

    @TestRails(id = "C6064078")
    @Test(description = "Go from Personal cabinet to User Profile ", groups = {"Functional"})
    public void C6064078() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapBackArrowButton();
        userProfileStep.verifyUserProfileScreenIsOpened();
    }
}
