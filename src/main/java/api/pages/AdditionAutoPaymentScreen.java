package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.ADDITION_AUTO_PAYMENT_TITLE;

@PageName(pageName = ADDITION_AUTO_PAYMENT_TITLE)
public class AdditionAutoPaymentScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement additionAutoPaymentTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Transfer from card to card']")
    private WebElement transferFromCardToCardButton;

    public String getAdditionAutoPaymentTitleText() {
        return additionAutoPaymentTitle.getText();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public void tapOnTransferFromCardToCardButton() {
        transferFromCardToCardButton.click();
    }
}
