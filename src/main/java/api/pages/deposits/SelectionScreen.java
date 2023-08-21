package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static constants.GlobalData.SELECTION_TITLE;
import static helpers.Swipe.*;

@PageName(pageName = SELECTION_TITLE)
public class SelectionScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement selectionScreenBaseElement;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Saving account']")
    private WebElement savingAccountButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Deposits']")
    private WebElement depositsButton;

    @FindBy(id = "deposit_amount_slider")
    private WebElement depositAmountSlider;

    @FindBy(id = "period_slider")
    private WebElement periodSlider;

    @FindBy(xpath = "//android.widget.SeekBar[@resource-id='com.example.meetingroom_new_android:id/" +
            "deposit_amount_slider']/android.widget.SeekBar")
    private WebElement depositAmountSliderButton;

    @FindBy(xpath = "//android.widget.SeekBar[@resource-id='com.example.meetingroom_new_android:id/" +
            "period_slider']/android.widget.SeekBar")
    private WebElement periodSliderButton;

    @FindBy(id = "deposit_amount")
    private WebElement depositAmount;

    @FindBy(id = "period_value")
    private WebElement periodMonths;

    @FindBy(id = "android:id/text1")
    private WebElement currencyDropdown;

    @FindBy(id = "button_next")
    private WebElement chooseButton;

    @FindBy(id = "textinput_error")
    private WebElement textInputError;

    @FindBy(xpath = "//android.widget.TextView[@text = 'RUB']")
    private WebElement chooseRub;

    @FindBy(xpath = "//android.widget.TextView[@text = 'USD']")
    private WebElement chooseUsd;

    @FindBy(xpath = "//android.widget.TextView[@text = 'EUR']")
    private WebElement chooseEur;

    public void chooseRubCurrency() {
        chooseRub.click();
    }

    public void chooseUsdCurrency() {
        chooseUsd.click();
    }

    public void chooseEurCurrency() {
        chooseEur.click();
    }

    public void enterValueInDepositAmountSlideBar(String amount) {
        depositAmount.sendKeys(amount);
    }

    public void cleanDepositAmountBar() {
        depositAmount.clear();
    }

    public void cleanPeriodMonthsBar() {
        periodMonths.clear();
    }

    public void checkTextInputError() {
        textInputError.isDisplayed();
    }

    public void enterValueInPeriodMonthsSlideBar(String amount) {
        periodMonths.sendKeys(amount);
    }

    public boolean isCorrectCurrencyChosen(String currency) {
        return Objects.equals(currency, currencyDropdown.getText());
    }

    public boolean isDepositAmountChangesCorrectly(String amount) {
        return Objects.equals(amount, depositAmount.getText());
    }

    public boolean isAmountCorrect(String amount) {
        return Objects.equals(amount, periodMonths.getText().replaceAll("\\D", ""));
    }

    public void tapOnCurrencyDropdown() {
        currencyDropdown.click();
    }

    public void tapOnChooseButton() {
        chooseButton.click();
    }

    public boolean isChooseButtonDisplayed() {
        return chooseButton.isDisplayed();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnDepositsButton() {
        depositsButton.click();
    }

    public void tapOnSavingAccountButton() {
        savingAccountButton.click();
    }

    public boolean isDepositsButtonSelected() {
        return depositsButton.isSelected();
    }

    public boolean isDepositAmountDisplayed() {
        return depositAmount.isDisplayed();
    }

    public boolean isCurrencyDisplayed() {
        return currencyDropdown.isDisplayed();
    }

    public boolean isPeriodAmountDisplayed() {
        return periodMonths.isDisplayed();
    }

    public boolean isBackButtonDisplayed() {
        return backButton.isDisplayed();
    }

    public boolean isDepositAmountSliderDisplayed() {
        return depositAmountSliderButton.isDisplayed();
    }

    public String getDepositAmountValue() {
        return depositAmount.getText();
    }

    public String getPeriodMonthsValue() {
        return periodMonths.getText();
    }

    public boolean isSavingAccountButtonSelected() {
        return savingAccountButton.isSelected();
    }

    public void swipeDepositAmountSliderToRight() {
        swipeElementToElementRight(depositAmountSliderButton, depositAmountSlider);
    }

    public void swipeDepositAmountSliderToLeft() {
        swipeElementToElementLeft(depositAmountSliderButton, depositAmountSlider);
    }

    public void swipeDepositAmountSliderToMaxRight() {
        swipeElementToElementMaxRight(depositAmountSliderButton);
    }

    public void swipePeriodMonthsSliderToRight() {
        swipeElementToElementRight(periodSliderButton, periodSlider);
    }

    public void swipePeriodMonthsSliderToLeft() {
        swipeElementToElementLeft(periodSliderButton, periodSlider);
    }

    public void swipePeriodMonthsSliderToMaxRight() {
        swipeElementToElementMaxRight(periodSliderButton);
    }
}
