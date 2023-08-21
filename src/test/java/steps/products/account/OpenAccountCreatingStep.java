package steps.products.account;

import api.pages.products.accounts.OpenAccountCreatingScreen;
import constants.enums.Currency;
import io.qameta.allure.Step;
import steps.transfers.CommonStep;
import verification.VerifySoft;

public class OpenAccountCreatingStep extends CommonStep {

    protected OpenAccountCreatingScreen openAccountCreatingScreen;

    @Step("Open account creating screen")
    public void onOpenAccountCreatingScreen() {
        openAccountCreatingScreen = new OpenAccountCreatingScreen();
    }

    @Step("Verify account creating screen is opened")
    public void verifyAccountCreatingScreenIsOpened() {
        openAccountCreatingScreen.verifyPageIsOpened();
    }

    @Step("Set currency for new account")
    public void setCurrency(String currency) {
        openAccountCreatingScreen.setCurrency(currency);
    }

    @Step("Logo is Displayed")
    public void verifyLogoIsDisplayed() {
        VerifySoft.verifyTrueSoft(openAccountCreatingScreen.isBankLogoDisplayed(), "Logo bank is displayed");
    }

    @Step("Button currency is Displayed")
    public void verifyButtonCurrencyIsDisplayed() {
        VerifySoft.verifyTrueSoft(openAccountCreatingScreen.isCurrencyButtonDisplayed(), "Button currency is displayed");
    }

    @Step("Verify get currency text is {currency}")
    public void verifyGetCurrencyText(Currency currency) {
        VerifySoft.verifyEqualsSoft(openAccountCreatingScreen.getCurrentText(), currency.getCurrency(), "Currency is correct");
    }
}
