package steps;

import api.pages.AutoPaymentsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class AutoPaymentsStep {

    protected AutoPaymentsScreen autoPaymentsScreen;

    @Step("On 'Auto payments' screen")
    public void onAutoPaymentsScreen() {
        autoPaymentsScreen = new AutoPaymentsScreen();
    }

    @Step("Verify auto payments title text is {text}")
    public void verifyAutoPaymentsTitleText(String text) {
        Verify.verifyEquals(autoPaymentsScreen.getAutoPaymentsTitleText(), text, "Auto payments title text is correct");
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(autoPaymentsScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        autoPaymentsScreen.tapOnBackButton();
    }

    @Step("Verify add autopay button is enabled")
    public void verifyAddAutoPayButtonEnabled() {
        autoPaymentsScreen.isAddAutoPaymentButtonEnabled();
    }

    @Step("Tap on add autopay button")
    public void tapOnAddAutoPayButton() {
        autoPaymentsScreen.tapOnAddAutoPayButton();
    }

    @Step("Verify add autopay button title text is {text}")
    public void verifyAddAutoPayButtonTitleText(String text) {
        Verify.verifyEquals(autoPaymentsScreen.getAddAutoPayButtonText(), text, "Add autopay button title text is correct");
    }
}
