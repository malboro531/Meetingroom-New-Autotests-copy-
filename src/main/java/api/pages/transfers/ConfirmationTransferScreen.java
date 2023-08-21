package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_TRANSFER_TITLE;

@PageName(pageName = CONFIRMATION_TRANSFER_TITLE)
public class ConfirmationTransferScreen extends BaseScreen {

    @Required
    @FindBy(id = "amount_text")
    private WebElement amountTextField;

    @FindBy(id = "destination_card_text")
    private WebElement destinationCardTextField;

    @FindBy(id = "source_card_text")
    private WebElement sourceCardTextField;

    @FindBy(id = "transfer_button")
    private WebElement transferButton;

    public void tapOnTransferButton() {
        transferButton.click();
    }

    public String getAmountText() {
        return StringUtils.normalizeSpace(amountTextField.getText());
    }

    public String getDestinationCardText() {
        return destinationCardTextField.getText()
                .replaceAll(" ", "");
    }

    public String getSourceCardText() {
        return sourceCardTextField.getText().replaceAll(" ", "");
    }
}
