package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

import static constants.DataOrderCard.MAIN_ORDER_CARD_TITLE;

@PageName(pageName = MAIN_ORDER_CARD_TITLE)
public class MainOrderCardScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement mainScreenOrderCardElement;

    @FindBy(id = "imageViewMainClickableArea")
    private WebElement mainBackButton;

    @FindBy(id = "textViewTitle")
    private WebElement textViewTitleBackButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\'Debit\']/android.widget.TextView")
    private WebElement debitButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\'Credit\']/android.widget.TextView")
    private WebElement creditButton;

    @FindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private WebElement firstDebitCard;

    @FindBy(id = "recyclerDebit")
    private WebElement recyclerDebitArea;

    @FindBy(id = "recyclerCredit")
    private WebElement recyclerCreditArea;

    @FindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private List<WebElement> randomDebitCard;

    public void tapMainBackButton() {
        mainBackButton.click();
    }

    public void tapDebitButton() {
        debitButton.click();
    }

    public void tapCreditButton() {
        creditButton.click();
    }

    public void tapRecyclerDebit() {
        recyclerDebitArea.click();
    }

    public void tapRecyclerCredit() {
        recyclerCreditArea.click();
    }

    public boolean isDebitButtonSelected() {
        return debitButton.isSelected();
    }

    public boolean isCreditButtonSelected() {
        return creditButton.isSelected();
    }

    public void tapOnFirstDebitCard() {
        firstDebitCard.click();
    }

    public void tapOnRandomDebitCard() {
        Random random = new Random();
        WebElement randomCard = randomDebitCard.get(random.nextInt(randomDebitCard.size()));
        randomCard.click();
    }
}
