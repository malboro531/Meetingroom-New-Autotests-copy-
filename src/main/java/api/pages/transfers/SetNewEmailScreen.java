package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.SET_NEW_EMAIL_TITLE;

@PageName(pageName = SET_NEW_EMAIL_TITLE)
public class SetNewEmailScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement textViewTitle;

    @Required
    @FindBy(id = "enterTextView")
    private WebElement enterTextView;

    @FindBy(id = "imageViewMain")
    private WebElement viewMain;

    @FindBy(id = "primaryButton")
    private WebElement primaryButton;

    @FindBy(id = "editText")
    private WebElement editTextField;

    public void enterNewEmail(String newEmail) {
        editTextField.sendKeys(newEmail);
    }

    public void enterOldEmail(String oldEmail) {
        editTextField.sendKeys(oldEmail);
    }

    public void tapPrimaryButton() {
        primaryButton.click();
    }
}
