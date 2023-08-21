package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.GlobalData.NEW_EMAIL;
import static constants.GlobalData.OLD_EMAIL;

public class ChangeEmailWithConfirmationCodeTest extends BaseTest {

    @TestRails(id = "c6055351")
    @Test(description = "Change Email with confirmation code", groups = {"Functional"})
    public void c6055351() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.tapNotificationsButton();
        userNotificationsStep.onUserNotificationsScreen();
        userNotificationsStep.tapChangeEmailButton();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        setNewEmailStep.onSetNewEmailScreen();
        setNewEmailStep.enterNewEmail(NEW_EMAIL);
        setNewEmailStep.tapPrimaryButton();
        confirmChangedEmailStep.onEmailSuccessChangedScreen();
        confirmChangedEmailStep.verifyEmailSuccessChangedScreenOpen();
        confirmChangedEmailStep.tapOnConfirmButton();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.logOutFromApp();

        loginUser();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.isChangedEmailMatch();
        personalCabinetStep.tapBackArrowButton();
        userProfileStep.tapNotificationsButton();
        userNotificationsStep.tapChangeEmailButton();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();
        setNewEmailStep.enterOldEmail(OLD_EMAIL);
        setNewEmailStep.tapPrimaryButton();
        confirmChangedEmailStep.tapOnConfirmButton();
    }
}
