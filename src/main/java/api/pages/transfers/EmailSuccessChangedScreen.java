package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.EMAIL_SUCCESS_CHANGED_TITLE;

@PageName(pageName = EMAIL_SUCCESS_CHANGED_TITLE)
public class EmailSuccessChangedScreen extends BaseScreen {

    @Required
    @FindBy(id = "image_checkmark")
    WebElement checkmark;

    @FindBy(id = "button_confirm")
    WebElement buttonConfirm;

    public void tapConfirmButton() {
        buttonConfirm.click();
    }
}
