package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import helpers.Swipe;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.GlobalData.PRODUCTS_TITLE;

@PageName(pageName = PRODUCTS_TITLE)
public class ProductsScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement productsScreenBaseElement;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Cards']")
    private WebElement cardsInlay;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Accounts']")
    private WebElement accountsInlay;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Credits']")
    private WebElement creditsInlay;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Deposits']")
    private WebElement depositsInlay;

    @FindBy(xpath = "//android.widget.GridView/descendant::android.widget.ImageView[1]")
    private WebElement homeButton;

    @FindBy(id = "card_item")
    private WebElement cardImageInlay;

    @FindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.ImageView")
    private WebElement crossButton;

    public void tapOnHomeButton() {
        homeButton.click();
    }

    public void tapOnCardsInlay() {
        cardsInlay.click();
    }

    public void tapOnAccountsInlay() {
        accountsInlay.click();
    }

    public void tapOnCreditsInlay() {
        creditsInlay.click();
    }

    public void tapOnDepositsInlay() {
        depositsInlay.click();
    }

    public boolean isDepositsInlaySelected() {
        return depositsInlay.isSelected();
    }

    public void tapOnCardImageInlay() {
        cardImageInlay.click();
    }

    public boolean isCreditsInlaySelected() {
        return creditsInlay.isSelected();
    }

    public boolean verifyCardsInlaySelected() {
        return cardsInlay.isSelected();
    }

    public void tapOnCrossButton() {
        crossButton.click();
    }

    public void swipeCardImageInlayToLeft() {
        Swipe.swipeElementToLeft(cardImageInlay);
    }

    public void swipeCardImageInlayToRight() {
        Swipe.swipeElementToRight(cardImageInlay);
    }
}
