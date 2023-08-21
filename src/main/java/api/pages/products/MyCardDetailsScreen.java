package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CARD_DETAILS_TITLE;

@PageName(pageName = CARD_DETAILS_TITLE)
public class MyCardDetailsScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement titleCardDetails;

    @Required
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Details\"]")
    private WebElement tabDetails;

    @Required
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Manage\"]")
    private WebElement tabManage;

    @Required
    @FindBy(id = "tittle_account_number")
    private WebElement accountNumberText;

    @Required
    @FindBy(id = "tittle_card_number")
    private WebElement cardNumber;

    @Required
    @FindBy(id = "tittle_owner_name")
    private WebElement ownerNameText;

    @Required
    @FindBy(id = "tittle_expiry_date")
    private WebElement expiryDate;

    @Required
    @FindBy(id = "tittle_contact_number")
    private WebElement contactNumber;

    @Required
    @FindBy(id = "tittle_product")
    private WebElement product;

    @Required
    @FindBy(id = "tittle_status")
    private WebElement status;

    @Required
    @FindBy(id = "tittle_tariff")
    private WebElement tariff;

    @Required
    @FindBy(id = "status")
    private WebElement cardStatus;

    public void tapOnTabManage() {
        tabManage.click();
    }

    public void tapOnTabDetails() {
        tabDetails.click();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public String getCardStatusText() {
        return cardStatus.getText();
    }
}
