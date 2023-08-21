package api.pages;

import helpers.Swipe;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.PROMO_TITLE;

@PageName(pageName = PROMO_TITLE)
public class PromoScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement promoScreenBaseElement;

    @FindBy(id = "cross_img")
    private WebElement crossImg;

    @FindBy(id = "button")
    private WebElement skipToDesignButton;

    @FindBy(xpath = "//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    private WebElement orderCard;

    @FindBy(id = "cardsRecycler")
    private WebElement personalCard;

    @FindBy(id = "card_date")
    private List<WebElement> cardDate;

    @FindBy(id="imageViewSettings")
    private WebElement settingsButton;

    public void tapOnCrossImg() {
        crossImg.click();
    }

    public void tapOnSkipToDesignButton() {
        skipToDesignButton.click();
    }

    public void tapOnOrderCard() {
        orderCard.click();
    }

    public void swipeToOrderCard() {
        while (!cardDate.isEmpty()) {
            Swipe.swipeElementToLeft(personalCard);
        }
        tapOnOrderCard();
    }
    public void tapOnSettingsButton(){
        settingsButton.click();
    }
}
