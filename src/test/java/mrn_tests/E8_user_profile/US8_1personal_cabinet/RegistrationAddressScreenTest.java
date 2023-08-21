package mrn_tests.E8_user_profile.US8_1personal_cabinet;

import api.services.TestRails;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_8_USER_PROFILE;
import static verification.VerifySoft.showAllChecking;

@Epic(EPIC_8_USER_PROFILE)
public class RegistrationAddressScreenTest extends BaseTest {

    @TestRails(id = "C6066998")
    @Test(description = "Check move from registration address screen to Personal cabinet screen", groups = {"Functional"})
    public void C6066998() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();

        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();

        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapRegistrationAddressButton();

        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.tapBackArrowButton();

        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();

        personalCabinetStep.tapBackArrowButton();
        userProfileStep.logOutFromApp();
    }

    @TestRails(id = "C6066972")
    @Test(description = "Opening the registration address and check fields", groups = {"Functional"})
    public void C6066972() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnImageViewMainButton();
        userProfileStep.onUserProfileScreen();
        userProfileStep.verifyUserProfileScreenIsOpened();
        userProfileStep.tapUserProfileImageButton();
        personalCabinetStep.onUserPersonalCabinetScreen();
        personalCabinetStep.verifyPersonalCabinetScreenIsOpened();
        personalCabinetStep.tapRegistrationAddressButton();

        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.verifyCountryFieldIsDisplayed();
        registrationAddressStep.verifyCityFieldIsDisplayed();
        registrationAddressStep.verifyStreetFieldIsDisplayed();
        registrationAddressStep.verifyHouseFieldIsDisplayed();
        registrationAddressStep.verifyBuildingFieldIsDisplayed();
        registrationAddressStep.verifyFlatFieldIsDisplayed();
        showAllChecking();
    }
}