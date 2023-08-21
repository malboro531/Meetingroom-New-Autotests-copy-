package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.USER_NOTIFICATIONS_TITLE;

@PageName(pageName = USER_NOTIFICATIONS_TITLE)
public class UserNotificationsScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement viewTitle;

    @FindBy(id = "imageViewMain")
    private WebElement arrowButton;

    @FindBy(id = "email_text_view")
    private WebElement emailTextView;

    @FindBy(id = "imageView_edit")
    private WebElement changeEmailButton;

    @FindBy(id = "sms_text_view")
    private WebElement smsTextView;

    @FindBy(id = "sms_switch")
    private WebElement smsSwitch;

    @FindBy(id = "notification_text_view")
    private WebElement pushNotificationsTextView;

    @FindBy(id = "push_switch")
    private WebElement pushSwitch;

    @FindBy(id = "notify_email_text_view")
    private WebElement notifyEmailTextView;

    @FindBy(id = "email_switch")
    private WebElement emailSwitch;

    public void tapChangeEmailButton() {
        changeEmailButton.click();
    }

    public void tapOnArrowButton() {
        arrowButton.click();
    }
}
