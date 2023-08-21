package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CARD_DETAILS_TITLE;

@PageName(pageName = CARD_DETAILS_TITLE)
public class OwnCardDetailsScreen extends BaseScreen {

    @FindBy(id = "imageViewTransit")
    private WebElement transferButton;

    public void tapOnTransferButton() {
        transferButton.click();
    }
}
