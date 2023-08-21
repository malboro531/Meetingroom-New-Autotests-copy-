package steps.order_cards;

import api.pages.transfers.HomeSettingsScreen;
import io.qameta.allure.Step;

public class HomeSettingsStep {

    protected HomeSettingsScreen homeSettingsScreen;

    @Step("On Home Settings Screen")
    public void onHomeSettingsScreen() {
        homeSettingsScreen = new HomeSettingsScreen();
    }

    @Step("Verify is Home Settings is open")
    public void verifyIsHomeSettingsIsOpen() {
        homeSettingsScreen.verifyPageIsOpened();
    }
}
