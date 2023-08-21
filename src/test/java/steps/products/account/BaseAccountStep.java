package steps.products.account;

import steps.BaseTest;

public class BaseAccountStep extends BaseTest {

    public void setAccountCurrency() {
        mainStep.onMainScreen();
        mainStep.isMainScreenIsOpen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnAccountsInlay();
        productsStep.tapOnAccountsInlay();
        openCardStep.tapOnGotItButton();
        openAccountStep.onOpenAccountScreen();
        openAccountStep.verifyOpenAccountScreenIsOpen();
        openAccountStep.tapOnAddAccountButton();
        openAccountCreatingStep.onOpenAccountCreatingScreen();
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.verifyAccountCreatingScreenIsOpened();
        openAccountCreatingStep.verifyButtonCurrencyIsDisplayed();
        openAccountCreatingStep.verifyButtonCurrencyIsDisplayed();
        openAccountCreatingStep.verifyLogoIsDisplayed();
        openAccountCreatingStep.verifyButtonNextIsDisplayed();
    }
}
