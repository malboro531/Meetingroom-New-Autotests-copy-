package steps.deposits;

import api.pages.deposits.SelectionResultsScreen;
import io.qameta.allure.Step;

import static verification.Verify.verifyTrue;

public class SelectionResultsStep {

    protected SelectionResultsScreen selectionResultsScreen;

    @Step("On SelectionScreen")
    public void onSelectionResultsScreen() {
        selectionResultsScreen = new SelectionResultsScreen();
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        selectionResultsScreen.tapOnBackButton();
    }

    @Step("Tap on cross button")
    public void tapOnCrossButton() {
        selectionResultsScreen.tapOnCrossButton();
    }

    @Step("Tap on alert frame ok button")
    public void tapOnAlertFrameBackButton() {
        selectionResultsScreen.tapOnAlertFrameOkButton();
    }

    @Step("Tap on alert frame back button")
    public void tapOnAlertFrameOkButton() {
        selectionResultsScreen.tapOnAlertFrameBackButton();
    }

    @Step("Tap on Deposit Product Cards")
    public void tapOnDepositProductCards() {
        selectionResultsScreen.tapOnDepositProductCards();
    }

    @Step("Verify 'Selection ResultsScreen' is open")
    public void verifySelectionResultsScreenOpen() {
        selectionResultsScreen.verifyPageIsOpened();
    }

    @Step("Verify 'Back Button' is displayed")
    public void verifyBackButtonIsDisplayed() {
        verifyTrue(selectionResultsScreen.isBackButtonDisplayed(), "Back Button is displayed");
    }

    @Step("Verify 'Selection Results header' is displayed")
    public void verifySelectionResultsHeaderIsDisplayed() {
        verifyTrue(selectionResultsScreen.isSelectionResultsHeaderDisplayed(),
                "Selection Results header is displayed");
    }

    @Step("Verify 'Deposit Product cards' is displayed")
    public void verifyDepositProductCardsIsDisplayed() {
        verifyTrue(selectionResultsScreen.isDepositProductCardsDisplayed(),
                "Deposit Product cards is displayed");
    }

    @Step("Verify 'Cross Button' is displayed")
    public void verifyCrossButtonIsDisplayed() {
        verifyTrue(selectionResultsScreen.isCrossButtonDisplayed(),
                "Cross Button is displayed");
    }

    @Step("Verify 'Alert Frame' is displayed")
    public void verifyAlertFrameIsDisplayed() {
        verifyTrue(selectionResultsScreen.isAlertFrameDisplayed(),
                "Alert Frame is displayed");
    }

    @Step("Verify alert frame 'Ok Button' is displayed")
    public void verifyAlertFrameOkButtonIsDisplayed() {
        verifyTrue(selectionResultsScreen.isAlertFrameOkButtonDisplayed(),
                "Alert frame Ok Button is displayed");
    }

    @Step("Verify alert frame 'Back Button' is displayed")
    public void verifyAlertFrameBackButtonIsDisplayed() {
        verifyTrue(selectionResultsScreen.isAlertFrameBackButtonDisplayed(),
                "Alert frame Back Button is displayed");
    }
}
