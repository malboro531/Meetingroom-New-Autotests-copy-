package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.TRANSFER_BY_PHONE_NUMBER_TITLE;

@PageName(pageName = TRANSFER_BY_PHONE_NUMBER_TITLE)
public class TransferByPhoneNumberScreen extends BaseScreen {

    @Required
    @FindBy(xpath = "//android.widget.LinearLayout[1]//android.widget.EditText")
    private WebElement fromAccountField;

    @FindBy(id = "account_item")
    private WebElement clickableAreaForAccountSelection;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    private WebElement phoneNumberField;

    @FindBy(id = "next_button")
    private WebElement continueButton;

    public void tapOnFromAccountField () {
        fromAccountField.click();
    }

    public void tapOnClickableAreaForAccountSelection() {
        clickableAreaForAccountSelection.click();
    }

    public void tapOnPhoneNumberField() {
        phoneNumberField.click();
    }

    public void enterPhoneToPhoneNumberField(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void tapToContinueButton() {
        continueButton.click();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }
}
