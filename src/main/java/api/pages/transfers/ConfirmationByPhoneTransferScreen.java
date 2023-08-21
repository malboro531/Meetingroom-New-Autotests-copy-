package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_BY_PHONE_TRANSFER_TITLE;

@PageName(pageName = CONFIRMATION_BY_PHONE_TRANSFER_TITLE)
public class ConfirmationByPhoneTransferScreen extends BaseScreen {

    @Required
    @FindBy(id = "from_account")
    private WebElement fromAccountText;

    @FindBy(id = "to_phone_number")
    private WebElement phoneNumberText;

    @FindBy(id = "amount")
    private WebElement amountText;

    @FindBy(id = "transfer_assignment")
    private WebElement transferAssignmentText;

    @FindBy(id = "primary_button")
    private WebElement transferButton;

    public String getFromAccountText() {
        return fromAccountText.getText();
    }

    public String getPhoneNumberText() {
        return phoneNumberText.getText();
    }

    public String getAmountText() {
        return amountText.getText();
    }

    public String getTransferAssignmentText() {
        return transferAssignmentText.getText();
    }

    public void tapOnTransferButton() {
        transferButton.click();
    }
}
