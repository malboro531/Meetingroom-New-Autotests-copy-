package steps;

import api.pages.NewAutoPayAdditionalScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class NewAutoPayAdditionalStep {

    protected NewAutoPayAdditionalScreen newAutoPayAdditionalScreen;

    @Step("On 'New auto pay additional' screen")
    public void onNewAutoPayAdditionalScreen() {
        newAutoPayAdditionalScreen = new NewAutoPayAdditionalScreen();
    }

    @Step("Verify new auto pay additional title text is {text}")
    public void verifyNewAutoPayAdditionalTitleText(String text) {
        Verify.verifyEquals(newAutoPayAdditionalScreen.getNewAutoPayAdditionalTitleText(), text, "New auto pay additional title text is correct");
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(newAutoPayAdditionalScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Verify confirm button isn't enabled")
    public void verifyConfirmButtonIsNotEnabled() {
        Verify.verifyFalse(newAutoPayAdditionalScreen.isConfirmButtonEnabled(), "Confirm button isn't enabled");
    }

    @Step("Tap on select date field")
    public void tapOnSelectDateField() {
        newAutoPayAdditionalScreen.tapOnSelectDateField();
    }

    @Step("Tap on select frequency field")
    public void tapOnSelectFrequencyField() {
        newAutoPayAdditionalScreen.tapOnSelectFrequencyField();
    }

    @Step("Tap on monthly button")
    public void tapOnMonthlyButton() {
        newAutoPayAdditionalScreen.tapOnMonthlyButton();
    }

    @Step("Verify confirm button is enabled")
    public void verifyConfirmButtonIsEnabled() {
        Verify.verifyTrue(newAutoPayAdditionalScreen.isConfirmButtonEnabled(), "Confirm button is enabled");
    }

    @Step("Swipe month up")
    public void selectNextMonth() {
        newAutoPayAdditionalScreen.swipeMonthUp();
    }

    @Step("Verify that next payment date title is displayed")
    public void verifyNextPaymentDateTitleIsDisplayed() {
        Verify.verifyTrue(newAutoPayAdditionalScreen.isNextPaymentDateTitleDisplayed(), "Next payment date title is displayed");
    }

    @Step("Verify that frequency title is displayed")
    public void verifyFrequencyTitleIsDisplayed() {
        Verify.verifyTrue(newAutoPayAdditionalScreen.isFrequencyTitleDisplayed(), "Frequency title is displayed");
    }

    @Step("Tap on confirm button")
    public void tapOnConfirmButton() {
        newAutoPayAdditionalScreen.tapOnConfirmButton();
    }

    public String getNextPaymentDateText() {
        return newAutoPayAdditionalScreen.getNextPaymentDateText();
    }

    public String getFrequencyText() {
        return newAutoPayAdditionalScreen.getFrequencyText();
    }
}
