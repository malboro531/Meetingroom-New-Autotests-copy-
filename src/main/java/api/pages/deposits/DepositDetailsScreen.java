package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.DEPOSIT_DETAILS_TITLE;

@PageName(pageName = DEPOSIT_DETAILS_TITLE)
public class DepositDetailsScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement depositDetailsScreenBaseElement;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    public void tapOnBackButton() {
        backButton.click();
    }
}
