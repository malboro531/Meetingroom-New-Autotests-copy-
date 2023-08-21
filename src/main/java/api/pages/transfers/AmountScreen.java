package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.AMOUNT_TITLE;

@PageName(pageName = AMOUNT_TITLE)
public class AmountScreen extends BaseScreen {

    @Required
    @FindBy(id = "button_confirm")
    private WebElement confirmButton;

    @FindBy(id = "imageViewMain")
    private WebElement arrowButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement crossButton;

    @FindBy(id = "edit_text_amount")
    private WebElement amountField;

    @FindBy(id = "textinput_helper_text")
    private WebElement helperMessage;

    @FindBy(id = "textinput_error")
    private WebElement errorMessage;

    public void tapOnConfirmButton() {
        confirmButton.click();
    }

    public void tapOnArrowButton() {
        arrowButton.click();
    }

    public void tapOnCrossButton() {
        crossButton.click();
    }

    public void enterAmount(String amount) {
        amountField.sendKeys(amount);
    }

    public String getHelperMessageText() {
        return StringUtils.normalizeSpace(helperMessage.getText());
    }

    public String getErrorMessageText() {
        return StringUtils.normalizeSpace(errorMessage.getText());
    }

    public boolean isConfirmButtonEnabled() {
        return confirmButton.isEnabled();
    }
}
