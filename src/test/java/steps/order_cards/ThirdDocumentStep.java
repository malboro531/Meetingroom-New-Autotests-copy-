package steps.order_cards;

import api.pages.order_card.ThirdDocumentScreen;
import io.qameta.allure.Step;

//Todo Пересмотреть использование в сторону DocumentStep
public class ThirdDocumentStep {

    protected ThirdDocumentScreen thirdDocumentScreen;

    @Step("On ThirdDocumentScreen Screen")
    public void onThirdDocumentScreen() {
        thirdDocumentScreen = new ThirdDocumentScreen();
    }

    @Step("Tap Confirm button")
    public void tapConfirmButton() {
        thirdDocumentScreen.tapConfirmButton();
    }

    @Step("Verify 'Third Document' is open")
    public void verifyIsThirdDocumentOpen() {
        thirdDocumentScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        thirdDocumentScreen.tapReturnButton();
    }
}