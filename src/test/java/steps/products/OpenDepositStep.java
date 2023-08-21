package steps.products;

import api.pages.products.OpenDepositScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class OpenDepositStep {

    protected OpenDepositScreen openDepositScreen;

    @Step("On OpenDepositScreen")
    public void onOpenDepositScreen() {
        openDepositScreen = new OpenDepositScreen();
    }

    @Step("Verify Deposit Screen is open")
    public void verifyOpenDepositScreenIsOpen() {
        openDepositScreen.verifyPageIsOpened();
    }

    @Step("Tap on GotItButton")
    public void tapOnGotItButton() {
        if (openDepositScreen.isGotItButtonDisplayed())
            openDepositScreen.tapOnGotItButton();
        else Verify.verifyFalse(openDepositScreen.isGotItButtonDisplayed(), "'Got it' button is not displayed");
    }
}
