package api.pages.demo;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.DEMO_TITLE;

@PageName(pageName = DEMO_TITLE)
public class DemoScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMain")
    private WebElement demoImageViewMain;

    public void tapOnImageViewMain() {
        demoImageViewMain.click();
    }
}
