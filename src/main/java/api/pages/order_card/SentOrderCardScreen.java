package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.SENT_ORDER;

@PageName(pageName = SENT_ORDER)
public class SentOrderCardScreen extends BaseScreen {

    @Required
    @FindBy(id = "successImageView")
    private WebElement successImageView;

    @FindBy(id = "applicationSentTextView")
    private WebElement successSentMsgTextView;

    @FindBy(id = "infoTextView")
    private WebElement transferTextView;

    @FindBy(id = "primary_button")
    private WebElement backToMenuButton;
}
