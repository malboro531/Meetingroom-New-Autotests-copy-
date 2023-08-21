package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.NEW_AUTOPAY_TITLE;

@PageName(pageName = NEW_AUTOPAY_TITLE)
public class NewAutoPayScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement newAutoPayTitleText;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Autopay name']")
    private WebElement autoPayNameTitle;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/autoPayNameEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement autoPayNameField;

    @FindBy(xpath = "//android.widget.TextView[@text='From card']")
    private WebElement fromCardTitle;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/fromCardEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement fromCardField;

    @FindBy(xpath = "//android.widget.TextView[@text='Enter amount']")
    private WebElement enterAmountTitle;

    @FindBy(id = "edit_text_amount")
    private WebElement enterAmountField;

    @FindBy(xpath = "//android.widget.TextView[@text='To card']")
    private WebElement toCardTitle;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.meetingroom_new_android:id/toCardEditText']//*[@resource-id='com.example.meetingroom_new_android:id/editText']")
    private WebElement toCardField;

    @FindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[3]")
    private WebElement fromCardClickableArea;

    @FindBy(id = "nextButton")
    private WebElement nextButton;

    public String getNewAutoPayTitleText() {
        return newAutoPayTitleText.getText();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public boolean isAutoPayNameTitleTextDisplayed() {
        return autoPayNameTitle.isDisplayed();
    }

    public boolean isFromCardTitleDisplayed() {
        return fromCardTitle.isDisplayed();
    }

    public boolean isEnterAmountTitleTextDisplayed() {
        return enterAmountTitle.isDisplayed();
    }

    public boolean isToCardTitleTextDisplayed() {
        return toCardTitle.isDisplayed();
    }

    public void enterAutoPayNameToField(String autoPayName) {
        autoPayNameField.sendKeys(autoPayName);
    }

    public void tapOnFromCardField() {
        fromCardField.click();
    }

    public void tapOnCardClickableArea() {
        fromCardClickableArea.click();
    }

    public void enterAmountToField(String amount) {
        enterAmountField.sendKeys(amount);
    }

    public void enterToCardToField(String toCard) {
        toCardField.sendKeys(toCard);
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public void tapOnNextButton() {
        nextButton.click();
    }
}
