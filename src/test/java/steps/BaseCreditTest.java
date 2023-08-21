package steps;

public class BaseCreditTest extends BaseTest {

    public void goToCreditsScreen() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCreditsInlay();
        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnGotItButton();
    }
}
