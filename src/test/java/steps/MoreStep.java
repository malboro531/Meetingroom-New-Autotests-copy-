package steps;

import api.pages.MoreScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class MoreStep {

    protected MoreScreen moreScreen;

    @Step("On 'More' screen")
    public void onMoreScreen() {
        moreScreen = new MoreScreen();
    }

    @Step("Verify currency exchange field text is '{text}'")
    public void verifyCurrencyExchangeText(String text) {
        Verify.verifyEquals(moreScreen.getCurrencyExchangeText(), text, "Currency exchange text is correct");
    }

    @Step("Verify bank branches field text is '{text}'")
    public void verifyBankBranchesText(String text) {
        Verify.verifyEquals(moreScreen.getBankBranchesText(), text, "Bank branches text is correct");
    }

    @Step("Verify contacts field text is '{text}'")
    public void verifyContactsText(String text) {
        Verify.verifyEquals(moreScreen.getContactsText(), text, "Contacts text is correct");
    }

    @Step("Verify that currency exchange is enabled")
    public void verifyCurrencyExchangeIsEnabled() {
        Verify.verifyTrue(moreScreen.isCurrencyExchangeEnabled(), "Currency exchange field is enabled");
    }

    @Step("Verify that bank branches is enabled")
    public void verifyBankBranchesIsEnabled() {
        Verify.verifyTrue(moreScreen.isBankBranchesEnabled(), "Bank branches field is enabled");
    }

    @Step("Verify that contacts is enabled")
    public void verifyContactsIsEnabled() {
        Verify.verifyTrue(moreScreen.isContactsEnabled(), "Contacts field is enabled");
    }

    @Step("Tap on currency exchange field")
    public void tapOnCurrencyExchange() {
        moreScreen.tapOnCurrencyExchange();
    }

    @Step("Tap on bank branches field")
    public void tapOnBankBranches() {
        moreScreen.tapOnBankBranches();
    }

    @Step("Tap on contacts field")
    public void tapOnContactsField() {
        moreScreen.tapOnContacts();
    }

    @Step("Verify that more title is displayed")
    public void verifyMoreTitleIsDisplayed() {
        Verify.verifyTrue(moreScreen.isMoreTitleDisplayed(), "More title is displayed");
    }
}
