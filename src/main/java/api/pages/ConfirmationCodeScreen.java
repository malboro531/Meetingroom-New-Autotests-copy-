package api.pages;

import api.widgets.ErrorFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_CODE_TITLE;

@PageName(pageName = CONFIRMATION_CODE_TITLE)
public class ConfirmationCodeScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement confirmScreenBaseElement;

    @FindBy(id = "receiveToTextView")
    private WebElement chooseHowToReceiveConfirmationCodeLink;

    @FindBy(id = "forgotPasswordEditText")
    private WebElement forgotPasswordLink;

    @FindBy(id = "sendAgainTextView")
    private WebElement sendAgainButton;

    @FindBy(id = "confirmInputEditText")
    private WebElement confirmInputField;

    @FindBy(id = "expirationToTextView")
    private WebElement expirationTextView;

    @FindBy(id = "textinput_error")
    private WebElement errorTextView;

    @FindBy(id = "imageViewMain")
    private WebElement backIcon;

    @FindBy(id = "logInButton")
    private WebElement confirmButton;

    @FindBy(id = "primary_button")
    private WebElement confirmTransferButton;

    @FindBy(id = "android:id/content")
    private WebElement errorFrameElement;

    @FindBy(id = "android:id/custom")
    private ErrorFrame errorFrameElementFrame;

    @FindBy(id = "incorrectTextView")
    private WebElement incorrectTextViewElement;

    @FindBy(id = "changeMethodTextView")
    private WebElement changeMethodButton;

    @FindBy(id = "repeatLaterTextView")
    private WebElement repeatLaterButton;

    @FindBy(id = "sentToTextView")
    private WebElement email;

    public void tapOnSendAgain() {
        sendAgainButton.click();
    }

    public void tapOnChooseHowToReceiveConfirmationCodeLink() {
        chooseHowToReceiveConfirmationCodeLink.click();
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }

    public void tapOnConfirmTransferButton() {
        confirmTransferButton.click();
    }

    public void tapOnBackIcon() {
        backIcon.click();
    }

    public void enterConfirmationCodeToField(String confirmationCode) {
        confirmInputField.sendKeys(confirmationCode);
    }

    public void tapOnChangeMethodButton() {
        changeMethodButton.click();
    }

    public void tapOnRepeatLaterButton() {
        repeatLaterButton.click();
    }

    public String getConfirmationCode() {
        return confirmInputField.getText();
    }

    public String getExpirationCountdownText() {
        return expirationTextView.getText();
    }

    public void tapOnConfirmField() {
        confirmInputField.click();
    }

    public String getErrorText() {
        return errorTextView.getText();
    }

    public WebElement getExpirationTextView() {
        return expirationTextView;
    }

    public ErrorFrame getErrorFrame() {
        return new ErrorFrame(errorFrameElement);
    }

    public String getErrorTextTitle() {
        return incorrectTextViewElement.getText();
    }

    public boolean isChangeMethodButtonEnabled() {
        return changeMethodButton.isEnabled();
    }

    public boolean isRepeatLaterButtonEnabled() {
        return repeatLaterButton.isEnabled();
    }

    public boolean idEmailDisplayed() {
        return email.isDisplayed();
    }

    public boolean isConfirmInputFieldDisplayed() {
        return confirmInputField.isDisplayed();
    }

    public boolean isSendAgainButtonDisplayed() {
        return sendAgainButton.isDisplayed();
    }
}