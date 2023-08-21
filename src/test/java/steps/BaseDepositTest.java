package steps;

public class BaseDepositTest extends BaseTest {

    public void goToDepositsScreen() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnDepositsInlay();
        openDepositStep.onOpenDepositScreen();
        openDepositStep.tapOnGotItButton();
        depositsStep.onDepositsScreen();
        depositsStep.verifyDepositsScreenIsOpen();
    }

    public void verifyNavigationButtonIsDisplayed() {
        depositsStep.verifyPlusButtonIsDisplayed();
        depositsStep.verifySearchButtonIsDisplayed();
        depositsStep.verifyFilterButtonIsDisplayed();
    }

    public void goToSelectionScreenAndCheckDepositChoosingOptions() {
        depositsStep.verifyPlusButtonIsDisplayed();
        depositsStep.tapOnPlusButton();
        selectionStep.onSelectionScreen();
        selectionStep.verifySelectionScreenIsOpen();
        selectionStep.verifyDepositAmountSliderIsDisplayed();
        selectionStep.verifyCurrencyIsDisplayed();
        selectionStep.verifyPeriodAmountIsDisplayed();
    }
}
