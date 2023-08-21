package steps.products.account;

import api.pages.AccountCreatedScreen;
import io.qameta.allure.Step;
import verification.VerifySoft;

public class AccountCreatedStep {

    protected AccountCreatedScreen accountCreatedScreen;

    @Step("On account created screen")
    public void onAccountCreateMenu() {
        accountCreatedScreen = new AccountCreatedScreen();
    }

    @Step("Verify 'Account created' is open")
    public void verifyIsAccountCreatedIsOpen() {
        accountCreatedScreen.verifyPageIsOpened();
    }

    @Step("Verify back button is displayed")
    public void verifyBackButtonIsDisplayed() {
        VerifySoft.verifyTrueSoft(accountCreatedScreen.isBackButtonDisplayed(), "Back button is displayed");
    }

    @Step("Verify create new card is displayed")
    public void verifyCreateNewCardIsDisplayed() {
        VerifySoft.verifyTrueSoft(accountCreatedScreen.isCreateNewCardDisplayed(), "Create new card is displayed");
    }

    @Step("Tap on back button ")
    public void tapOnBackButton() {
        accountCreatedScreen.tupOnBackButton();
    }

    @Step("Tap on 'Create new card' button")
    public void tapOnCreateNewCardButton() {
        accountCreatedScreen.tupOnCreateNewCardButton();
    }
}
