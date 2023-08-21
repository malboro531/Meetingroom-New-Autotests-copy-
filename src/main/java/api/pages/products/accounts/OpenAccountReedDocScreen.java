package api.pages.products.accounts;

import api.pages.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountReedDocScreen extends BaseScreen {

    @FindBy(id = "primary_button")
    private WebElement confirmButton;

    public void tapOnConfirmButton() {
        confirmButton.click();
    }
}
