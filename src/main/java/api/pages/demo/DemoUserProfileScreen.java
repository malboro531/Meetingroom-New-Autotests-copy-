package api.pages.demo;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.DEMO_USER_PROFILE_TITLE;

@PageName(pageName = DEMO_USER_PROFILE_TITLE)
public class DemoUserProfileScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMain")
    private WebElement backImageViewMain;

    @Required
    @FindBy(id = "log_out")
    private WebElement logOutProfile;

    @Required
    @FindBy(id = "save_btn")
    private WebElement saveChangesBtn;
}
