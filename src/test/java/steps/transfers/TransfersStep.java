package steps.transfers;

import api.pages.MainScreen;
import api.pages.transfers.TransfersScreen;
import io.qameta.allure.Step;

public class TransfersStep {

    protected TransfersScreen transfersScreen;

    @Step("On 'Transfers' screen")
    public TransfersStep onTransfersScreen() {
        transfersScreen = new TransfersScreen();
        return this;
    }

    @Step("Tap on transfer to connected card button")
    public TransfersStep tapOnTransferToConnectedCardButton() {
        transfersScreen.tapOnTransferToConnectedCardButton();
        return this;
    }

    @Step("Tap on transfer by card number")
    public TransfersStep tapOnTransferByCardNumberButton() {
        transfersScreen.tapOnTransferByCardNumberButton();
        return this;
    }

    @Step("Tap on transfer by phone number")
    public void tapOnTransferByPhoneNumberButton() {
        transfersScreen.tapOnTransferByPhoneNumberButton();
    }

    @Step("Tap on transfer by account number")
    public void tapOnTransferByAccountNumberButton() {
        transfersScreen.tapOnTransferByAccountNumberButton();
    }
}
