package api.pages;

import helpers.Swipe;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.NEW_AUTOPAY_TITLE;

@PageName(pageName = NEW_AUTOPAY_TITLE)
public class NewAutoPayAdditionalScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement newAutoPayTitleText;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "header_next_payment_date")
    private WebElement nextPaymentDateTitle;

    @FindBy(id = "header_frequency")
    private WebElement frequencyTitle;

    @FindBy(id = "layout_select_date")
    private WebElement selectDateField;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout//android.widget.TextView")
    private WebElement dateText;

    @FindBy(xpath = "//android.widget.NumberPicker[1]/android.widget.EditText")
    private WebElement monthForSwipeField;

    @FindBy(xpath = "//android.widget.TextView[@text='Select frequency']")
    private WebElement selectFrequencyField;

    @FindBy(id = "button_monthly")
    private WebElement monthlyButton;

    @FindBy(id = "next_button")
    private WebElement confirmButton;

    public String getNewAutoPayAdditionalTitleText() {
        return newAutoPayTitleText.getText();
    }

    public boolean isNextPaymentDateTitleDisplayed() {
        return nextPaymentDateTitle.isDisplayed();
    }

    public boolean isFrequencyTitleDisplayed() {
        return frequencyTitle.isDisplayed();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }
    public void tapOnSelectDateField() {
        selectDateField.click();
    }

    public void tapOnSelectFrequencyField() {
        selectFrequencyField.click();
    }

    public void tapOnMonthlyButton() {
        monthlyButton.click();
    }

    public boolean isConfirmButtonEnabled() {
        return confirmButton.isEnabled();
    }

    public void swipeMonthUp() {
        Swipe.swipeElementUp(monthForSwipeField);
    }

    public String getNextPaymentDateText() {
        return dateText.getText();
    }

    public String getFrequencyText() {
        return monthlyButton.getText();
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }
}
