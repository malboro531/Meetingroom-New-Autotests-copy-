package api.pages.products;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.OPEN_INLAY_INFORMATION_TITLE;

@PageName(pageName = OPEN_INLAY_INFORMATION_TITLE)
public class OpenInlayInformationScreen extends BaseScreen {

    @Required
    @FindBy(id = "credit_viewPager")
    private WebElement informationScreen;
}
