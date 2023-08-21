package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import helpers.DropDownSelectorHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.CARD_PROCESSING;

@PageName(pageName = CARD_PROCESSING)
public class CardProcessingScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "step_status_line_horizontal")
    private WebElement stepStatusLine;

    @FindBy(id = "constraintCard")
    private WebElement cardPictureView;

    @FindBy(id = "paymentSystem")
    private WebElement paymentSystemDropDownList;

    @FindBy(id = "currency")
    private WebElement currencyDropDownList;

    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[1]")
    private WebElement paymentSystemDropDownListMenu;

    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[2]")
    private WebElement currencyDropDownListMenu;

    @FindBy(id = "primary_button")
    private WebElement continueButton;

    public void tapReturnButton() {
        returnButton.click();
    }

    public void tapContinueButton() {
        continueButton.click();
    }

    public void tapCurrencyDropDownListMenu() {
        currencyDropDownListMenu.click();
    }

    public void tapPaymentSystemDropDownListMenu() {
        paymentSystemDropDownListMenu.click();
    }

    public void chooseUSDCurrency() {
        DropDownSelectorHelper.chooseFirstElement(currencyDropDownListMenu);
    }

    public void chooseEUROCurrency() {
        DropDownSelectorHelper.chooseSecondElement(currencyDropDownListMenu);
    }

    public void chooseMasterCardPaymentSystem() {
        DropDownSelectorHelper.chooseFirstElement(paymentSystemDropDownListMenu);
    }

    public void chooseVisaPaymentSystem() {
        DropDownSelectorHelper.chooseSecondElement(paymentSystemDropDownListMenu);
    }
    //TODO steps check
}
