package steps.products.account;

import api.pages.products.accounts.OpenAccountPersonalScreen;
import io.qameta.allure.Step;

public class OpenAccountPersonalStep {

    protected OpenAccountPersonalScreen openAccountPersonalScreen;

    @Step("Open Account personal details screen")
    public void onOpenAccountPersonalScreen() {
        openAccountPersonalScreen = new OpenAccountPersonalScreen();
    }

    @Step("Verify OpenAccountPersonalScreen is opened")
    public void verifyOpenAccountPersonalScreenIsOpened() {
        openAccountPersonalScreen.verifyPageIsOpened();
    }
}
