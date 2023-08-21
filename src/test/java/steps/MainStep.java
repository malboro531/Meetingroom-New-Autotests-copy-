package steps;

import api.pages.MainScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class MainStep {

    protected MainScreen mainScreen;

    @Step("On 'Main' screen")
    public void onMainScreen() {
        mainScreen = new MainScreen();
    }

    @Step("Verify 'Main' screen is open")
    public void verifyMainScreenIsOpen() {
        mainScreen.verifyPageIsOpened();
    }
    public boolean isMainScreenIsOpen() {
        return mainScreen.isMainScreenDisplayed();
    }

    @Step("Tap on main button")
    public void tapOnMainButton() {
        mainScreen.tapOnMainButton();
    }

    @Step("Tap on settings button")
    public void tapOnSettingsButton() {
        mainScreen.tapOnSettingsButton();
    }

    @Step("Tap on notifications button")
    public void tapOnNotificationsButton() {
        mainScreen.tapOnNotificationsButton();
    }

    @Step("Tap on order card button")
    public void tapOnOrderCardButton() {
        mainScreen.tapOnOrderCardButton();
    }

    @Step("Tap on transfers button")
    public void tapOnTransfersButton() {
        mainScreen.tapOnTransfersButton();
    }

    @Step("Tap on products button")
    public void tapOnProductsButton() {
        mainScreen.tapOnProductsButton();
    }

    @Step("Tap on image view main button")
    public void tapOnImageViewMainButton() {
        mainScreen.tapOnImageViewMainButton();
    }

    @Step("Tap on 'More' button")
    public void tapOnMoreButton() {
        mainScreen.tapOnMoreButton();
    }

    @Step("Tap on payments button")
    public void tapOnPaymentsButton() {
        mainScreen.tapOnPaymentsButton();
    }

    @Step("Verify that payments button is enabled")
    public void verifyPaymentsButtonIsEnabled() {
        Verify.verifyTrue(mainScreen.isPaymentsButtonEnabled(), "Payments button is enabled");
    }
}
