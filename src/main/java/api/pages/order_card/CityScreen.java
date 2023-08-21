package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CityScreen extends BaseScreen {
    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    public void tapReturnButton() {
        returnButton.click();
    }
}
