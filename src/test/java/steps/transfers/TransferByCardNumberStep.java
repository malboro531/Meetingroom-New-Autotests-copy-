package steps.transfers;

import api.pages.transfers.TransferByCardNumberScreen;
import io.qameta.allure.Step;
import verification.Verify;

import static constants.GlobalData.AMOUNT_100;
import static constants.GlobalData.VALID_CARD_NUMBER;

public class TransferByCardNumberStep {

    protected TransferByCardNumberScreen transferByCardNumberScreen;

    @Step("On 'Transfer by card number' screen")
    public TransferByCardNumberStep onTransferByCardNumberScreen() {
        transferByCardNumberScreen = new TransferByCardNumberScreen();
        return this;
    }

    @Step("Tap on arrow button")
    public TransferByCardNumberStep tapOnArrowButton() {
        transferByCardNumberScreen.tapOnArrowButton();
        return this;
    }

    @Step("Tap on cross button")
    public TransferByCardNumberStep tapOnCrossButton() {
        transferByCardNumberScreen.tapOnCrossButton();
        return this;
    }

    @Step("Tap on from card field")
    public TransferByCardNumberStep tapOnFromCardField() {
        transferByCardNumberScreen.tapOnFromCardField();
        return this;
    }

    @Step("Tap on to card field")
    public TransferByCardNumberStep tapOnToCardField() {
        transferByCardNumberScreen.tapOnToCardField();
        return this;
    }

    @Step("Tap on next button")
    public TransferByCardNumberStep tapOnNextButton() {
        transferByCardNumberScreen.tapOnNextButton();
        return this;
    }

    @Step("Tap on confirm button")
    public TransferByCardNumberStep tapOnConfirmButton() {
        transferByCardNumberScreen.tapOnConfirmButton();
        return this;
    }

    @Step("Tap on to Card Field Cross button")
    public TransferByCardNumberStep tapOnToCardFieldCrossButton() {
        transferByCardNumberScreen.tapOnToCardFieldCrossButton();
        return this;
    }

    @Step("Choose first card")
    public TransferByCardNumberStep chooseFirstCard() {
        transferByCardNumberScreen.tapOnFirstCardButton();
        return this;
    }

    @Step("Choose second card")
    public TransferByCardNumberStep chooseSecondCard() {
        transferByCardNumberScreen.tapOnSecondCardButton();
        return this;
    }

    @Step("Enter card number {cardNumber} to 'to card' field")
    public TransferByCardNumberStep enterCardNumberToToCardField(String cardNumber) {
        transferByCardNumberScreen.enterCardNumber(cardNumber);
        return this;
    }

    @Step("Enter amount {amount} to amount field")
    public TransferByCardNumberStep enterAmountToAmountField(String amount) {
        transferByCardNumberScreen.enterAmount(amount);
        return this;
    }

    @Step("Verify card which had been chosen for the transfer before is not displayed")
    public TransferByCardNumberStep verifySecondCardButtonIsNotDisplayed() {
        Verify.verifyFalse(transferByCardNumberScreen.secondCardButtonIsDisplayed(),
                "Card which had been chosen for the transfer before is not displayed");
        return this;
    }

    @Step("Verify that error message is correct")
    public TransferByCardNumberStep verifyErrorMessageIsCorrect(String errorMessage) {
        Verify.verifyEquals(errorMessage, transferByCardNumberScreen.getErrorMessage(),
                "Error message is correct");
        return this;
    }

    @Step("Verify that 'to card' field displays correct data")
    public TransferByCardNumberStep verifyToCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, transferByCardNumberScreen.getToCardFieldText(),
                "To card field displays correct data");
        return this;
    }

    @Step("Verify that 'from card' field displays correct data")
    public TransferByCardNumberStep verifyFromCardFieldDisplaysCorrectData(String data) {
        Verify.verifyEquals(data, transferByCardNumberScreen.getFromCardFieldText(),
                "From card field displays correct data");
        return this;
    }

    @Step("Verify that 'Next' button isn't enabled")
    public TransferByCardNumberStep verifyNextButtonIsNotEnabled() {
        Verify.verifyFalse(transferByCardNumberScreen.isNextButtonEnabled(), "'Next' button isn't enabled");
        return this;
    }

    @Step("On 'Transfer by card number' screen choose second card for transaction")
    public TransferByCardNumberStep choseSecondCardForTransactionOnTransferByCardNumberScreen() {
        transferByCardNumberScreen = new TransferByCardNumberScreen();
        transferByCardNumberScreen.tapOnFromCardField();
        transferByCardNumberScreen.tapOnSecondCardButton();
        return this;
    }
}
