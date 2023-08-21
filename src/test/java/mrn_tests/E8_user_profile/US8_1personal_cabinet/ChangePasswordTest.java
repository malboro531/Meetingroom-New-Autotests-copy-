package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;
import verification.VerifySoft;

import static constants.AllureData.EPIC_8_USER_PROFILE;
import static verification.VerifySoft.showAllChecking;

@Epic(EPIC_8_USER_PROFILE)
public class ChangePasswordTest extends BaseTest {

    @TestRails(id = "C6067243")
    @Test(description = "Opening the Change password page", groups = {"Functional"})
    public void C6067243() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapChangePassword();
        changePasswordStep.onChangePasswordScreen();
        changePasswordStep.verifyChangePasswordScreenIsOpen();
        changePasswordStep.verifyDisplayedEnterOldPassword();
        changePasswordStep.verifyOldPasswordTitleTextField("Enter old password");
        changePasswordStep.verifyDisplayedEnterNewPassword();
        changePasswordStep.verifyNewPasswordTitleTextField("Enter new password");
        changePasswordStep.verifyDisplayedReplayNewPassword();
        changePasswordStep.verifyReplayNewPasswordTitleTextField("Reply new password");
        changePasswordStep.verifyConfirmButtonIsNotEnabled();
        showAllChecking();
    }
}