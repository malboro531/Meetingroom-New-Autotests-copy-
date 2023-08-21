package api.pages.deposits;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.DEPOSIT_DESCRIPTION_TITLE;

@PageName(pageName = DEPOSIT_DESCRIPTION_TITLE)
public class DepositDescriptionsScreen extends BaseScreen {

    @Required
    @FindBy(id = "action_bar_root")
    private WebElement depositDescriptionsBaseElement;

    @FindBy(id = "textViewTitle")
    private WebElement depositDescriptionTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    @FindBy(id = "imageViewNotifications")
    private WebElement crossButton;

    @FindBy(id = "text_view_name_deposit_title")
    private WebElement depositName;

    @FindBy(id = "text_view_description_deposit_title")
    private WebElement depositDescription;

    @FindBy(id = "text_view_conditions_deposit_title")
    private WebElement depositConditions;

    @FindBy(id = "button_back_to_selection")
    private WebElement backToSelection;

    @FindBy(id = "button_next")
    private WebElement nextButton;

    public boolean isBackButtonDisplayed() {
        return backButton.isDisplayed();
    }

    public boolean isCrossButtonDisplayed() {
        return crossButton.isDisplayed();
    }

    public boolean isDepositDescriptionTitleDisplayed() {
        return depositDescriptionTitle.isDisplayed();
    }

    public boolean isDepositNameDisplayed() {
        return depositName.isDisplayed();
    }

    public boolean isDepositDescriptionDisplayed() {
        return depositDescription.isDisplayed();
    }

    public boolean isDepositConditionsDisplayed() {
        return depositConditions.isDisplayed();
    }

    public boolean isBackToSelectionButtonDisplayed() {
        return backToSelection.isDisplayed();
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isDisplayed();
    }

    public void tapOnBackButton() {
        backButton.click();
    }

    public void tapOnNextButton() {
        nextButton.click();
    }

    public void tapOnBackToSelectionButton() {
        backToSelection.click();
    }
}
