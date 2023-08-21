package steps.transfers;

import api.pages.transfers.TransfersToConnectedCardScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class TransfersToConnectedCardStep {

    protected TransfersToConnectedCardScreen transfersToConnectedCardScreen;

    @Step("On 'Transfers to connected card' screen")
    public TransfersToConnectedCardStep onTransfersToConnectedCardScreen() {
        transfersToConnectedCardScreen = new TransfersToConnectedCardScreen();
        return this;
    }

    @Step("Tap on arrow button")
    public TransfersToConnectedCardStep tapOnArrowButton() {
        transfersToConnectedCardScreen.tapOnArrowButton();
        return this;
    }

    @Step("Tap on cross button")
    public TransfersToConnectedCardStep tapOnCrossButton() {
        transfersToConnectedCardScreen.tapOnCrossButton();
        return this;
    }

    @Step("Tap on from card field")
    public TransfersToConnectedCardStep tapOnFromCardField() {
        transfersToConnectedCardScreen.tapOnFromCardField();
        return this;
    }

    @Step("Tap on to card field")
    public TransfersToConnectedCardStep tapOnToCardField() {
        transfersToConnectedCardScreen.tapOnToCardField();
        return this;
    }

    @Step("Tap on next button")
    public TransfersToConnectedCardStep tapOnContinueButton() {
        transfersToConnectedCardScreen.tapOnContinueButton();
        return this;
    }

    @Step("Choose first card")
    public TransfersToConnectedCardStep chooseFirstCard() {
        transfersToConnectedCardScreen.tapOnFirstCardButton();
        return this;
    }

    @Step("Choose second card")
    public TransfersToConnectedCardStep chooseSecondCard() {
        transfersToConnectedCardScreen.tapOnSecondCardButton();
        return this;
    }

    @Step("Verify 'ok' button is displayed")
    public TransfersToConnectedCardStep okButtonIsDisplayed() {
        Verify.verifyTrue(transfersToConnectedCardScreen.okButtonIsDisplayed(),
                "Element \"ок Button\" is displayed");
        return this;
    }

    @Step("Verify 'cancel' button is displayed")
    public TransfersToConnectedCardStep cancelButtonIsDisplayed() {
        Verify.verifyTrue(transfersToConnectedCardScreen.cancelButtonIsDisplayed(),
                "Element \"cancel Button\" is displayed");
        return this;
    }

    @Step("Verify descriprion of 'cancel transfer money' is displayed")
    public TransfersToConnectedCardStep descriptionCancelMoneyIsDisplayed() {
        Verify.verifyEquals(transfersToConnectedCardScreen.descriptionCancelMoneyTransferIsDisplayed(),
                "Are you sure you want to cancel the money transfer?",
                "Element \"description cancel money Button\" is displayed");
        return this;
    }

    @Step("Verify that 'to card' field displays correct data")
    public TransfersToConnectedCardStep verifyToCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, transfersToConnectedCardScreen.getToCardFieldText(),
                "To card field displays correct data");
        return this;
    }

    @Step("Verify that 'from card' field displays correct data")
    public TransfersToConnectedCardStep verifyFromCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, transfersToConnectedCardScreen.getFromCardFieldText(),
                "From card field displays correct data");
        return this;
    }

    @Step("Verify 'continue' button is not enabled")
    public TransfersToConnectedCardStep verifyContinueButtonIsNotEnabled() {
        Verify.verifyFalse(transfersToConnectedCardScreen.isContinueButtonEnabled(),
                "'Continue' button is not enabled");
        return this;
    }

    @Step("Verify 'cross' button is enabled")
    public TransfersToConnectedCardStep verifyCrossButtonIsEnabled() {
        Verify.verifyTrue(transfersToConnectedCardScreen.isCrossButtonEnabled(),
                "'Cross' button is enabled");
        return this;
    }

    @Step("Verify 'arrow' button is enabled")
    public TransfersToConnectedCardStep verifyArrowButtonIsEnabled() {
        Verify.verifyTrue(transfersToConnectedCardScreen.isArrowButtonEnabled(),
                "'Arrow' button is enabled");
        return this;
    }
}
