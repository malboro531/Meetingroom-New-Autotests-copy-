package steps.order_cards;

import api.pages.order_card.SecondDocumentScreen;
import io.qameta.allure.Step;

//Todo Пересмотреть использование в сторону DocumentStep
public class SecondDocumentStep {

    protected SecondDocumentScreen secondDocumentScreen;

    @Step("On SecondDocumentScreen")
    public void onSecondDocumentScreen() {
        secondDocumentScreen = new SecondDocumentScreen();
    }

    @Step("Verify 'Second Document' is open")
    public void verifyIsSecondDocumentOpen() {
        secondDocumentScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        secondDocumentScreen.tapReturnButton();
    }

    @Step("Tap Confirm button")
    public void tapConfirmButton() {
        secondDocumentScreen.tapConfirmButton();
    }
}