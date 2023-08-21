package steps;

import api.pages.CurrencyExchangeScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class CurrencyExchangeStep {

    protected CurrencyExchangeScreen currencyExchangeScreen;

    @Step("On 'Currency exchange' screen")
    public void onCurrencyExchangeScreen() {
        currencyExchangeScreen = new CurrencyExchangeScreen();
    }

    @Step("Verify that EUR currency is displayed")
    public void verifyEurIsDisplayed() {
        Verify.verifyTrue(currencyExchangeScreen.isEurDisplayed(), "EUR currency is displayed");
    }

    @Step("Verify that USD currency is displayed")
    public void verifyUsdIsDisplayed() {
        Verify.verifyTrue(currencyExchangeScreen.isUsdDisplayed(), "USD currency is displayed");
    }

    @Step("Verify that BYN currency is displayed")
    public void verifyBynIsDisplayed() {
        Verify.verifyTrue(currencyExchangeScreen.isBynDisplayed(), "BYN currency is displayed");
    }

    @Step("Verify that EUR is enabled")
    public void verifyEurIsEnabled() {
        Verify.verifyTrue(currencyExchangeScreen.isEurEnabled(), "EUR is enabled");
    }

    @Step("Verify that USD is enabled")
    public void verifyUsdIsEnabled() {
        Verify.verifyTrue(currencyExchangeScreen.isUsdEnabled(), "USD is enabled");
    }

    @Step("Verify that BYN is enabled")
    public void verifyBynIsEnabled() {
        Verify.verifyTrue(currencyExchangeScreen.isBynEnabled(), "BYN is enabled");
    }

    @Step("Verify that back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(currencyExchangeScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        currencyExchangeScreen.tapOnBackButton();
    }

    @Step("Verify currency exchange title text")
    public void verifyCurrencyExchangeTitleText(String title) {
        Verify.verifyEquals(currencyExchangeScreen.getCurrencyExchangeTitleText(), title, "Currency exchange title is correct");
    }
}
