package steps;

import api.pages.WelcomeScreen;
import io.qameta.allure.Step;

public class WelcomeStep {

    protected WelcomeScreen welcomeScreen;

    @Step("On WelcomeScreen")
    public void onWelcomeScreen() {
        welcomeScreen = new WelcomeScreen();
    }

    @Step("Tap on Login button")
    public void tapOnLoginButton() {
        welcomeScreen.tapOnLoginButton();
    }

    @Step("Verify WelcomeStep is Open")
    public void verifyWelcomeScreenIsOpen() {
        welcomeScreen.verifyPageIsOpened();
    }

    public boolean isWelcomeScreenIsOpen() {
        return welcomeScreen.isWelcomeScreenDisplayed();
    }

    @Step("Tap on demo button")
    public void tapOnDemoButton() {
        welcomeScreen.tapOnDemoButton();
    }
}
