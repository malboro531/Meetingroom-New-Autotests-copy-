package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CHANGE_PASSWORD_TITLE;

@PageName(pageName = CHANGE_PASSWORD_TITLE)
public class ChangePasswordScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement changePasswordScreenBaseElement;

    @FindBy(id = "new_password_input")
    private WebElement enterNewPasswordField;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    private WebElement confirmNewPasswordField;

    @FindBy(id = "primaryButton")
    private WebElement changePasswordButton;

    @FindBy(id = "old_password_input")
    private WebElement enterOldPassword;

    @FindBy(id = "reply_new_password_input")
    private WebElement replayNewPasswordField;

    @FindBy(id = "confirm_new_pass_button")
    private WebElement confirmButton;

    @FindBy(id = "old_password_title")
    private WebElement oldPasswordTitle;

    @FindBy(id = "new_password_title")
    private WebElement newPasswordTitle;

    @FindBy(id = "reply_new_password_title")
    private WebElement getReplayNewPasswordField;

    public void tapOnEnterPasswordField() {
        enterNewPasswordField.click();
    }

    public String getOldPasswordTitleTextField() {
        return oldPasswordTitle.getText();
    }

    public String getNewPasswordTitleTextField() {
        return newPasswordTitle.getText();
    }

    public String getReplayNewPasswordTitleTextField() {
        return getReplayNewPasswordField.getText();
    }

    public boolean isDisplayedOldPassword() {
        return enterOldPassword.isDisplayed();
    }

    public boolean isDisplayedNewPassword() {
        return enterNewPasswordField.isDisplayed();
    }

    public boolean isDisplayedReplayNewPassword() {
        return replayNewPasswordField.isDisplayed();
    }

    public boolean isConfirmButtonEnabled() {
        return confirmButton.isEnabled();
    }
}