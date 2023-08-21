package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class PersonalCabinetTest extends BaseTest {

    @TestRails(id = "C6064071")
    @Test(description = "Go from User Profile to Personal cabinet", groups = {"Functional"})
    public void C6064071() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();

    }

    @TestRails(id = "C6067002")
    @Test(description = "Tap Delete account, Chancel, Ok Buttons are displayed", groups = {"Functional"})
    public void C6067002() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapDeleteAccountButton();

        twoButtonsConfirmationScreenStep.onConfirmationScreen();
        twoButtonsConfirmationScreenStep.verifyConfirmationScreenIsOpened();
        twoButtonsConfirmationScreenStep.verifyApplyButtonDisplayed();
        twoButtonsConfirmationScreenStep.verifyRejectButtonDisplayed();
        twoButtonsConfirmationScreenStep.tapRejectButton();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }

    @TestRails(id = "C6067240")
    @Test(description = "Tap Delete account, then tap Chancel Button Personal cabinet is displayed", groups = {"Functional"})
    public void C6067240() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapDeleteAccountButton();

        twoButtonsConfirmationScreenStep.onConfirmationScreen();
        twoButtonsConfirmationScreenStep.tapRejectButton();

        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }
}
