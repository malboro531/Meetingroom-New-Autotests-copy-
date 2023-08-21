package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import org.testng.annotations.Test;
import steps.BaseTest;

public class FunctioningBackArrowButtonTest extends BaseTest {

    @TestRails(id = "c6055366")
    @Test(description = "Functioning back arrow button", groups = {"Functional"})
    public void c6055366() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.tapNotificationsButton();
        userNotificationsStep.onUserNotificationsScreen();
        userNotificationsStep.verifyNotificationsPageIsOpen();
        userNotificationsStep.tapOnArrowButton();
        userProfileStep.verifyUserProfileScreenIsOpened();
    }
}