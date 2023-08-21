package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.REGISTRATION_ADDRESS_TITLE;

@PageName(pageName = REGISTRATION_ADDRESS_TITLE)
public class RegistrationAddressScreen extends BaseScreen {

    @Required
    @FindBy(id = "registration_address_title")
    private WebElement registrationAddressTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backArrowButton;

    @FindBy(id = "country_spinner_text")
    private WebElement countryField;

    @FindBy(id = "city_spinner_text")
    private WebElement cityField;

    @FindBy(id = "street_input_edit_text")
    private WebElement streetField;

    @FindBy(id = "house_input_edit_text")
    private WebElement houseField;

    @FindBy(id = "building_input_edit_text")
    private WebElement buildingField;

    @FindBy(id = "flat_input_edit_text")
    private WebElement flatField;

    @FindBy(id = "secondary_button")
    private WebElement myDataIsNotCorrectButton;

    public boolean isCountryFieldDisplayed() {
        return countryField.isDisplayed();
    }

    public boolean isCityFieldDisplayed() {
        return cityField.isDisplayed();
    }

    public boolean isStreetFieldDisplayed() {
        return streetField.isDisplayed();
    }

    public boolean isHouseFieldDisplayed() {
        return houseField.isDisplayed();
    }

    public boolean isBuildingFieldDisplayed() {
        return buildingField.isDisplayed();
    }

    public boolean isFlatFieldDisplayed() {
        return flatField.isDisplayed();
    }

    public void tapBackArrowButton() {
        backArrowButton.click();
    }

    public boolean isMyDataIsNotCorrectButtonDisplayed() {
        return myDataIsNotCorrectButton.isDisplayed();
    }

    public String getCountryFieldText() {
        return countryField.getText();
    }

    public String getCityFieldText() {
        return cityField.getText();
    }

    public String getStreetFieldText() {
        return streetField.getText();
    }

    public String getHouseFieldText() {
        return houseField.getText();
    }

    public String getBuildingFieldText() {
        return buildingField.getText();
    }

    public String getFlatFieldText() {
        return flatField.getText();
    }
}