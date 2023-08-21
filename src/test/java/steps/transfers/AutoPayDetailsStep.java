package steps.transfers;

import api.pages.transfers.AutoPayDetailsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class AutoPayDetailsStep {

    protected AutoPayDetailsScreen autoPayDetailsScreen;

    @Step("On 'Autopay details' screen")
    public void onAutoPayDetailsScreen() {
        autoPayDetailsScreen = new AutoPayDetailsScreen();
    }

    @Step("Verify auto pay details title text is {text}")
    public void verifyAutoPayDetailsTitleText(String text) {
        Verify.verifyEquals(autoPayDetailsScreen.getAutoPayDetailsTitleText(), text, "Auto pay details title text is correct");
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(autoPayDetailsScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Verify auto pay name is {autoPayName}")
    public void verifyAutoPayNameTextIsCorrect(String autoPayName) {
        Verify.verifyEquals(autoPayDetailsScreen.getAutoPayName(), autoPayName, "Auto pay name is correct");
    }

    @Step("Verify that from card title is displayed")
    public void verifyFromCardTitleIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isFromCardTitleDisplayed(), "From card title is displayed");
    }

    @Step("Verify amount title is displayed")
    public void verifyAmountTitleIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isAmountTitleDisplayed(), "Amount title is displayed");
    }

    @Step("Verify that amount is {amount}")
    public void verifyAmountIsCorrect(String amount) {
        Verify.verifyEquals(autoPayDetailsScreen.getAmountText(), "$ " + amount, "Amount information is correct");
    }

    @Step("Verify to card title is displayed")
    public void verifyToCardTitleIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isToCardTitleDisplayed(), "To card title is displayed");
    }

    @Step("Verify that to card is {toCard}")
    public void verifyToCardIsCorrect(String toCard) {
        Verify.verifyEquals(autoPayDetailsScreen.getToCardText(), toCard, "To card information is correct");
    }

    @Step("Verify that bank name title is displayed")
    public void verifyBankNameTitleIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isBankNameDisplayed(), "Bank name title is displayed");
    }

    @Step("Verify next payment date title is displayed")
    public void verifyNextPaymentDateIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isNextPaymentDateDisplayed(), "Next payment date is displayed");
    }

    @Step("Verify that next payment date is {nextPaymentDate}")
    public void verifyNextPaymentDateIsCorrect(String nextPaymentDate) {
        Verify.verifyEquals(autoPayDetailsScreen.getNextPaymentDateText(), nextPaymentDate, "Next payment date information is correct");
    }

    @Step("Verify frequency title is displayed")
    public void verifyFrequencyIsDisplayed() {
        Verify.verifyTrue(autoPayDetailsScreen.isFrequencyTitleDisplayed(), "Frequency is displayed");
    }

    @Step("Verify that frequency is {frequency}")
    public void verifyFrequencyIsCorrect(String frequency) {
        Verify.verifyEquals(autoPayDetailsScreen.getFrequencyText(), frequency, "Frequency information is correct");
    }

    @Step("Tap on add autopay button")
    public void tapOnAddAutoPayButton() {
        autoPayDetailsScreen.tapOnAddPaymentButton();
    }
}
