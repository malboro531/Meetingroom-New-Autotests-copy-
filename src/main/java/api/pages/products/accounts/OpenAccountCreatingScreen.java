package api.pages.products.accounts;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.OPEN_ACCOUNT_CREATING_TITLE;

@PageName(pageName = OPEN_ACCOUNT_CREATING_TITLE)
public class OpenAccountCreatingScreen extends BaseScreen {

    @Required
    @FindBy(id = "currency")
    private WebElement checkBoxCurrency;

    @FindBy(id = "imageView_logo")
    private WebElement logoBank;

    @FindBy(id = "text_input_end_icon")
    private WebElement buttonCurrency;

    public void setCurrency(String currency) {
        checkBoxCurrency.sendKeys(currency);
    }

    public boolean isBankLogoDisplayed() {
        return logoBank.isDisplayed();
    }

    public boolean isCurrencyButtonDisplayed() {
        return buttonCurrency.isDisplayed();
    }

    public String getCurrentText() {
        return checkBoxCurrency.getText();
    }
}