package steps.deposits;

import api.pages.deposits.SelectAccountScreen;
import io.qameta.allure.Step;

public class SelectAccountStep {

    protected SelectAccountScreen selectAccountScreen;

    @Step("On Select Account Screen")
    public void onSelectAccountScreen() {
        selectAccountScreen = new SelectAccountScreen();
    }

    @Step("Verify Select Account Screen is open")
    public void verifySelectAccountScreenIsOpen() {
        selectAccountScreen.verifyPageIsOpened();
    }
}
