package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.PAYMENTS_TITLE;

@PageName(pageName = PAYMENTS_TITLE)
public class PaymentsScreen extends BaseScreen {

    @Required
    @FindBy(xpath = "//android.view.ViewGroup/*/android.widget.TextView")
    private WebElement paymentsTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Add template']")
    private WebElement addTemplateButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Add autopay']")
    private WebElement addAutoPay;

    @FindBy(xpath = "//android.widget.TextView[@text='Payment by bank details']")
    private WebElement paymentByBankDetailsField;

    @FindBy(xpath = "//android.widget.TextView[@text='Bank fees']")
    private WebElement bankFeesField;

    @FindBy(xpath = "//android.widget.TextView[@text='Templates']")
    private WebElement templatesField;

    @FindBy(xpath = "//android.widget.TextView[@text='Auto payments']")
    private WebElement autoPaymentsField;

    @FindBy(xpath = "//android.widget.TextView[@text='Credit payments']")
    private WebElement creditPaymentsField;

    @FindBy(xpath = "//android.widget.TextView[@text='Other']")
    private WebElement otherField;

    public boolean isAddTemplateEnabled() {
        return addTemplateButton.isEnabled();
    }

    public boolean isAddAutoPayEnabled() {
        return autoPaymentsField.isEnabled();
    }

    public boolean isPaymentByBankDetailsEnabled() {
        return paymentByBankDetailsField.isEnabled();
    }

    public boolean isBankFeesEnabled() {
        return bankFeesField.isEnabled();
    }

    public boolean isTemplatesEnabled() {
        return templatesField.isEnabled();
    }

    public boolean isAutoPaymentsEnabled() {
        return autoPaymentsField.isEnabled();
    }

    public boolean isCreditPaymentsEnabled() {
        return creditPaymentsField.isEnabled();
    }

    public boolean isOtherEnabled() {
        return otherField.isEnabled();
    }

    public String getPaymentsTitleText() {
        return paymentsTitle.getText();
    }

    public void tapOnPaymentByBankDetailsField() {
        paymentByBankDetailsField.click();
    }

    public void tapOnAutoPaymentsField() {
        autoPaymentsField.click();
    }
}
