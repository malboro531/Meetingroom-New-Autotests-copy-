package steps.products;

import api.pages.products.OpenCardScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class OpenCardStep {

    protected OpenCardScreen openCardScreen;

    @Step("On OpenCardScreen")
    public void onOpenCardScreen() {
        openCardScreen = new OpenCardScreen();
    }

    @Step("Verify Cards Screen is open")
    public void verifyOpenCardScreenIsOpen() {
        openCardScreen.verifyPageIsOpened();
    }

    @Step("Tap on GotItButton")
    public void tapOnGotItButton() {
        if (openCardScreen.isGotItButtonDisplayed())
            openCardScreen.tapOnGotItButton();
        else Verify.verifyFalse(openCardScreen.isGotItButtonDisplayed(), "'Got it' button is not displayed");
    }
}
