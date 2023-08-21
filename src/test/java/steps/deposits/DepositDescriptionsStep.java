package steps.deposits;

import api.pages.deposits.DepositDescriptionsScreen;
import io.qameta.allure.Step;

import static verification.Verify.verifyTrue;

public class DepositDescriptionsStep {

    protected DepositDescriptionsScreen depositDescriptionsScreen;

    @Step("On Deposit Product Screen")
    public void onDepositDescriptionsScreen() {
        depositDescriptionsScreen = new DepositDescriptionsScreen();
    }

    @Step("Verify Deposit Product Screen is open")
    public void verifyDepositDescriptionsScreenIsOpen() {
        depositDescriptionsScreen.verifyPageIsOpened();
    }

    @Step("Verify 'Back Button' is displayed")
    public void verifyBackButtonIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isBackButtonDisplayed(), "Back Button is displayed");
    }

    @Step("Verify 'Deposit Name' is displayed")
    public void verifyDepositNameIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isDepositNameDisplayed(), "Deposit Name is displayed");
    }

    @Step("Verify 'Cross Button' is displayed")
    public void verifyCrossButtonIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isCrossButtonDisplayed(), "Cross Button is displayed");
    }

    @Step("Verify 'Next Button' is displayed")
    public void verifyNextButtonIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isNextButtonDisplayed(), "Next Button is displayed");
    }

    @Step("Verify 'Deposit Description Title' is displayed")
    public void verifyDepositDescriptionTitleIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isDepositDescriptionTitleDisplayed(),
                "Deposit Description Title is displayed");
    }

    @Step("Verify 'Deposit Description' is displayed")
    public void verifyDepositDescriptionIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isDepositDescriptionDisplayed(),
                "Deposit Description is displayed");
    }

    @Step("Verify 'Deposit Conditions' is displayed")
    public void verifyDepositConditionsIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isDepositConditionsDisplayed(),
                "Deposit Conditions is displayed");
    }

    @Step("Verify 'Back To Selection Button' is displayed")
    public void verifyBackToSelectionButtonIsDisplayed() {
        verifyTrue(depositDescriptionsScreen.isBackToSelectionButtonDisplayed(),
                "Back To Selection Button is displayed");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        depositDescriptionsScreen.tapOnBackButton();
    }

    @Step("Tap on Next button")
    public void tapOnNextButton() {
        depositDescriptionsScreen.tapOnNextButton();
    }

    @Step("Tap on Back to selection button")
    public void tapOnBackToSelectionButton() {
        depositDescriptionsScreen.tapOnBackToSelectionButton();
    }
}
