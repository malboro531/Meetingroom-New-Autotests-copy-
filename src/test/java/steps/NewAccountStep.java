package steps;

import api.pages.NewAccountScreen;
import io.qameta.allure.Step;
import steps.transfers.CommonStep;
import verification.VerifySoft;

import static constants.PersonalDetails.*;

public class NewAccountStep extends CommonStep {

    NewAccountScreen newAccountScreen;

    @Step("On 'New account' screen")
    public void onNewAccountScreen() {
        newAccountScreen = new NewAccountScreen();
    }

    @Step("Verify 'New account' screen is open")
    public void verifyNewAccountScreenIsOpen() {
        newAccountScreen.verifyPageIsOpened();
    }

    @Step("Verify element 'Currency' is correct")
    public void verifyCurrencyElementIsCorrect() {
        VerifySoft.verifyEqualsSoft(newAccountScreen.getCurrencyText(), CURRENCY, "Element Currency is correct");
    }

    @Step("Verify element 'Account' is correct")
    public void verifyAccountElementIsCorrect() {
        VerifySoft.verifyEqualsSoft(newAccountScreen.getAccountText(), ACCOUNT, "Element Account is correct");
    }

    @Step("Verify element 'Owner' is correct")
    public void verifyOwnerElementIsCorrect() {
        VerifySoft.verifyEqualsSoft(newAccountScreen.getOwnerText(), OWNER, "Element Owner is correct");
    }

    @Step("Verify element 'Bank' is correct")
    public void verifyBankElementIsCorrect() {
        VerifySoft.verifyEqualsSoft(newAccountScreen.getBankText(), BANK, "Element Bank is correct");
    }

    @Step("Verify element 'Date' is correct")
    public void verifyDateElementIsCorrect() {
        VerifySoft.verifyEqualsSoft(newAccountScreen.getDateText(), DATE, "Element Date is correct");
    }
}