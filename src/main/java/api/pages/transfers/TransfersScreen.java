package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.TRANSFERS_TITLE;

@PageName(pageName = TRANSFERS_TITLE)
public class TransfersScreen extends BaseScreen {

    @Required
    @FindBy(id = "connected_account_text")
    private WebElement transferToConnectedCardButton;

    @FindBy(id = "card_number_text")
    private WebElement transferByCardNumberButton;

    @FindBy(id ="phone_number_text")
    private WebElement transferByPhoneNumberButton;

    @FindBy(id = "account_number_text")
    private WebElement transferByAccountNumberButton;

    public void tapOnTransferToConnectedCardButton() {
        transferToConnectedCardButton.click();
    }

    public void tapOnTransferByCardNumberButton() {
        transferByCardNumberButton.click();
    }

    public void tapOnTransferByPhoneNumberButton() {
        transferByPhoneNumberButton.click();
    }

    public void tapOnTransferByAccountNumberButton() {
        transferByAccountNumberButton.click();
    }
}
