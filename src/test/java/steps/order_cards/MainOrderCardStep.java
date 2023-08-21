package steps.order_cards;

import api.pages.order_card.MainOrderCardScreen;
import io.qameta.allure.Step;

import static verification.Verify.verifyTrue;

public class MainOrderCardStep {

    protected MainOrderCardScreen mainOrderCardScreen;

    @Step("On 'Main order card' screen")
    public void onMainOrderCardScreen() {
        mainOrderCardScreen = new MainOrderCardScreen();
    }

    @Step("Verify 'Main order card' is open")
    public void verifyMainOrderCardScreenIsOpen() {
        mainOrderCardScreen.verifyPageIsOpened();
    }

    @Step("Tap on 'Back' button")
    public void tapOnBackButton() {
        mainOrderCardScreen.tapMainBackButton();
    }

    @Step("Tap on 'Debit' button")
    public void tapOnDebitButton() {
        mainOrderCardScreen.tapDebitButton();
    }

    @Step("Tap on 'Credit' button")
    public void tapOnCreditButton() {
        mainOrderCardScreen.tapCreditButton();
    }
    // функционал не используемый в приложении

   /* @Step("Tap on 'Recycler debit' area")
    public void tapOnRecyclerDebitArea() {
        mainOrderCardScreen.tapRecyclerDebit();
    }*/

    @Step("Verify debit button is selected")
    public void verifyDebitButtonIsSelected() {
        verifyTrue(mainOrderCardScreen.isDebitButtonSelected(), "Button 'Debit' is selected");

    }

    @Step("Verify credit button is selected")
    public void verifyCreditButtonIsSelected() {
        verifyTrue(mainOrderCardScreen.isCreditButtonSelected(), "Button 'Credit' is selected");
    }

    @Step("Tap on first debit card")
    public void tapOnFirstDebitCard() {
        mainOrderCardScreen.tapOnFirstDebitCard();
    }

    @Step("Tap on random card")
    public void tapOnRandomDebitCard() {
        mainOrderCardScreen.tapOnRandomDebitCard();
    }
}
