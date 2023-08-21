package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.USER_PROFILE_TITLE;

@PageName(pageName = USER_PROFILE_TITLE)
public class UserProfileScreen extends BaseScreen {

    @Required
    @FindBy(id = "user_name")
    private WebElement userProfile;

    @FindBy(id = "user_notification")
    private WebElement userNotifications;

    @FindBy(id = "exit_icon")
    private WebElement exitIcon;

    @FindBy(id = "user_safety")
    private WebElement userSafety;

    @FindBy(id = "app_settings")
    private WebElement userAppSettings;

    @FindBy(id = "contacts")
    private WebElement userContacts;

    @FindBy(id = "atms")
    private WebElement userATMs;

    @FindBy(id = "user_profile")
    private WebElement userProfileImage;

    public void tapExitIcon() {
        exitIcon.click();
    }

    public void tapUserSafety() {
        userSafety.click();
    }

    public void tapUserProfileImageButton() {
        userProfile.click();
    }

    public void tapNotificationsButton() {
        userNotifications.click();
    }
}
