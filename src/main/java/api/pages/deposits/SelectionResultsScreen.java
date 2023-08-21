package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.SELECTION_RESULTS_TITLE;

@PageName(pageName = SELECTION_RESULTS_TITLE)
public class SelectionResultsScreen extends BaseScreen {

    @Required
    @FindBy(id = "deposit_product_recycler")
    private WebElement selectionResultsScreenBaseElement;

    @FindBy(id= "android:id/custom")
    private WebElement alertFrame;

    @FindBy(id= "okTextView")
    private WebElement alertFrameOkButton;

    @FindBy(id= "backTextView")
    private WebElement alertFrameBackButton;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "textViewTitle")
    private WebElement selectionResultsHeader;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[@index = 0]")
    private WebElement depositProductCards;

    @FindBy(id = "imageViewNotifications")
    private WebElement crossButton;

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnCrossButton() {
        crossButton.click();
    }

    public void tapOnAlertFrameOkButton() {
        alertFrameOkButton.click();
    }

    public void tapOnAlertFrameBackButton() {
        alertFrameBackButton.click();
    }

    public void tapOnDepositProductCards() {
        depositProductCards.click();
    }

    public boolean isAlertFrameDisplayed() {
        return alertFrame.isDisplayed();
    }

    public boolean isAlertFrameOkButtonDisplayed() {
        return alertFrameOkButton.isDisplayed();
    }

    public boolean isAlertFrameBackButtonDisplayed() {
        return alertFrameBackButton.isDisplayed();
    }

    public boolean isBackButtonDisplayed() {
        return backButton.isDisplayed();
    }

    public boolean isSelectionResultsHeaderDisplayed() {
        return selectionResultsHeader.isDisplayed();
    }

    public boolean isDepositProductCardsDisplayed() {
        return depositProductCards.isDisplayed();
    }

    public boolean isCrossButtonDisplayed() {
        return crossButton.isDisplayed();
    }
}
