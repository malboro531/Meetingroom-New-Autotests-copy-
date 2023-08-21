package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class ChangeProfilePhotoBackButtonTest extends BaseTest {

    @TestRails(id = "C6067106")
    @Test(description = "Check the alert back button while changing profile photo", groups = {"Functional"})
    public void C6067106() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();

        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();

        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapUserPhoto();

        twoButtonsConfirmationScreenStep.onConfirmationScreen();
        twoButtonsConfirmationScreenStep.verifyConfirmationScreenIsOpened();
        twoButtonsConfirmationScreenStep.verifyRejectButtonDisplayed();
        twoButtonsConfirmationScreenStep.verifyApplyButtonDisplayed();
        twoButtonsConfirmationScreenStep.tapRejectButton();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }
}