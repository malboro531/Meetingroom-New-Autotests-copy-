package steps.order_cards;

import api.pages.order_card.SentOrderCardScreen;
import io.qameta.allure.Step;

public class SentOrderCardStep {

    protected SentOrderCardScreen sentOrderCardScreen;

    @Step("On SentOrderCardStepScreen")
    public void onSentOrderCardStepScreen() {
        sentOrderCardScreen = new SentOrderCardScreen();
    }

    @Step("Verify 'Sent Order Card' is open")
    public void verifyMainOrderCardScreenIsOpen() {
        sentOrderCardScreen.verifyPageIsOpened();
    }
}
