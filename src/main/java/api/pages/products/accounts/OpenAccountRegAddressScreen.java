package api.pages.products.accounts;

import api.pages.BaseScreen;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountRegAddressScreen extends BaseScreen {

    @Required
    @FindBy(id = "registration_address_title")
    private WebElement regAddressTitle;

    @FindBy(id = "secondary_button")
    private  WebElement myDataNotCorrectButton;

    public void tapOnMyDataNotCorrectButton() {
        myDataNotCorrectButton.click();
    }
}
