package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.DataOrderCard.ORDER_ADDRESS_REGISTRATION;

@PageName(pageName = ORDER_ADDRESS_REGISTRATION)
public class PersonalDataRegistrationAdressScreen extends BaseScreen {

    @Required
    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "country_spinner_text")
    private WebElement countryTextEdit;

    @FindBy(id = "city_spinner_text")
    private WebElement cityTextEdit;

    @FindBy(id = "street_input_edit_text")
    private WebElement streetTextEdit;

    @FindBy(id = "house_input_edit_text")
    private WebElement houseTextEdit;

    @FindBy(id = "flat_input_edit_text")
    private WebElement flatTextEdit;

    @FindBy(id = "checkbox_with_text")
    private WebElement checkBox;

    @FindBy(id = "secondary_button")
    private WebElement dataIncorrectButton;

    @FindBy(id = "primary_button")
    private WebElement confirmButton;

    @FindBy(id = "okTextView")
    private WebElement popUpOkButton;

    @FindBy(id = "backTextView")
    private WebElement popUpBackButton;

    public void tapReturnButton() {
        returnButton.click();
    }

    public void tapPopUpBackButton() {
        popUpBackButton.click();
    }

    public void tapPopUpOkButton() {
        popUpOkButton.click();
    }

    public void enterCountryTextEdit() {
        countryTextEdit.sendKeys();
    }

    public void enterCityTextEdit() {
        cityTextEdit.sendKeys();
    }

    public void enterStreetTextEdit() {
        streetTextEdit.sendKeys();
    }

    public void enterHouseTextEdit() {
        houseTextEdit.sendKeys();
    }

    public void enterFlatTextEdit() {
        flatTextEdit.sendKeys();
    }

    public void tapCheckBox() {
        checkBox.click();
    }

    public void tapDataIncorrectButton() {
        dataIncorrectButton.click();
    }

    public void tapConfirmButton() {
        confirmButton.click();
    }
}
