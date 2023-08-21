package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.SELECT_ACCOUNT_TITLE;

@PageName(pageName = SELECT_ACCOUNT_TITLE)
public class SelectAccountScreen extends BaseScreen {

    @Required
    @FindBy(id = "action_bar_root")
    private WebElement selectAccountBaseElement;
}
