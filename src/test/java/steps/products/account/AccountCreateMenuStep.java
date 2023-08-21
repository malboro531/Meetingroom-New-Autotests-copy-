package steps.products.account;

import api.pages.products.accounts.AccountCreateMenuScreen;
import io.qameta.allure.Step;
import verification.Verify;
import verification.VerifySoft;

public class AccountCreateMenuStep {

    protected AccountCreateMenuScreen accountCreateMenuScreen;

    @Step("On account create menu")
    public void onAccountCreateMenu() {
        accountCreateMenuScreen = new AccountCreateMenuScreen();
    }

    @Step("Tap on next button")
    public void tapOnNextButton() {
        accountCreateMenuScreen.tapNextButton();
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        accountCreateMenuScreen.tapBackButton();
    }

    @Step("Tap close button")
    public void tapCloseButton() {
        accountCreateMenuScreen.tapCloseButton();
    }

    @Step("Click OK button")
    public void tapOKButton() {
        accountCreateMenuScreen.tapButtonOK();
    }

    @Step("Verify windows 'CancelAccountSelection' is displayed")
    public void verifyDisplayedCancelAccountSelection() {
        VerifySoft.verifyTrueSoft(accountCreateMenuScreen.displayedCancelAccountSelection(), "Cancel account selection is displayed");
    }

    @Step("Verify button OK is displayed")
    public void verifyDisplayedOK() {
        VerifySoft.verifyTrueSoft(accountCreateMenuScreen.displayedOK(), "Button OK is displayed");
    }

    @Step("Verify button Cancel is displayed")
    public void verifyDisplayedCancel() {
        VerifySoft.verifyTrueSoft(accountCreateMenuScreen.displayedCancel(), "Button cancel is displayed");
    }

    @Step("Verify pop Up is not showing not displayed")
    public AccountCreateMenuStep verifyPopUpIsNotDisplayed() {
        Verify.verifyFalse(accountCreateMenuScreen.popUpIsNotDisplayed(),
                "Cancel account selection is not displayed");
        return this;
    }
}