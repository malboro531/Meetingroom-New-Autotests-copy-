package api.pages.products.accounts;

import api.pages.BaseScreen;
import api.pages.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.COMMON_PAGE;

@PageName(pageName = COMMON_PAGE)
public class CommonScreen extends BaseScreen {
    @FindBy(id = "primary_button")
    private WebElement nextButton;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "android:id/button3")
    private WebElement cancelButton;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "parentPanel")
    private WebElement parentPanel;

    @FindBy(id = "imageViewNotifications")
    private WebElement closeButton;

    public void tapOnNextButton() {
        nextButton.click();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnCancelButton() {
        cancelButton.click();
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isDisplayed();
    }

    public boolean isParentPanelDisplayed() {
        return parentPanel.isDisplayed();
    }

    public boolean isOkButtonEnabled() {
        return okButton.isEnabled();
    }

    public boolean isCancelButtonEnabled() {
        return cancelButton.isEnabled();
    }

    public void tapOnOkButton() {
        okButton.click();
    }

    public void tapOnCloseButton() {
        closeButton.click();
    }
}