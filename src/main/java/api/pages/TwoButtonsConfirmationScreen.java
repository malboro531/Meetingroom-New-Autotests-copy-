package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CHANGE_PROFILE_PHOTO_ALERT;

@PageName(pageName = CHANGE_PROFILE_PHOTO_ALERT)
public class TwoButtonsConfirmationScreen extends BaseScreen {

    @Required
    @FindBy(id = "alertTitle")
    private WebElement titleConfirmationScreen;

    @FindBy(id = "android:id/button3")
    private WebElement rejectButton;

    @FindBy(id = "android:id/button1")
    private WebElement applyButton;

    public boolean isrejectButtonDisplayed() {
        return rejectButton.isDisplayed();
    }

    public boolean isApplyButtonDisplayed() {
        return applyButton.isDisplayed();
    }

    public void tapRejectBackButton() {
        rejectButton.click();
    }
}
