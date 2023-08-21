package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.AUTOPAY_DETAILS_TITLE;

@PageName(pageName = AUTOPAY_DETAILS_TITLE)
public class AutoPayDetailsScreen extends BaseScreen {

    @FindBy(id = "textViewTitle")
    private WebElement autoPayDetailsTitleText;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @Required
    @FindBy(id = "title_text_view")
    private WebElement autoPayName;

    @FindBy(id = "header_from_card")
    private WebElement fromCardTitle;

    @FindBy(id = "header_amount")
    private WebElement amountTitle;

    @FindBy(id = "text_view_amount")
    private WebElement amountElement;

    @FindBy(id = "header_to_card")
    private WebElement toCardTitle;

    @FindBy(id = "text_view_card_to")
    private WebElement toCardElement;

    @FindBy(id = "header_name_of_bank")
    private WebElement nameOfBankTitle;

    @FindBy(id = "header_next_payment_date")
    private WebElement nextPaymentDateTitle;

    @FindBy(id = "text_view_next_payment_date")
    private WebElement nextPaymentDateElement;

    @FindBy(id = "header_frequency_payment")
    private WebElement frequencyTitle;

    @FindBy(id = "text_frequency_payment")
    private WebElement frequencyElement;

    @FindBy(id = "button_add_autopay")
    private WebElement addAutoPayButton;

    public String getAutoPayDetailsTitleText() {
        return autoPayDetailsTitleText.getText();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public String getAutoPayName() {
        return autoPayName.getText();
    }

    public boolean isFromCardTitleDisplayed() {
        return fromCardTitle.isDisplayed();
    }

    public boolean isAmountTitleDisplayed() {
        return amountTitle.isDisplayed();
    }

    public String getAmountText() {
        return amountElement.getText();
    }

    public boolean isToCardTitleDisplayed() {
        return toCardTitle.isDisplayed();
    }

    public String getToCardText() {
        return toCardElement.getText();
    }

    public boolean isBankNameDisplayed() {
        return nameOfBankTitle.isDisplayed();
    }

    public boolean isNextPaymentDateDisplayed() {
        return nextPaymentDateTitle.isDisplayed();
    }

    public String getNextPaymentDateText() {
        return nextPaymentDateElement.getText();
    }

    public boolean isFrequencyTitleDisplayed() {
        return frequencyTitle.isDisplayed();
    }

    public String getFrequencyText() {
        return frequencyElement.getText();
    }

    public void tapOnAddPaymentButton() {
        addAutoPayButton.click();
    }
}
