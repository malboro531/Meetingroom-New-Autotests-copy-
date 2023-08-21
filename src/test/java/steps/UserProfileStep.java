package steps;

import api.pages.UserProfileScreen;
import io.qameta.allure.Step;

public class UserProfileStep {

    protected UserProfileScreen userProfileScreen;

    @Step("On 'User Profile' screen")
    public void onUserProfileScreen() {
        userProfileScreen = new UserProfileScreen();
    }

    @Step("Verify 'User Profile' screen is open")
    public void verifyUserProfileScreenIsOpened() {
        userProfileScreen.verifyPageIsOpened();
    }

    @Step("Log out")
    public void logOutFromApp() {
        userProfileScreen.tapExitIcon();
    }

    @Step("Tap User Profile safety button ")
    public void tapUserSafety() {
        userProfileScreen.tapUserSafety();
    }

    @Step("Tap User Profile Image button ")
    public void tapUserProfileImageButton() {
        userProfileScreen.tapUserProfileImageButton();
    }

    @Step("Tap Notifications button")
    public void tapNotificationsButton() {
        userProfileScreen.tapNotificationsButton();
    }
}
