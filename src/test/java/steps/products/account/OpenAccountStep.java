package steps.products.account;

import api.pages.products.accounts.OpenAccountsScreen;
import io.qameta.allure.Step;

public class OpenAccountStep {

    protected OpenAccountsScreen openAccountsScreen;

    @Step("Open OpenAccountScreen")
    public void onOpenAccountScreen() {
        openAccountsScreen = new OpenAccountsScreen();
    }

    @Step("Verify Accounts Screen is open")
    public void verifyOpenAccountScreenIsOpen() {
        openAccountsScreen.verifyPageIsOpened();
    }

    @Step("Tap on addAccountButton")
    public void tapOnAddAccountButton() {
        openAccountsScreen.tapOnAddAccountButton();
    }
}
