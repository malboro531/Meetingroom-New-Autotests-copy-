package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CARDS_TITLE;

@PageName(pageName = CARDS_TITLE)
public class CardsScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement cardScreenBaseElement;

    @FindBy(id = "imageViewNotifications")
    private WebElement plusButton;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private WebElement firstCardButton;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/descendant::android.widget.TextView[2]")
    private WebElement firstCardBalanceView;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    private WebElement secondCardButton;

    @FindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[2]")
    private WebElement secondCardBalanceView;

    public void tapOnPlusButton() {
        plusButton.click();
    }

    public void chooseFirstCard() {
        firstCardButton.click();
    }

    public double getCardBalance(WebElement cardBalanceView) {
        return Double.parseDouble(getCardBalanceText(cardBalanceView));
    }

    public String getCardBalanceText(WebElement cardBalanceView) {
        return cardBalanceView.getText().replaceAll("[^\\d.]", "");
    }

    public String getFirstCardBalanceText() {
        return getCardBalanceText(firstCardBalanceView);
    }

    public double getFirstCardBalance() {
        return getCardBalance(firstCardBalanceView);
    }

    public double getSecondCardBalance() {
        return getCardBalance(secondCardBalanceView);
    }
}
