package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.TRANSFERS_TO_CONNECTED_CARD_TITLE;

@PageName(pageName = TRANSFERS_TO_CONNECTED_CARD_TITLE)
public class TransfersToConnectedCardScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMain")
    private WebElement arrowButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement crossButton;

    @FindBy(id = "next_button")
    private WebElement continueButton;

    @FindBy(id = "cancel_button")
    private WebElement cancelButton;

    @FindBy(id = "ok_button")
    private WebElement okButton;

    @FindBy(id = "description_textview")
    private WebElement descriptionCancelMoneyTransfer;

    @FindBy(xpath = "//android.view.ViewGroup/descendant::android.widget.EditText[1]")
    private WebElement fromCardField;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    private WebElement toCardField;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/descendant::android.widget.TextView[4]")
    private WebElement firstCardButton;

    @FindBy(xpath = "//android.view.ViewGroup[2]//android.widget.ImageView")
    private WebElement secondCardButton;

    public void tapOnArrowButton() {
        arrowButton.click();
    }

    public void tapOnCrossButton() {
        crossButton.click();
    }

    public void tapOnCancelButton() {
        cancelButton.click();
    }

    public void tapOnContinueButton() {
        continueButton.click();
    }

    public void tapOnOkButton() {
        okButton.click();
    }

    public void tapOnFromCardField() {
        fromCardField.click();
    }

    public void tapOnToCardField() {
        toCardField.click();
    }

    public void tapOnFirstCardButton() {
        firstCardButton.click();
    }

    public void tapOnSecondCardButton() {
        secondCardButton.click();
    }

    public boolean okButtonIsDisplayed() {
        return okButton.isDisplayed();
    }

    public boolean cancelButtonIsDisplayed() {
        return cancelButton.isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public boolean isCrossButtonEnabled() {
        return crossButton.isEnabled();
    }

    public boolean isArrowButtonEnabled() {
        return arrowButton.isEnabled();
    }

    public String descriptionCancelMoneyTransferIsDisplayed() {
        return StringUtils.normalizeSpace(descriptionCancelMoneyTransfer.getText());
    }

    public String getToCardFieldText() {
        return StringUtils.normalizeSpace(toCardField.getText());
    }

    public String getFromCardFieldText() {
        return StringUtils.normalizeSpace(fromCardField.getText());
    }
}
