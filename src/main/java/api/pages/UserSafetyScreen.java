package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.USER_PROFILE_SAFETY_TITLE;

@PageName(pageName = USER_PROFILE_SAFETY_TITLE)
public class UserSafetyScreen extends BaseScreen {

    @Required
    @FindBy(id = "set_application_password")
    private WebElement setApplicationPasswordButton;

    public void tapSetApplicationPasswordButton() {
        setApplicationPasswordButton.click();
    }
}
