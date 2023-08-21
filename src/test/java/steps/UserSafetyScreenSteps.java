package steps;

import api.pages.UserSafetyScreen;
import io.qameta.allure.Step;

public class UserSafetyScreenSteps {

    protected UserSafetyScreen userSafetyScreen;

    @Step("On 'User Safety' screen")
    public void onUserSafetyScreen() {
        userSafetyScreen = new UserSafetyScreen();
    }

    @Step("Verify 'User Safety' screen is open")
    public void verifyUserSafetyScreenIsOpened() {
        userSafetyScreen.verifyPageIsOpened();
    }

    @Step("Tap on Set Application Password Button ")
    public void tapSetApplicationPasswordButton() {
        userSafetyScreen.tapSetApplicationPasswordButton();
    }
}
