package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.NEW_ACCOUNT;

@PageName(pageName = NEW_ACCOUNT)
public class NewAccountScreen extends BaseScreen {

    @Required
    @FindBy(id = "recycler_account_selection")
    private WebElement newAccountTitle;

    @FindBy(id = "currency_title")
    private WebElement currencyElement;

    @FindBy(id = "account_title")
    private WebElement accountElement;

    @FindBy(id = "owner_name_text")
    private WebElement ownerElement;

    @FindBy(id = "bank_name_text")
    private WebElement bankElement;

    @FindBy(id = "open_date_text")
    private WebElement openDateElement;

    public String getCurrencyText() {
        return currencyElement.getText();
    }

    public String getAccountText() {
        return accountElement.getText();
    }

    public String getOwnerText() {
        return ownerElement.getText();
    }

    public String getBankText() {
        return bankElement.getText();
    }

    public String getDateText() {
        return openDateElement.getText();
    }
}