package steps.products.account;

import api.pages.products.accounts.OpenAccountRegAddressScreen;
import io.qameta.allure.Step;

public class OpenAccountRegAddressStep {

    protected OpenAccountRegAddressScreen openAccountRegAddressScreen;

    @Step("On account registration address screen")
    public void onAccountRegAddressScreen() {
        openAccountRegAddressScreen = new OpenAccountRegAddressScreen();
    }

    @Step("Verify AccountRegAddressScreen is opened")
    public void verifyAccountRegAddressScreenIsOpened() {
        openAccountRegAddressScreen.verifyPageIsOpened();
    }
}
