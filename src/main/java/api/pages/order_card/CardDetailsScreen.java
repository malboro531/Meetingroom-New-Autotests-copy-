package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.CARD_DETAILS;

@PageName(pageName = CARD_DETAILS)
public class CardDetailsScreen extends BaseScreen {

    @Required
    @FindBy(id = "bottomButton")
    private WebElement orderCardButton;

    @FindBy(id = "imageViewMain")
    private WebElement returnButton;

    @FindBy(id = "constraintCard")
    private WebElement cardPicture;

    @FindBy(id = "textViewCardTitle")
    private WebElement textViewCardTitle;

    @FindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[2]")
    private WebElement advantagesTextView;

    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[2]")
    private WebElement partnerBanksTextView;

    @FindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[2]")
    private WebElement bonusProgramTextView;


    public void tapOrderCardButton() {
        orderCardButton.click();
    }

    public void tapReturnButton() {
        returnButton.click();
    }
}
