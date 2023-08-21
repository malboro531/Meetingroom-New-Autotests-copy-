package steps.products;


import api.pages.products.OpenChooseCreditScreen;
import io.qameta.allure.Step;

public class OpenChooseCreditStep {

    protected OpenChooseCreditScreen openChooseCreditScreen;

    @Step("On Open Choose Credit Screen")
    public void onTheOpenChooseCreditScreen() {
        openChooseCreditScreen = new OpenChooseCreditScreen();
    }

    @Step("Verify 'Choose Credit Screen is open'")
    public void verifyChooseCreditScreenIsOpen() {
        openChooseCreditScreen.verifyPageIsOpened();
    }
}
