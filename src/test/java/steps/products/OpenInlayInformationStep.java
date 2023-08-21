package steps.products;

import api.pages.products.OpenChooseCreditScreen;
import api.pages.products.OpenInlayInformationScreen;
import io.qameta.allure.Step;

public class OpenInlayInformationStep {

    protected OpenInlayInformationScreen openInlayInformationScreen;

    @Step("On Open Inlay Information Screen")
    public void onOpenInlayInformationScreen() {
        openInlayInformationScreen = new OpenInlayInformationScreen();
    }

    @Step("Verify 'Information Screen' is open")
    public void verifyInformationScreenIsOpen() {
        openInlayInformationScreen.verifyPageIsOpened();
    }
}
