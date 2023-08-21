package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.TRANSFER_BY_CARD_NUMBER_TITLE;

@PageName(pageName = TRANSFER_BY_CARD_NUMBER_TITLE)
public class TransferByCardNumberScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMain")
    private WebElement arrowButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement crossButton;

    @FindBy(id = "next_button")
    private WebElement nextButton;

    @FindBy(id = "cancel_button")
    private WebElement cancelButton;

    @FindBy(id = "ok_button")
    private WebElement okButton;

    @FindBy(id = "button_confirm")
    private WebElement confirmButton;

    @FindBy(id = "edit_text_amount")
    private WebElement amountField;

    @FindBy(id = "description_textview")
    private WebElement descriptionCancelMoneyTransfer;

    @FindBy(id = "textinput_error")
    private WebElement errorMessage;

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.LinearLayout[1]//android.widget.EditText")
    private WebElement fromCardField;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    private WebElement toCardField;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]//android.widget.TextView[4]")
    private WebElement firstCardButton;

    @FindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[4]")
    private WebElement secondCardButton;

    @FindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[4]")
    private List<WebElement> secondCardButtonList;

    @FindBy(xpath = "//android.widget.LinearLayout[2]/*//android.widget.ImageView")
    private WebElement toCardFieldCrossButton;

    public void tapOnArrowButton() {
        arrowButton.click();
    }

    public void tapOnCrossButton() {
        crossButton.click();
    }

    public void tapOnCancelButton() {
        cancelButton.click();
    }

    public void tapOnNextButton() {
        nextButton.click();
    }

    public void tapOnOkButton() {
        okButton.click();
    }

    public void tapOnFromCardField() {
        fromCardField.click();
    }

    public void tapOnToCardField() {
        toCardField.click();
    }

    public void tapOnFirstCardButton() {
        firstCardButton.click();
    }

    public void tapOnSecondCardButton() {
        secondCardButton.click();
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }

    public void enterCardNumber(String cardNumber) {
        toCardField.sendKeys(cardNumber);
    }

    public void enterAmount(String amount) {
        amountField.sendKeys(amount);
    }

    public void tapOnToCardFieldCrossButton() {
        toCardFieldCrossButton.click();
    }

    public boolean okButtonIsDisplayed() {
        return okButton.isDisplayed();
    }

    public boolean cancelButtonIsDisplayed() {
        return cancelButton.isDisplayed();
    }

    public boolean secondCardButtonIsDisplayed() {
        return secondCardButtonList.size() != 0;
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public String descriptionCancelMoneyTransferGetText() {
        return StringUtils.normalizeSpace(descriptionCancelMoneyTransfer.getText());
    }

    public String getErrorMessage() {
        return StringUtils.normalizeSpace(errorMessage.getText());
    }

    public String getToCardFieldText() {
        return StringUtils.normalizeSpace(toCardField.getText());
    }

    public String getFromCardFieldText() {
        return StringUtils.normalizeSpace(fromCardField.getText());
    }
}
