package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CARD_MANAGE_TITLE;

@PageName(pageName = CARD_MANAGE_TITLE)
public class MyCardManageScreen extends BaseScreen {

    @FindBy(id = "tv_transfer")
    private WebElement transferText;

    @FindBy(id = "tv_main_account_card")
    private WebElement accountCard;

    @FindBy(id = "tv_reissue")
    private WebElement reissueCard;

    @Required
    @FindBy(id = "tv_block_card")
    private WebElement blockCard;

    @FindBy(id = "tv_close_card")
    private WebElement closeCard;

    @FindBy(id = "switch_block_card")
    private WebElement blockCardSwitch;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Details\"]/*")
    private WebElement detailsTab;

    public void tapOnBlockCardSwitch() {
        blockCardSwitch.click();
    }

    public void tapOnDetailsTab() {
        detailsTab.click();
    }

    public void tapOnCloseCard() {
        closeCard.click();
    }
}
