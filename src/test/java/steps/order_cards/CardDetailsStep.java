package steps.order_cards;

import api.pages.order_card.CardDetailsScreen;
import io.qameta.allure.Step;

public class CardDetailsStep {
    protected CardDetailsScreen cardDetailsScreen;

    @Step("On Card Details")
    public void onCardDetails() {
        cardDetailsScreen = new CardDetailsScreen();
    }

    @Step("Verify 'Card Details' is open")
    public void verifyIsCardDetailsOpen() {
        cardDetailsScreen.verifyPageIsOpened();
    }

    @Step("Tap order card button")
    public void tapOrderCardButton() {
        cardDetailsScreen.tapOrderCardButton();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        cardDetailsScreen.tapReturnButton();
    }
}
