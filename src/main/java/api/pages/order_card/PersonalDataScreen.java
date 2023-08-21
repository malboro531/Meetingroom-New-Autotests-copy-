package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.PERSONAL_DATA;

@PageName(pageName = PERSONAL_DATA)
public class PersonalDataScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "step_status_line_horizontal")
    private WebElement stepStatusLine;

    //TODO @FindBy(id = "personal data")
    //TODO private WebElement personal data;

    @FindBy(id = "primary_button")
    private WebElement continueButton;

    public void tapContinueButton() {
        continueButton.click();
    }

    public void tapReturnButton() {
        returnButton.click();
    }
}
