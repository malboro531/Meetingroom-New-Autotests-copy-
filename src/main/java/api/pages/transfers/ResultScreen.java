package api.pages.transfers;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.RESULT_TITLE;

@PageName(pageName = RESULT_TITLE)
public class ResultScreen extends BaseScreen {

    @Required
    @FindBy(id = "applicationSentTextView")
    private WebElement transferResultTextField;

    @FindBy(id = "back_button")
    private WebElement backToMainButton;

    public void tapToBackToMainMenuButton() {
        backToMainButton.click();
    }

    public boolean isBackToMainButtonEnabled() {
        return backToMainButton.isEnabled();
    }

    public String getTransferResultText() {
        return StringUtils.normalizeSpace(transferResultTextField.getText());
    }
}
