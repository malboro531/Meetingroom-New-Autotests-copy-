package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.BANK_BRANCHES_TITLE;

@PageName(pageName = BANK_BRANCHES_TITLE)
public class BankBranchesScreen extends BaseScreen{

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement bankBranchesTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    public String getTitleText() {
        return bankBranchesTitle.getText();
    }

    public void tapToBackButton() {
        backButton.click();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isDisplayed();
    }
}
