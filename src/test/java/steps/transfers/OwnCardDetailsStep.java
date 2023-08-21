package steps.transfers;

import api.pages.transfers.OwnCardDetailsScreen;
import io.qameta.allure.Step;

public class OwnCardDetailsStep {

    protected OwnCardDetailsScreen cardDetailsScreen;

    @Step("On Card Details Screen")
    public void onCardDetailsScreen() {
        cardDetailsScreen = new OwnCardDetailsScreen();
    }

    @Step("Tap on transfers")
    public void tapOnTransferButton() {
        cardDetailsScreen.tapOnTransferButton();
    }
}
