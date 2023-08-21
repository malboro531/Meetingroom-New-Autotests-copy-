package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.LOGIN_TITLE;

@PageName(pageName = LOGIN_TITLE)
public class LoginScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement loginScreenBaseElement;

    @FindBy(xpath = "//android.widget.LinearLayout[1]//android.widget.EditText")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "forgotPasswordEditText")
    private WebElement forgotPasswordLink;

    @FindBy(id = "text_input_end_icon")
    private WebElement eyeImageView;

    @FindBy(id = "imageViewMain")
    private WebElement backIcon;

    @FindBy(id = "logInButton")
    private WebElement logInButton;

    @FindBy(id = "textinput_error")
    private WebElement errorTextSingle;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    private WebElement errorTextUnderLoginField;

    @FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    private WebElement errorTextUnderPasswordField;

    @FindBy(id = "incorrectTextView")
    private WebElement invalidPopUp;

    @FindBy(id = "numberTextView")
    private WebElement hotlinePhoneElement;

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getErrorMessageUnderLoginField() {
        return errorTextUnderLoginField.getText();
    }

    public String getErrorMessageUnderPasswordField() {
        return errorTextUnderPasswordField.getText();
    }

    public String getErrorMessageByInput() {
        return errorTextSingle.getText();
    }

    public String getInvalidPopUp() {
        return invalidPopUp.getText();
    }

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public void tapOnLoginField() {
        loginField.click();
    }

    public void tapOnEyeImageView() {
        eyeImageView.click();
    }

    public void tapOnBackIcon() {
        backIcon.click();
    }

    public void tapOnHotlinePhone() {
        hotlinePhoneElement.click();
    }

    public void tapOnLogInButton() {
        logInButton.click();
    }

    public void tapOnForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}
