package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.MORE_TITLE;

@PageName(pageName = MORE_TITLE)
public class MoreScreen extends BaseScreen {

    @Required
    @FindBy(id = "currency_exchange_text_view")
    private WebElement currencyExchange;

    @Required
    @FindBy(id = "bank_branches_text_view")
    private WebElement bankBranches;

    @Required
    @FindBy(id = "contact_text_view")
    private WebElement contacts;

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement moreTitle;

    public String getCurrencyExchangeText() {
        return currencyExchange.getText();
    }

    public String getBankBranchesText() {
        return bankBranches.getText();
    }

    public String getContactsText() {
        return contacts.getText();
    }

    public boolean isCurrencyExchangeEnabled() {
        return currencyExchange.isEnabled();
    }

    public boolean isBankBranchesEnabled() {
        return bankBranches.isEnabled();
    }

    public boolean isContactsEnabled() {
        return contacts.isEnabled();
    }

    public boolean isMoreTitleDisplayed() {
        return moreTitle.isDisplayed();
    }

    public void tapOnCurrencyExchange() {
        currencyExchange.click();
    }

    public void tapOnBankBranches() {
        bankBranches.click();
    }

    public void tapOnContacts() {
        contacts.click();
    }
}
