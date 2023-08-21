package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.DETAILS_FOR_TRANSFER_BY_PHONE_NUMBER_TITLE;

@PageName(pageName = DETAILS_FOR_TRANSFER_BY_PHONE_NUMBER_TITLE)
public class DetailsForTransferByPhoneNumberScreen extends BaseScreen {

    @Required
    @FindBy(id = "edit_text_amount")
    private WebElement enterAmountField;

    @FindBy(id = "edit_text_assignment")
    private WebElement transferAssignmentField;

    @FindBy(id = "button_confirm")
    private WebElement confirmButton;

    public void tapOnEnterAmountField() {
        enterAmountField.click();
    }

    public void enterSumToEnterAmountField(String sum) {
        enterAmountField.sendKeys(sum);
    }

    public void tapOnTransferAssignmentField() {
        transferAssignmentField.click();
    }

    public void enterMessageToTransferAssignmentField(String message) {
        transferAssignmentField.sendKeys(message);
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }

    public boolean isConfirmButtonEnabled() {
        return confirmButton.isEnabled();
    }
}
