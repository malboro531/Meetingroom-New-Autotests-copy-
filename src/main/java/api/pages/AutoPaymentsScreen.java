package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.AUTO_PAYMENTS_TITLE;

@PageName(pageName = AUTO_PAYMENTS_TITLE)
public class AutoPaymentsScreen extends BaseScreen {

    @Required
    @FindBy(xpath = "//android.widget.TextView[@text='Auto payments']")
    private WebElement autoPaymentsTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "imageViewCircle")
    private WebElement addAutoPayButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Add autopay']")
    private WebElement addAutoPayButtonTitle;

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public boolean isAddAutoPaymentButtonEnabled() {
        return addAutoPayButton.isEnabled();
    }

    public String getAutoPaymentsTitleText() {
        return autoPaymentsTitle.getText();
    }

    public String getAddAutoPayButtonText() {
        return addAutoPayButtonTitle.getText();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnAddAutoPayButton() {
        addAutoPayButton.click();
    }
}
