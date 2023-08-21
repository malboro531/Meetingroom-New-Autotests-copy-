package steps.order_cards;

import api.pages.order_card.PersonalDataScreen;
import io.qameta.allure.Step;

public class PersonalDataStep {
    protected PersonalDataScreen personalDataScreen;

    @Step("On PersonalDataScreen")
    public void onPersonalDataScreen() {
        personalDataScreen = new PersonalDataScreen();
    }

    @Step("Verify 'Personal Data' is open")
    public void verifyIsPersonalDataOpen() {
        personalDataScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        personalDataScreen.tapReturnButton();
    }

    @Step("Tap continue button")
    public void tapContinueButton() {
        personalDataScreen.tapContinueButton();
    }
}
