package steps;

import api.pages.AdditionAutoPaymentScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class AdditionAutoPaymentStep {

    protected AdditionAutoPaymentScreen additionAutoPaymentScreen;

    @Step("On 'Addition auto payment' screen")
    public void onAdditionAutoPaymentScreen() {
        additionAutoPaymentScreen = new AdditionAutoPaymentScreen();
    }

    @Step("Verify addition auto payment title text is {text}")
    public void verifyAdditionAutoPaymentTitleText(String text) {
        Verify.verifyEquals(additionAutoPaymentScreen.getAdditionAutoPaymentTitleText(), text, "Addition auto payment title text is correct");
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(additionAutoPaymentScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on transfer from card to card button")
    public void tapOnTransferFromCardToCardButton() {
        additionAutoPaymentScreen.tapOnTransferFromCardToCardButton();
    }
}
