package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.TRANSFER_BY_ACCOUNT_NUMBER_TITLE;

@PageName(pageName = TRANSFER_BY_ACCOUNT_NUMBER_TITLE)
public class TransferByAccountNumberScreen extends BaseScreen {

    @Required
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/*")
    private WebElement fromAccountField;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    private WebElement toAccountField;

    @FindBy(id = "next_button")
    private WebElement nextButton;

    @FindBy(id = "accountNumber")
    private WebElement clickableAreaForAccountSelection;

    @FindBy(id = "recipients_name")
    private WebElement recipientsName;

    public void tapToFromAccountField() {
        fromAccountField.click();
    }

    public void tapToToAccountField() {
        toAccountField.click();
    }

    public void enterAccountToToAccountField(String toAccount) {
        toAccountField.sendKeys(toAccount);
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public void tapOnClickableAreaForAccountSelection() {
        clickableAreaForAccountSelection.click();
    }

    public void tapToNextButton() {
        nextButton.click();
    }

    public String getFromAccountText() {
        return clickableAreaForAccountSelection.getText();
    }

    public String getRecipientsName() {
        return recipientsName.getText();
    }
}
