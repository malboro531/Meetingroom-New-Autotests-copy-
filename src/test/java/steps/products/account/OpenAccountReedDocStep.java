package steps.products.account;

import api.pages.products.accounts.OpenAccountReedDocScreen;
import io.qameta.allure.Step;

public class OpenAccountReedDocStep {

    protected OpenAccountReedDocScreen openAccountReedDocScreen;

    @Step("On open reed document screen")
    public void onOpenAccountReedDocScreen() {
        openAccountReedDocScreen = new OpenAccountReedDocScreen();
    }

    @Step("Tap on confirm button")
    public void tapOnConfirmButton() {
        openAccountReedDocScreen.tapOnConfirmButton();
    }
}
