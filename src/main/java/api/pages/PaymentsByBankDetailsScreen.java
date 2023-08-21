package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.PAYMENT_BY_BANK_DETAILS_TITLE;

@PageName(pageName = PAYMENT_BY_BANK_DETAILS_TITLE)
public class PaymentsByBankDetailsScreen extends BaseScreen {

    @Required
    @FindBy(xpath = "//android.widget.TextView[@text='Payment by bank details']")
    private WebElement paymentByBankDetailsTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='taxpayer identification number']")
    private WebElement taxpayerIdNumber;

    @FindBy(xpath = "//android.widget.TextView[@text='account number']")
    private WebElement accountNumber;

    @FindBy(xpath = "//android.widget.TextView[@text='Bank Identifier Code']")
    private WebElement bankIdCode;

    @FindBy(xpath = "//android.widget.TextView[@text='SWIFT Code']")
    private WebElement swiftCode;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "nextButton")
    private WebElement nextButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Name of bank']")
    private WebElement nameOfBank;

    @FindBy(xpath = "//android.widget.TextView[@text='Payee']")
    private WebElement payee;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/taxpayerEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement taxpayerIdNumberInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/accountNumberEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement accountNumberInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/bankIdentifierEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement bankIdCodeInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/swiftCodeEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement swiftCodeInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/nameOfBankEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement nameOfBankField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/payeeEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement payeeField;

    public boolean isPaymentByBankDetailsTitleDisplayed() {
        return paymentByBankDetailsTitle.isDisplayed();
    }

    public boolean isTaxpayerIdNumberDisplayed() {
        return taxpayerIdNumber.isDisplayed();
    }

    public boolean isAccountNumberDisplayed() {
        return accountNumber.isDisplayed();
    }

    public boolean isBankIdCodeDisplayed() {
        return bankIdCode.isDisplayed();
    }

    public boolean isSwiftCodeDisplayed() {
        return swiftCode.isDisplayed();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnNextButton() {
        nextButton.click();
    }

    public void enterTaxpayerIdNumber(String taxpayerNumber) {
        taxpayerIdNumberInputField.sendKeys(taxpayerNumber);
    }

    public void enterAccountNumber(String number) {
        accountNumberInputField.sendKeys(number);
    }

    public void enterBankIdCode(String code) {
        bankIdCodeInputField.sendKeys(code);
    }

    public void enterSwiftCode(String swift) {
        swiftCodeInputField.sendKeys(swift);
    }

    public boolean isBankNameDisplayed() {
        return nameOfBank.isDisplayed();
    }

    public boolean isPayeeDisplayed() {
        return payee.isDisplayed();
    }

    public String getSwiftText() {
        return swiftCodeInputField.getText();
    }

    public String getNameOfBankText() {
        return nameOfBankField.getText();
    }

    public String getPayeeText() {
        return payeeField.getText();
    }
}
