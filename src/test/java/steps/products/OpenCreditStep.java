package steps.products;

import api.pages.products.OpenCreditScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class OpenCreditStep {

    protected OpenCreditScreen openCreditScreen;

    @Step("On OpenCreditScreen")
    public void onOpenCreditScreen() {
        openCreditScreen = new OpenCreditScreen();
    }

    @Step("Tap on GotItButton")
    public void tapOnGotItButton() {
        if (openCreditScreen.isGotItButtonDisplayed())
            openCreditScreen.tapOnGotItButton();
        else Verify.verifyFalse(openCreditScreen.isGotItButtonDisplayed(), "'Got it' button is not displayed");
    }

    @Step("Verify 'CreditsScreen' is open")
    public void verifyCreditScreenIsOpen() {
        openCreditScreen.verifyPageIsOpened();
    }

    @Step("Tap on 'Online Credit' button")
    public void tapOnMortgageButton() {
        openCreditScreen.tapOnMortgageButton();
    }

    @Step("Tap on management button")
    public void tapOnManagementButton() {
        openCreditScreen.onManagementButton();
    }

    @Step("Verify 'Management Screen' is open")
    public void verifyManagementScreenIsOpen() {
        openCreditScreen.verifyPageIsOpened();
    }

    @Step("Tap on information button")
    public void tapOnInformationButton() {
        openCreditScreen.onInformationButton();
    }

    @Step("Tap on choose CreditButton")
    public void tapOnChooseCreditButton() {
        openCreditScreen.onOpenChooseCreditButton();
    }
}
