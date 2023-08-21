package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.SECOND_DOCUMENT;

//Todo пересмотреть в сторону DocumentScreen
@PageName(pageName = SECOND_DOCUMENT)
public class SecondDocumentScreen extends BaseScreen {
    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "imageViewDownload")
    private WebElement downloadButton;

    @FindBy(id = "primary_button")
    private WebElement confirmButton;

    public void tapReturnButton() {
        returnButton.click();
    }

    public void tapConfirmButton() {
        confirmButton.click();
    }
}