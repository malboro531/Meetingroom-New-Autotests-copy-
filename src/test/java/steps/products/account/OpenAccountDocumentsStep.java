package steps.products.account;

import api.pages.products.accounts.OpenAccountDocumentsScreen;
import io.qameta.allure.Step;

public class OpenAccountDocumentsStep {

    protected OpenAccountDocumentsScreen openAccountDocumentsScreen;

    @Step("On open account documents screen")
    public void onOpenAccountDocumentsScreen() {
        openAccountDocumentsScreen = new OpenAccountDocumentsScreen();
    }

    @Step("Verify that account documents screen is opened")
    public void verifyOpenAccountDocumentsScreen() {
        openAccountDocumentsScreen.verifyPageIsOpened();
    }

    @Step("Verify that ok-mark opposite first-document")
    public void verifyOkMarkFirstDocIsDisplayed() {
        openAccountDocumentsScreen.verifyOkMarkFirstDocIsDisplayed();
    }

    @Step("Tap on the first document")
    public void tapOnFirstDocumentButton() {
        openAccountDocumentsScreen.tapOnFirstDocumentButton();
    }
}
