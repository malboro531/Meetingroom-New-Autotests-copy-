package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.PAYMENT_BY_BANK_DETAILS_ENTER_AMOUNT_TITLE;

@PageName(pageName = PAYMENT_BY_BANK_DETAILS_ENTER_AMOUNT_TITLE)
public class PaymentByBankDetailsEnterAmountScreen extends BaseScreen {

    @FindBy(id = "editTextTitle")
    private WebElement fromAccount;

    @FindBy(id = "text_enter_amount")
    private WebElement enterAmount;

    @FindBy(id = "editText")
    private WebElement fromAccountField;

    @FindBy(id = "edit_text_amount")
    private WebElement enterAmountField;

    @FindBy(xpath = "//android.widget.TextView[@text='The payment is carried out within the bank']")
    private WebElement messageElement;

    @FindBy(id = "next_button")
    private WebElement confirmButton;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "accountName")
    private WebElement accountNameElement;

    @FindBy(id = "accountNumber")
    private WebElement accountNumberElement;

    public boolean isConfirmButtonEnabled() {
        return confirmButton.isEnabled();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public void tapOnSelectAccount() {
        fromAccountField.click();
    }

    public void tapOnEnterAmountField() {
        enterAmountField.click();
    }

    public void enterAmount(String amount) {
        enterAmountField.sendKeys(amount);
    }

    public boolean isFromAccountDisplayed() {
        return fromAccount.isDisplayed();
    }

    public boolean isEnterAmountDisplayed() {
        return enterAmount.isDisplayed();
    }

    public String getMessageText() {
        return messageElement.getText();
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnAccountName() {
        accountNameElement.click();
    }

    public String getAccountNumberText() {
        return accountNumberElement.getText();
    }
}
