package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.DELIVERY_METHOD;

@PageName(pageName = DELIVERY_METHOD)
public class DeliveryMethodScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "Courier")
    private WebElement courierTab;

    @FindBy(id = "Bank Branch")
    private WebElement bankTabTextEdit;

    @FindBy(id = "city_spinner_text")
    private WebElement cityTextEdit;

    @FindBy(id = "bank_branch_spinner_text")
    private WebElement bankTabBankTextEdit;

    @FindBy(id = "street_input_edit_text")
    private WebElement streetTextEdit;

    @FindBy(id = "house_input_edit_text")
    private WebElement houseTextEdit;

    @FindBy(id = "building_input_edit_text")
    private WebElement buildingTextEdit;

    @FindBy(id = "flat_input_edit_text")
    private WebElement flatTextEdit;

    @FindBy(id = "primary_button")
    private WebElement completeButton;

    public void tapReturnButton() {
        returnButton.click();
    }

    public void tapBranchTab() {
        bankTabTextEdit.click();
    }

    public boolean cityOnTabIsDisplayed() {
        return cityTextEdit.isDisplayed();
    }

    public boolean bankOnTabIsDisplayed() {
        return bankTabBankTextEdit.isDisplayed();
    }

}