package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CLOSE_CARD_SUCCESS_TITLE;

@PageName(pageName = CLOSE_CARD_SUCCESS_TITLE)
public class CloseCardSuccessScreen extends BaseScreen {

    @Required
    @FindBy(id = "successTextView")
    private WebElement resultTextField;

    @Required
    @FindBy(id = "primary_button")
    private WebElement primaryButton;

    public void tapOnPrimaryButton() {
        primaryButton.click();
    }

    public String getResultText() {
        return StringUtils.normalizeSpace(resultTextField.getText());
    }
}
