package api.pages;

import element.RadioButtonElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_CODE_OPTIONS_TITLE;

@PageName(pageName = CONFIRMATION_CODE_OPTIONS_TITLE)
public class ConfirmationCodeOptionsScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement confirmationCodeOptionsScreenBaseElement;

    @FindBy(id = "smsRadioButton")
    private WebElement smsRadioButton;

    @FindBy(id = "pushRadioButton")
    private WebElement pushRadioButton;

    @FindBy(id = "emailRadioButton")
    private WebElement emailRadioButton;

    @FindBy(id = "confirmButton")
    private WebElement proceedButton;

    @FindBy(id = "imageViewMain")
    private WebElement backIcon;

    @FindBy(id = "smsTextView")
    private WebElement smsTextView;

    @FindBy(id = "emailTextView")
    private WebElement emailTextView;

    public void tapOnBackIcon() {
        backIcon.click();
    }

    public void tapOnProceedButton() {
        proceedButton.click();
    }

    public void tapOnSmsRadioButton() {
        smsRadioButton.click();
    }

    public void tapOnPushRadioButton() {
        pushRadioButton.click();
    }

    public void tapOnEmailRadioButton() {
        emailRadioButton.click();
    }

    public boolean isSmsRadioButtonChecked() {
        return new RadioButtonElement(smsRadioButton).isChecked();
    }

    public boolean isSmsRadioButtonNotChecked() {
        if (!smsRadioButton.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isPushRadioButtonChecked() {
        return new RadioButtonElement(pushRadioButton).isChecked();
    }

    public boolean isPushRadioButtonNotChecked() {
        return !pushRadioButton.isEnabled();
    }

    public boolean isEmailRadioButtonChecked() {
        return new RadioButtonElement(emailRadioButton).isChecked();
    }

    public boolean isProceedButtonEnabled() {
        return proceedButton.isEnabled();
    }

    public boolean isBackIconEnabled() {
        return backIcon.isEnabled();
    }
}
