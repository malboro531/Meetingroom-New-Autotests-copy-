package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.DEPOSITS_TITLE;

@PageName(pageName = DEPOSITS_TITLE)
public class DepositsScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement depositScreenBaseElement;

    @FindBy(id = "imageViewNotifications")
    private WebElement plusButton;

    @FindBy(id = "deposit_item")
    private List<WebElement> depositList;

    @FindBy(id = "imageViewAdditional")
    private WebElement filterButton;

    @FindBy(id = "empty_tv")
    private WebElement emptyDepositPage;

    @FindBy(id = "search_button")
    private WebElement searchButton;

    @FindBy(id = "deposit_item")
    private WebElement depositProduct;

    public void tapOnFirstDeposit() {
        depositList.get(0).click();
    }

    public boolean isDepositListDisplayed() {
        return depositList.size() != 0;
    }

    public boolean isPlusButtonDisplayed() {
        return plusButton.isDisplayed();
    }

    public boolean isFilterButtonDisplayed() {
        return filterButton.isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }

    public String getTextFromEmptyDepositPage() {
        return StringUtils.normalizeSpace(emptyDepositPage.getText());
    }

    public void tapOnPlusButton() {
        plusButton.click();
    }

    public void tapOnFilterButton() {
        filterButton.click();
    }
}
