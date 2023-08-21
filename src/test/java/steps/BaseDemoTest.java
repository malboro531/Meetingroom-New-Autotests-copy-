package steps;

public class BaseDemoTest extends BaseTest {

    public void goToDemoScreen() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnDemoButton();
        useDemoStep.onDemoScreen();
    }

    public void goToProductsScreen() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
    }
}
