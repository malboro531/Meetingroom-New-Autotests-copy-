package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.ACCOUNT_CREATED;

@PageName(pageName = ACCOUNT_CREATED)
public class AccountCreatedScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement mainFragment;

    @FindBy(id = "secondary_button")
    private WebElement backButton;

    @FindBy(id = "primary_button")
    private WebElement createNewCard;

    public boolean isBackButtonDisplayed() {
        return backButton.isDisplayed();
    }

    public boolean isCreateNewCardDisplayed() {
        return createNewCard.isDisplayed();
    }

    public void tupOnBackButton() {
        backButton.click();
    }

    public void tupOnCreateNewCardButton() {
        createNewCard.click();
    }
}
