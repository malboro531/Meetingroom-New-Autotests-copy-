package steps.products;

import api.pages.products.ProductsScreen;
import io.qameta.allure.Step;

import static verification.Verify.verifyTrue;

public class ProductsStep {

    protected ProductsScreen productsScreen;

    @Step("On ProductsScreen")
    public void onProductsScreen() {
        productsScreen = new ProductsScreen();
    }

    @Step("Tap on Cards Inlay")
    public void tapOnCardsInlay() {
        productsScreen.tapOnCardsInlay();
    }

    @Step("Tap on Accounts Inlay")
    public void tapOnAccountsInlay() {
        productsScreen.tapOnAccountsInlay();
    }

    @Step("Tap on Credits Inlay")
    public void tapOnCreditsInlay() {
        productsScreen.tapOnCreditsInlay();
    }

    @Step("Tap on Deposits Inlay")
    public void tapOnDepositsInlay() {
        productsScreen.tapOnDepositsInlay();
    }

    @Step("Tap on Home button")
    public void tapOnHomeButton() {
        productsScreen.tapOnHomeButton();
    }

    @Step("Verify Inlay 'Deposits' is Open")
    public void verifyDepositsInlayIsOpen() {
        verifyTrue(productsScreen.isDepositsInlaySelected(), "Inlay 'Deposits' is opened");
    }

    @Step("Tap on card image")
    public void tapOnCardImage() {
        productsScreen.tapOnCardImageInlay();
    }

    @Step("Verify Inlay 'Credits' is Open")
    public void verifyCreditsInlayIsOpen() {
        verifyTrue(productsScreen.isCreditsInlaySelected(), "Inlay 'Credits' is opened");
    }

    @Step("Verify Products screen is open")
    public void verifyProductsIsOpen() {
        productsScreen.verifyPageIsOpened();
    }

    @Step("Verify Cards is selected")
    public void verifyCardsInlaySelected() {
        verifyTrue(productsScreen.verifyCardsInlaySelected(), "Inlay 'Cards' is selected");
    }

    @Step("Swipe element to left")
    public void swipeCardImageInlayToLeft() {
        productsScreen.swipeCardImageInlayToLeft();
    }

    @Step("Swipe element to right")
    public void swipeCardImageInlayToRight() {
        productsScreen.swipeCardImageInlayToRight();
    }

    @Step("Tap cross for closing tag")
    public void tapCrossForClosingTag() {
        productsScreen.tapOnCrossButton();
    }
}
