package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.OPEN_DEPOSIT_TITLE;

@PageName(pageName = OPEN_DEPOSIT_TITLE)
public class OpenDepositScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement openDepositBaseElement;

    @FindBy(id = "gotItTextView")
    private WebElement gotItButton;

    @FindBy(id = "gotItTextView")
    private List<WebElement> gotItButtonList;

    public void tapOnGotItButton() {
        gotItButton.click();
    }

    public boolean isGotItButtonDisplayed() {
        return gotItButtonList.size() != 0;
    }
}
