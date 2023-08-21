package steps.transfers;

import api.pages.products.accounts.CommonScreen;
import io.qameta.allure.Step;
import verification.VerifySoft;

public class CommonStep {

    protected CommonScreen commonScreen;

    @Step("On Common screen")
    public void onCommonScreen() {
        commonScreen = new CommonScreen();
    }

    @Step("Tap on next button")
    public void tapOnNextButton() {
        commonScreen.tapOnNextButton();
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        commonScreen.tapOnBackButton();
    }

    @Step("Tap on cancel button")
    public void tapOnCancelButton() {
        commonScreen.tapOnCancelButton();
    }

    @Step("Button next is Displayed")
    public void verifyButtonNextIsDisplayed() {
        VerifySoft.verifyTrueSoft(commonScreen.isNextButtonDisplayed(), "Button next is displayed");
    }

    @Step("Parent panel is displayed")
    public void verifyParentPanelIsDisplayed() {
        VerifySoft.verifyTrueSoft(commonScreen.isParentPanelDisplayed(), "Parent panel is displayed");
    }

    @Step("Ok button is enabled")
    public void verifyOkButtonIsEnabled() {
        VerifySoft.verifyTrueSoft(commonScreen.isOkButtonEnabled(), "Ok button is enabled");
    }

    @Step("Cancel button is enabled")
    public void verifyCancelButtonIsEnabled() {
        VerifySoft.verifyTrueSoft(commonScreen.isCancelButtonEnabled(), "Cancel button is enabled");
    }

    @Step("Tap on OK button")
    public void tubOnOkButton() {
        commonScreen.tapOnOkButton();
    }

    @Step("Tap on close button")
    public void tubOnCloseButton() {
        commonScreen.tapOnCloseButton();
    }
}