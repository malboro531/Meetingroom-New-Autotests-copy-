package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.ORDER_CONFIRMATION;

@PageName(pageName = ORDER_CONFIRMATION)
public class OrderConfirmationScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "receiveToTextView")
    private WebElement chooseRecieveMethodButton;

    @FindBy(id = "confirmInputEditText")
    private WebElement codeTextEdit;

    @FindBy(id = "forgotPasswordEditText")
    private WebElement forgotPasswordButton;

    @FindBy(id = "primary_button")
    private WebElement continueButton;

    public void enterConfirmationCodeToField(String confirmationCode) {
        codeTextEdit.sendKeys(confirmationCode);
    }

    public void tapContinueButton() {
        codeTextEdit.click();
    }
}
