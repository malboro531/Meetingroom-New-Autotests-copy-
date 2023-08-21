package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.FILTER_TITLE;

@PageName(pageName = FILTER_TITLE)
public class FilterScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement textViewTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    public void tapOnBackButton() {
        backButton.click();
    }

    public boolean isFilterScreenDisplayed() {
        return textViewTitle.isDisplayed();
    }
}
