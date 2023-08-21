package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CURRENCY_EXCHANGE_TITLE;

@PageName(pageName = CURRENCY_EXCHANGE_TITLE)
public class CurrencyExchangeScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement currencyExchangeTitle;

    @Required
    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[1]")
    private WebElement currency;

    @Required
    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[2]")
    private WebElement buyField;

    @Required
    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[3]")
    private WebElement sellField;

    @FindBy(xpath = "//android.widget.FrameLayout[1]//androidx.appcompat.widget.LinearLayoutCompat")
    private WebElement eur;

    @FindBy(xpath = "//android.widget.FrameLayout[2]//androidx.appcompat.widget.LinearLayoutCompat")
    private WebElement usd;

    @FindBy(xpath = "//android.widget.FrameLayout[3]//androidx.appcompat.widget.LinearLayoutCompat")
    private WebElement byn;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    public boolean isEurDisplayed() {
        return eur.isDisplayed();
    }

    public boolean isUsdDisplayed() {
        return usd.isDisplayed();
    }

    public boolean isBynDisplayed() {
        return byn.isDisplayed();
    }

    public boolean isEurEnabled() {
        return eur.isEnabled();
    }

    public boolean isUsdEnabled() {
        return usd.isEnabled();
    }

    public boolean isBynEnabled() {
        return byn.isEnabled();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public String getCurrencyExchangeTitleText() {
        return currencyExchangeTitle.getText();
    }
}
