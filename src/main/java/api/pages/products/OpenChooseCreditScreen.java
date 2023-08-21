package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.OPEN_CHOOSE_CREDIT_TITLE;

@PageName(pageName = OPEN_CHOOSE_CREDIT_TITLE)
public class OpenChooseCreditScreen extends BaseScreen {

    @Required
    @FindBy(id = "recyclerCreditSelection")
    private WebElement chooseCreditScreen;
}
