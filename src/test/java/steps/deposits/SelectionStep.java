package steps.deposits;

import api.pages.deposits.SelectionScreen;
import io.qameta.allure.Step;

import static verification.Verify.*;
import static verification.Verify.verifyEquals;

public class SelectionStep {

    protected SelectionScreen selectionScreen;

    @Step("On SelectionScreen")
    public void onSelectionScreen() {
        selectionScreen = new SelectionScreen();
    }

    @Step("Verify Selection Screen is open")
    public void verifySelectionScreenIsOpen() {
        selectionScreen.verifyPageIsOpened();
    }

    @Step("Verify 'Deposit amount' is displayed")
    public void verifyDepositAmountIsDisplayed() {
        verifyTrue(selectionScreen.isDepositAmountDisplayed(), "Deposit amount is displayed");
    }

    @Step("Verify 'Currency' is displayed")
    public void verifyCurrencyIsDisplayed() {
        verifyTrue(selectionScreen.isCurrencyDisplayed(), "Currency is displayed");
    }

    @Step("Verify 'Period Amount' is displayed")
    public void verifyPeriodAmountIsDisplayed() {
        verifyTrue(selectionScreen.isPeriodAmountDisplayed(), "Period Amount is displayed");
    }

    @Step("Verify 'Back Button' is displayed")
    public void verifyBackButtonIsDisplayed() {
        verifyTrue(selectionScreen.isBackButtonDisplayed(), "Back Button is displayed");
    }

    @Step("Verify 'Deposit Amount Slider' is displayed")
    public void verifyDepositAmountSliderIsDisplayed() {
        verifyTrue(selectionScreen.isDepositAmountSliderDisplayed(), "Deposit Amount Slider is displayed");
    }

    @Step("Verify Deposit Amount value not equals")
    public void verifyDepositAmountValueNotEquals(String value) {
        verifyNotEquals(selectionScreen.getDepositAmountValue(),
                value, "Deposit Amount value not equals");
    }

    @Step("Verify Deposit Amount value equals")
    public void verifyDepositAmountValueEquals(String value) {
        verifyEquals(selectionScreen.getDepositAmountValue(),
                value, "Deposit Amount value equals");
    }

    @Step("Verify Period Months value not equals")
    public void verifyPeriodMonthsValueNotEquals(String value) {
        verifyNotEquals(selectionScreen.getPeriodMonthsValue(),
                value, "Period Months value not equals");
    }

    @Step("Verify Period Months value equals")
    public void verifyPeriodMonthsValueEquals(String value) {
        verifyEquals(selectionScreen.getPeriodMonthsValue(),
                value, "Period Months value equals");
    }

    public String getDepositAmountValue() {
        return selectionScreen.getDepositAmountValue();
    }

    public String getPeriodMonthsValue() {
        return selectionScreen.getPeriodMonthsValue();
    }

    @Step("Choose RUB Currency")
    public void chooseRubCurrency() {
        selectionScreen.chooseRubCurrency();
    }

    @Step("Choose USD Currency")
    public void chooseUsdCurrency() {
        selectionScreen.chooseUsdCurrency();
    }

    @Step("Choose EUR Currency")
    public void chooseEurCurrency() {
        selectionScreen.chooseEurCurrency();
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        selectionScreen.tapOnBackButton();
    }

    @Step("Tap on currency dropdown")
    public void tapOnCurrencyDropdown() {
        selectionScreen.tapOnCurrencyDropdown();
    }

    @Step("Tap on 'Deposits' button")
    public void tapOnDepositsButton() {
        selectionScreen.tapOnDepositsButton();
    }

    @Step("Tap on 'Saving account' button")
    public void tapOnSavingAccountButton() {
        selectionScreen.tapOnSavingAccountButton();
    }

    @Step("Tap on 'Choose' button")
    public void tapOnChooseButton() {
        selectionScreen.tapOnChooseButton();
    }

    @Step("Verify 'Choose Button' is displayed")
    public void verifyChooseButtonIsDisplayed() {
        verifyTrue(selectionScreen.isChooseButtonDisplayed(), "Choose Button is displayed");
    }

    @Step("Enter value in deposit slider bar")
    public void enterValueDepositAmountSlideBar(String amount) {
        selectionScreen.enterValueInDepositAmountSlideBar(amount);
    }

    @Step("Enter value in Period months slider bar")
    public void enterValueInPeriodMonthSlideBar(String amount) {
        selectionScreen.enterValueInPeriodMonthsSlideBar(amount);
    }

    @Step("Clean value in Deposit Amount Bar")
    public void cleanDepositAmountBar() {
        selectionScreen.cleanDepositAmountBar();
    }

    @Step("Clean value in Period months Bar")
    public void cleanPeriodMonthsBar() {
        selectionScreen.cleanPeriodMonthsBar();
    }

    @Step("Check Text Input Error")
    public void checkTextInputError() {
        selectionScreen.checkTextInputError();
    }

    @Step("Moving the period slider bar")
    public void enterValueInPeriodMonthsSlideBar(String amount) {
        selectionScreen.enterValueInPeriodMonthsSlideBar(amount);
    }

    @Step("Verify segment 'Deposits' is Open")
    public void verifyDepositsSegmentIsOpen() {
        verifyTrue(selectionScreen.isDepositsButtonSelected(), "Segment 'Deposits' is open");
    }

    @Step("Verify segment 'Saving account' is Open")
    public void verifySavingAccountSegmentIsOpen() {
        verifyTrue(selectionScreen.isSavingAccountButtonSelected(), "Segment 'Saving Account' is open");
    }

    @Step("Verify if Value in the line 'Deposit amount' changes correctly")
    public void verifyDepositAmountValueChangesCorrectly(String amount) {
        verifyTrue(selectionScreen.isDepositAmountChangesCorrectly(amount),
                "Value in the 'Deposit amount' changes correctly");
    }

    @Step("Verify if Value in the line 'Period' changes correctly")
    public void verifyPeriodValueChangesCorrectly(String value) {
        verifyTrue(selectionScreen.isAmountCorrect(value),
                "Value in the 'Period' changes correctly");
    }

    @Step("Verify if Value in the line 'Currency' changes correctly")
    public void verifyCurrencyValueChangesCorrectly(String currency) {
        verifyTrue(selectionScreen.isCorrectCurrencyChosen(currency),
                "Chosen currency displays in the window");
    }

    @Step("Verify if Earlier chosen parameters are saved")
    public void verifyEarlierChosenParametersSaved(String amount, String value) {
        verifyTrue(selectionScreen.isDepositAmountChangesCorrectly(amount),
                "Value in the 'Deposit amount' changes correctly");
        verifyTrue(selectionScreen.isAmountCorrect(value),
                "Value in the 'Period' changes correctly");
    }

    @Step("Swipe Deposit Amount Slider Button to the right")
    public void swipeDepositAmountSliderToRight() {
        selectionScreen.swipeDepositAmountSliderToRight();
    }

    @Step("Swipe Deposit Amount Slider Button to the left")
    public void swipeDepositAmountSliderToLeft() {
        selectionScreen.swipeDepositAmountSliderToLeft();
    }
    @Step("Swipe Deposit Amount Slider Button to the max right")
    public void swipeDepositAmountSliderToMaxRight() {
        selectionScreen.swipeDepositAmountSliderToMaxRight();
    }

    @Step("Swipe Period months Slider Button to the right")
    public void swipePeriodMonthsSliderToRight() {
        selectionScreen.swipePeriodMonthsSliderToRight();
    }

    @Step("Swipe Period months Slider Button to the left")
    public void swipePeriodMonthsSliderToLeft() {
        selectionScreen.swipePeriodMonthsSliderToLeft();
    }

    @Step("Swipe Period months Slider Button to the max right")
    public void swipePeriodMonthsSliderToMaxRight() {
        selectionScreen.swipePeriodMonthsSliderToMaxRight();
    }
}
