package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;

@Epic(EPIC_8_USER_PROFILE)
public class UserProfilePinCodeTest extends BaseTest {

    @TestRails(id = "C6096306")
    @Test (description = "Valid Pin Code enter to the app", groups = {"Functional"})
    public void C6096306() {
        loginUser();
        setApplicationPasswordScreenSteps.setApplicationPinCode();

        terminateApp();
        activateAppWithoutAlert();

        enterApplicationPasswordScreenStep.onEnterApplicationPasswordScreen();
        enterApplicationPasswordScreenStep.typeApplicationPassword();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();

        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.tapUserSafety();
        userSafetyScreenSteps.onUserSafetyScreen();
        userSafetyScreenSteps.tapSetApplicationPasswordButton();
        setApplicationPasswordScreenSteps.onSetApplicationPasswordScreen();
        setApplicationPasswordScreenSteps.tapUsePasswordSwitchRadioButton();
    }
}
