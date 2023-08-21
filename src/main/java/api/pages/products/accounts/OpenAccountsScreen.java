package api.pages.products.accounts;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.OPEN_ACCOUNTS_TITLE;

@PageName(pageName = OPEN_ACCOUNTS_TITLE)
public class OpenAccountsScreen extends BaseScreen {

    @FindBy(id = "imageViewNotifications")
    private WebElement addAccountButton;

    @Required
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Accounts\"]")
    private WebElement accountButton;

    public void tapOnAddAccountButton() {
        addAccountButton.click();
    }
}
