package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.ENTER_APPLICATION_PASSWORD_TITLE;

@PageName(pageName = ENTER_APPLICATION_PASSWORD_TITLE)
public class EnterApplicationPasswordScreen extends BaseScreen {

    @Required
    @FindBy(id = "number_1")
    private WebElement number1;

    @FindBy(id = "number_2")
    private WebElement number2;

    @FindBy(id = "number_3")
    private WebElement number3;

    @FindBy(id = "number_4")
    private WebElement number4;

    @FindBy(id = "number_5")
    private WebElement number5;

    @FindBy(id = "number_6")
    private WebElement number6;

    @FindBy(id = "number_7")
    private WebElement number7;

    @FindBy(id = "number_8")
    private WebElement number8;

    @FindBy(id = "number_9")
    private WebElement number9;

    @FindBy(id = "number_0")
    private WebElement number0;

    @FindBy(id = "number_back")
    private WebElement numberBack;

    @FindBy(id = "number_ok")
    private WebElement numberOk;

    @FindBy(id = "snackbar_action")
    private WebElement confirmPassword;

    @FindBy(id = "incorrectTextView")
    private WebElement alertTheWrongPinCodeFiveTimes;

    @FindBy(id = "ok_button")
    private WebElement alertWrongPinCodeOkButton;

    public void tapNumber1() {
        number1.click();
    }

    public void tapNumber2() {
        number2.click();
    }

    public void tapNumber3() {
        number3.click();
    }

    public void tapNumber4() {
        number4.click();
    }

    public void tapNumber5() {
        number5.click();
    }

    public void tapNumber6() {
        number6.click();
    }

    public void tapNumber7() {
        number7.click();
    }

    public void tapNumber8() {
        number8.click();
    }

    public void tapNumber9() {
        number9.click();
    }

    public void tapNumber0() {
        number0.click();
    }

    public void tapNumberBack() {
        numberBack.click();
    }

    public void tapNumberOk() {
        numberOk.click();
    }

    public void tapConfirmPassword() {
        confirmPassword.click();
    }

    public boolean isAlertTheWrongPinCodeFiveTimesDisplayed() {
        return alertTheWrongPinCodeFiveTimes.isDisplayed();
    }

    public void tapAlertWrongPinCodeOkButton() {
        alertWrongPinCodeOkButton.click();
    }
}
