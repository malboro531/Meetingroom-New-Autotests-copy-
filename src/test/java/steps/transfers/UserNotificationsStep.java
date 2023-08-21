package steps.transfers;

import api.pages.transfers.UserNotificationsScreen;
import io.qameta.allure.Step;

public class UserNotificationsStep {

    protected UserNotificationsScreen userNotificationsScreen;

    @Step("On 'User notification screen'")
    public void onUserNotificationsScreen() {
        userNotificationsScreen = new UserNotificationsScreen();
    }

    @Step("Tap 'change email button'")
    public void tapChangeEmailButton() {
        userNotificationsScreen.tapChangeEmailButton();
    }

    @Step("Verify 'Notifications' screen is open")
    public void verifyNotificationsPageIsOpen() {
        userNotificationsScreen.verifyPageIsOpened();
    }

    @Step("Tap on 'Arrow' button")
    public void tapOnArrowButton() {
        userNotificationsScreen.tapOnArrowButton();
    }
}
