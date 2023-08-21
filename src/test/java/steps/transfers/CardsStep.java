package steps.transfers;

import api.pages.deposits.DepositsScreen;
import api.pages.transfers.CardsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class CardsStep {

    protected CardsScreen cardsScreen;

    @Step("On Cards Screen")
    public CardsStep onCardsScreen() {
        cardsScreen = new CardsScreen();
        return this;
    }

    @Step("Tap on Plus Button")
    public CardsStep tapOnPlusButton() {
        cardsScreen.tapOnPlusButton();
        return this;
    }

    @Step("Choose first card")
    public CardsStep chooseFirstCard() {
        cardsScreen.chooseFirstCard();
        return this;
    }

    @Step("Get first card balance")
    public double getFirstCardBalance() {
        return cardsScreen.getFirstCardBalance();
    }

    @Step("Get second card balance")
    public double getSecondCardBalance() {
        return cardsScreen.getSecondCardBalance();
    }

    @Step("Get first card balance text")
    public String getFirstCardBalanceText() {
        return cardsScreen.getFirstCardBalanceText();
    }

    @Step("Verify that card balance displays the correct updated amount")
    public void verifyCardBalanceAfterTransaction(double cardAmount, double cardAmountAfterTransaction) {
        Verify.verifyEquals(cardAmount, cardAmountAfterTransaction,
                "Card balance displays the correct updated amount");
    }
}
