package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.OPEN_CARD_TITLE;

@PageName(pageName = OPEN_CARD_TITLE)
public class OpenCardScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement openCardBaseElement;

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
