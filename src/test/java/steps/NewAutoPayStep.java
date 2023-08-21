package steps;

import api.pages.NewAutoPayScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class NewAutoPayStep {

    protected NewAutoPayScreen newAutoPayScreen;

    @Step("On 'New auto pay' screen")
    public void onNewAutoPayScreen() {
        newAutoPayScreen = new NewAutoPayScreen();
    }

    @Step("Verify new auto pay title text is {text}")
    public void verifyNewAutoPayTitleText(String text) {
        Verify.verifyEquals(newAutoPayScreen.getNewAutoPayTitleText(), text, "New auto pay title text is correct");
    }

    @Step("Verify back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(newAutoPayScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Verify next button isn't enabled")
    public void verifyNextButtonIsNotEnabled() {
        Verify.verifyFalse(newAutoPayScreen.isNextButtonEnabled(), "Next button isn't enabled");
    }

    @Step("Verify next button is enabled")
    public void verifyNextButtonIsEnabled() {
        Verify.verifyTrue(newAutoPayScreen.isNextButtonEnabled(), "Next button is enabled");
    }

    @Step("Verify that auto pay name title text is displayed")
    public void verifyAutoPayNameTitleTextIsDisplayed() {
        Verify.verifyTrue(newAutoPayScreen.isAutoPayNameTitleTextDisplayed(), "Auto pay name title text is displayed");
    }

    @Step("Verify that from card title text is displayed")
    public void verifyFromCardTitleTextIsDisplayed() {
        Verify.verifyTrue(newAutoPayScreen.isFromCardTitleDisplayed(), "From card title text is displayed");
    }

    @Step("Verify that enter amount title text is displayed")
    public void verifyEnterAmountTitleTextIsDisplayed() {
        Verify.verifyTrue(newAutoPayScreen.isEnterAmountTitleTextDisplayed(), "Enter amount title text is displayed");
    }

    @Step("Verify that to card title text is displayed")
    public void verifyToCardTitleTextIsDisplayed() {
        Verify.verifyTrue(newAutoPayScreen.isToCardTitleTextDisplayed(), "To card title text is displayed");
    }

    @Step("Enter {autoPayName} to auto pay name field")
    public void enterAutoPayNameToField(String autoPayName) {
        newAutoPayScreen.enterAutoPayNameToField(autoPayName);
    }

    @Step("Tap on from card field")
    public void tapOnFromCardField() {
        newAutoPayScreen.tapOnFromCardField();
    }

    @Step("Tap on from card clickable area for choosing from card-card")
    public void tapOnFromCardClickableArea() {
        newAutoPayScreen.tapOnCardClickableArea();
    }

    @Step("Enter {amount} to enter amount field")
    public void enterAmountToField(String amount) {
        newAutoPayScreen.enterAmountToField(amount);
    }

    @Step("Enter {toCard} to enter amount field")
    public void enterToCardToField(String toCardnt) {
        newAutoPayScreen.enterToCardToField(toCardnt);
    }

    @Step("Tap on next button")
    public void tapOnNextButton() {
        newAutoPayScreen.tapOnNextButton();
    }
}
