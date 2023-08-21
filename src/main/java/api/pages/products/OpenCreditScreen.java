package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.OPEN_CREDIT_TITLE;

@PageName(pageName = OPEN_CREDIT_TITLE)
public class OpenCreditScreen extends BaseScreen {
    @Required
    @FindBy(id = "mainFragment")
    private WebElement openCreditBaseElement;

    @FindBy(id = "gotItTextView")
    private WebElement gotItButton;

    @FindBy(id = "gotItTextView")
    private List<WebElement> gotItButtonList;

    @FindBy(id = "mainFragment")
    private WebElement mortgageButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\'Management\']")
    private WebElement managementButton;

    @FindBy(id = "mainFragment")
    private WebElement managementScreen;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Information\"]/android.widget.TextView")
    private WebElement informationButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement chooseCreditButton;

    public void tapOnGotItButton() {
        gotItButton.click();
    }

    public boolean isGotItButtonDisplayed() {
        return gotItButtonList.size() != 0;
    }

    public void tapOnMortgageButton() {
        mortgageButton.click();
    }

    public void onManagementButton() {
        managementButton.click();
    }

    public void onInformationButton() {
        informationButton.click();
    }

    public void onOpenChooseCreditButton() {
        chooseCreditButton.click();
    }
}
