package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_BY_ACCOUNT_TRANSFER_TITLE;

@PageName(pageName = CONFIRMATION_BY_ACCOUNT_TRANSFER_TITLE)
public class ConfirmationByAccountTransferScreen extends BaseScreen {

    @Required
    @FindBy(id = "from_account")
    private WebElement fromAccountField;

    @FindBy(id = "to_account")
    private WebElement toAccountField;

    @FindBy(id = "recipient")
    private WebElement recipientField;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "transfer_assignment")
    private WebElement assignmentField;

    @FindBy(id = "primary_button")
    private WebElement transferButton;

    public String getFromAccountText() {
        return fromAccountField.getText();
    }

    public String getToAccountText() {
        return toAccountField.getText();
    }

    public String getRecipient() {
        return recipientField.getText();
    }

    public String getAmountText() {
        return amountField.getText();
    }

    public String getAssignmentText() {
        return assignmentField.getText();
    }

    public void tapOnTransferButton() {
        transferButton.click();
    }
}
