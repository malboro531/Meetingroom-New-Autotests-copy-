package steps.order_cards;


import api.pages.order_card.CardProcessingScreen;
import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CardProcessingStep {

    protected CardProcessingScreen cardProcessingScreen;

    @Step("On WelcomeScreen")
    public void onCardProcessingScreen() {
        cardProcessingScreen = new CardProcessingScreen();
    }

    @Step("Verify 'Card Processing' is open")
    public void verifyIsCardProcessingOpen() {
        cardProcessingScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        cardProcessingScreen.tapReturnButton();
    }

    @Step("Tap continue button")
    public void tapContinueButton() {
        cardProcessingScreen.tapContinueButton();
    }

    @Step("Tap currency drop down list menu")
    public void tapCurrencyDropDownListMenu() {
        cardProcessingScreen.tapCurrencyDropDownListMenu();
    }

    @Step("Tap payment system drop down list menu")
    public void tapPaymentSystemDropDownListMenu() {
        cardProcessingScreen.tapPaymentSystemDropDownListMenu();
    }

    @Step("Choose USD Currency")
    public void chooseUSDCurrency() {
        cardProcessingScreen.chooseUSDCurrency();
    }

    @Step("Choose EURO Currency")
    public void chooseEUROCurrency() {
        cardProcessingScreen.chooseEUROCurrency();
    }

    @Step("Choose Master Card payment system")
    public void chooseMasterCardPaymentSystem() {
        cardProcessingScreen.chooseMasterCardPaymentSystem();
    }

    @Step("Choose VISA payment system")
    public void chooseVISAPaymentSystem() {
        cardProcessingScreen.chooseVisaPaymentSystem();
    }
    //TODO steps check
}
