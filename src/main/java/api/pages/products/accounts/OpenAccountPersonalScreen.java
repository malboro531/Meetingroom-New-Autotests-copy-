package api.pages.products.accounts;

import api.pages.BaseScreen;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPersonalScreen extends BaseScreen {

    @Required
    @FindBy(id = "personal_data_title")
    private WebElement personalDataTitle;

    @FindBy(id = "secondary_button")
    private  WebElement myDataNotCorrectButton;

    public void tapOnMyDataNotCorrectButton() {
        myDataNotCorrectButton.click();
    }
}
