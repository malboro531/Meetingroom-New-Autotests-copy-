package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONFIRMATION_PAYMENT_BY_BANK_DETAILS_TITLE;

@PageName(pageName = CONFIRMATION_PAYMENT_BY_BANK_DETAILS_TITLE)
public class ConfirmationPaymentByBankDetailsScreen extends BaseScreen {

    @Required
    @FindBy(id = "title_text_view")
    private WebElement paymentConfirmationTitle;

    @FindBy(id = "textViewTitle")
    private WebElement screenTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "header_from_account")
    private WebElement fromAccountHeader;

    @FindBy(id = "text_view_account_from")
    private WebElement fromAccountField;

    @FindBy(id = "header_amount")
    private WebElement amountHeader;

    @FindBy(id = "text_view_amount")
    private WebElement amountField;

    @FindBy(id = "header_payee")
    private WebElement payeeHeader;

    @FindBy(id = "text_view_payee")
    private WebElement payeeField;

    @FindBy(id = "header_taxpayer")
    private WebElement taxpayerHeader;

    @FindBy(id = "text_view_taxpayer")
    private WebElement taxpayerField;

    @FindBy(id = "header_account_number")
    private WebElement accountNumberHeader;

    @FindBy(id = "text_view_account_number")
    private WebElement accountNumberField;

    @FindBy(id = "header_bic")
    private WebElement bicHeader;

    @FindBy(id = "text_view_bic")
    private WebElement bicField;

    @FindBy(id = "header_swift_code")
    private WebElement swiftHeader;

    @FindBy(id = "text_view_swift_code")
    private WebElement swiftField;

    @FindBy(id = "header_name_of_bank")
    private WebElement bankNameHeader;

    @FindBy(id = "text_view_name_of_bank")
    private WebElement bankNameField;

    @FindBy(id = "pay_button")
    private WebElement payButton;

    public void tapToBackButton() {
        backButton.click();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public boolean isPayButtonEnabled() {
        return payButton.isEnabled();
    }

    public boolean isPaymentConfirmationTitleDisplayed() {
        return screenTitle.isDisplayed();
    }

    public boolean isFromAccountHeaderDisplayed() {
        return fromAccountHeader.isDisplayed();
    }

    public String getFromAccountText() {
        return fromAccountField.getText();
    }

    public boolean isAmountHeaderDisplayed() {
        return amountHeader.isDisplayed();
    }

    public String getAmountText() {
        return amountField.getText();
    }

    public boolean isPayeeHeaderDisplayed() {
        return payeeHeader.isDisplayed();
    }

    public String getPayeeText() {
        return payeeField.getText();
    }

    public boolean isTaxpayerHeaderDisplayed() {
        return taxpayerHeader.isDisplayed();
    }

    public String getTaxpayerText() {
        return taxpayerField.getText();
    }

    public boolean isAccountNumberDisplayed() {
        return accountNumberHeader.isDisplayed();
    }

    public String getAccountNumberText() {
        return accountNumberField.getText();
    }

    public boolean isBicDisplayed() {
        return bicHeader.isDisplayed();
    }

    public String getBicText() {
        return bicField.getText();
    }

    public boolean isSwiftDisplayed() {
        return swiftHeader.isDisplayed();
    }

    public String getSwiftText() {
        return swiftField.getText();
    }

    public boolean isBankNameDisplayed() {
        return bankNameHeader.isDisplayed();
    }

    public String getBankNameText() {
        return bankNameField.getText();
    }

    public void tapToPayButton() {
        payButton.click();
    }
}
