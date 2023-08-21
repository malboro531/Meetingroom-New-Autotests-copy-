package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.GlobalData.OPEN_HOME_SETTINGS_TITLE;

@PageName(pageName = OPEN_HOME_SETTINGS_TITLE)
public class HomeSettingsScreen extends BaseScreen {

    @Required
    @FindBy(id = "settingsRecycler")
    private WebElement homeSettings;

    @FindBy(id = "textViewTitle")
    private WebElement viewTitle;
}
