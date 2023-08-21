package steps.cards;

import api.pages.products.CloseCardSuccessScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class CloseCardSuccessStep {

    public CloseCardSuccessScreen closeCardSuccessScreen;

    @Step("On CloseCardSuccessScreen")
    public void onCloseCardSuccessScreen() {
        closeCardSuccessScreen = new CloseCardSuccessScreen();
    }

    @Step("Verify close card success page is opened")
    public void verifyCloseCardSuccessPageIsOpen() {
        closeCardSuccessScreen.verifyPageIsOpened();
    }

    @Step("Verify that result field displays correct text")
    public void verifyResultFieldDisplaysCorrectText(String text) {
        Verify.verifyEquals(text, closeCardSuccessScreen.getResultText(), "Result field displays correct text");
    }

    @Step("Tap on 'Go to main page' button")
    public void tapOnPrimaryButton() {
        closeCardSuccessScreen.tapOnPrimaryButton();
    }
}
