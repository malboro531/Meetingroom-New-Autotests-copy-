package api.pages.products.accounts;

import api.pages.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountCreateMenuScreen extends BaseScreen {

    @FindBy(id = "primary_button")
    private WebElement nextButton;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement cancelButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement closeButton;

    @FindBy(id = "parentPanel")
    private WebElement windowsCancelAccountSelection;

    @FindBy(id = "android:id/button3")
    private WebElement buttonCancel;

    @FindBy(id = "android:id/button1")
    private WebElement buttonOK;

    @FindBy(id = "imageViewNotifications")
    private WebElement Cancelbutton;

    @FindBy(id = "parentPanel")
    private List<WebElement> popUpList;

    public void tapButtonOK() {
        buttonOK.click();
    }

    public void tapCloseButton() {
        closeButton.click();
    }

    public boolean displayedCancelAccountSelection() {
        return windowsCancelAccountSelection.isDisplayed();
    }

    public boolean displayedOK() {
        return buttonOK.isDisplayed();
    }

    public boolean displayedCancel() {
        return buttonCancel.isDisplayed();
    }

    public boolean popUpIsNotDisplayed() {
        return popUpList.size() != 0;
    }

    public void tapNextButton() {
        nextButton.click();
    }

    public void tapBackButton() {
        backButton.click();
    }

    public void tapCancelButton() {
        cancelButton.click();
    }
}
