package steps.order_cards;

import api.pages.order_card.OrderConfirmationScreen;
import io.qameta.allure.Step;

public class OrderConfirmationStep {
    protected OrderConfirmationScreen orderConfirmationScreen;

    @Step("On OrderConfirmationScreen")
    public void onOrderConfirmationScreen() {
        orderConfirmationScreen = new OrderConfirmationScreen();
    }

    @Step("Verify 'Order Confirmation' is open")
    public void verifyIsOrderConfirmationOpen() {
        orderConfirmationScreen.verifyPageIsOpened();
    }

    @Step("Enter Confirmation Code")
    public void enterConfirmationCodeToField(String confirmationCode) {
        orderConfirmationScreen.enterConfirmationCodeToField(confirmationCode);
    }

    @Step("Tap Continue Button")
    public void tapContinueButton() {
        orderConfirmationScreen.tapContinueButton();
    }
}
