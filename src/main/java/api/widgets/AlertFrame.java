package api.widgets;

import api.pages.BaseScreen;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrame extends BaseScreen {

    @Required
    @FindBy(id = "alertTitle")
    private WebElement alertTitle;

    @FindBy(id = "android:id/message")
    private WebElement alertMessage;

    @FindBy(id = "android:id/button3")
    private WebElement cancelButton;

    @FindBy(id = "android:id/button1")
    private WebElement confirmButton;

    public String getAlertTitleText() {
        return alertTitle.getText();
    }

    public String getAlertMessageText() {
        return alertMessage.getText();
    }

    public void tapOnCancelButton() {
        cancelButton.click();
    }

    public void tapOnConfirmButton() {
        confirmButton.click();
    }
}
