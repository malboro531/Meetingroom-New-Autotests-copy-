package steps.order_cards;

import api.pages.order_card.CityScreen;
import io.qameta.allure.Step;

public class CityStep {
    protected CityScreen cityScreen;

    @Step("On CityScreen")
    public void onCityScreen() {
        cityScreen = new CityScreen();
    }

    @Step("Verify 'CityScreen' is open")
    public void verifyIsCityOpen() {
        cityScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        cityScreen.tapReturnButton();
    }
}
