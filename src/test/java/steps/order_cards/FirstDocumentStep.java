package steps.order_cards;

import api.pages.order_card.FirstDocumentScreen;
import io.qameta.allure.Step;

//Todo Пересмотреть использование в сторону DocumentStep
public class FirstDocumentStep {

    protected FirstDocumentScreen firstDocumentScreen;

    @Step("On FirstDocumentScreen")
    public void onFirstDocumentScreen() {
        firstDocumentScreen = new FirstDocumentScreen();
    }

    @Step("Verify 'First Document' is open")
    public void verifyIsFirstDocumentOpen() {
        firstDocumentScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        firstDocumentScreen.tapReturnButton();
    }

    @Step("Tap Confirm button")
    public void tapConfirmButton() {
        firstDocumentScreen.tapConfirmButton();
    }
}