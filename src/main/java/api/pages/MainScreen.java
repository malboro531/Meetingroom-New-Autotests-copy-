package api.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.MAIN_TITLE;

@PageName(pageName = MAIN_TITLE)
public class MainScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement mainScreenBaseElement;

    @FindBy(id = "imageViewMainClickableArea")
    private WebElement mainButton;

    @FindBy(id = "imageViewMain")
    private WebElement viewMain;

    @FindBy(id = "imageViewSettingsClickableArea")
    private WebElement settingsButton;

    @FindBy(id = "imageViewSettings")
    private WebElement viewSettings;

    @FindBy(id = "imageViewNotificationsClickableArea")
    private WebElement notificationsButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement viewNotifications;

    @FindBy(id = "card_item")
    private WebElement orderCardButton;

    @FindBy(id = "offersRecycler")
    private WebElement offersRecycler;

    @FindBy(xpath = "//android.view.ViewGroup[4]/android.widget.TextView")
    private WebElement transfersButton;

    @FindBy(xpath = "//android.widget.GridView[1]//android.view.ViewGroup[2]//*//android.widget.ImageView")
    private WebElement addTemplateButton;

    @FindBy(xpath = "//android.widget.GridView[2]//android.widget.TextView[@text='Home']")
    private WebElement homeButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement productsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Payments']")
    private WebElement paymentsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Transactions']")
    private WebElement transactionsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='More']")
    private WebElement moreButton;

    @FindBy(id = "imageViewMain")
    private WebElement imageViewMainButton;

    public void tapOnMainButton() {
        mainButton.click();
    }

    public void tapOnSettingsButton() {
        settingsButton.click();
    }

    public void tapOnNotificationsButton() {
        notificationsButton.click();
    }

    public void tapOnOrderCardButton() {
        orderCardButton.click();
    }

    public void tapOnProductsButton() {
        productsButton.click();
    }

    public void tapOnTransfersButton() {
        transfersButton.click();
    }

    public void tapOnAddTemplateButton() {
        addTemplateButton.click();
    }

    public void tapOnPaymentsButton() {
        paymentsButton.click();
    }

    public void tapOnImageViewMainButton() {
        imageViewMainButton.click();
    }

    public void tapOnMoreButton() {
        moreButton.click();
    }

    public boolean isMainScreenDisplayed() {
        return mainScreenBaseElement.isDisplayed();
    }

    public boolean isPaymentsButtonEnabled() {
        return paymentsButton.isEnabled();
    }
}
