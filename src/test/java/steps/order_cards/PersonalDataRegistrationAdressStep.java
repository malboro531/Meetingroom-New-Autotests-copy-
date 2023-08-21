package steps.order_cards;

import api.pages.order_card.PersonalDataRegistrationAdressScreen;
import io.qameta.allure.Step;

public class PersonalDataRegistrationAdressStep {
    protected PersonalDataRegistrationAdressScreen personalDataRegistrationAdressScreen;

    @Step("On PersonalDataRegistrationAdressScreen")
    public void onPersonalDataRegistrationAdressScreen() {
        personalDataRegistrationAdressScreen = new PersonalDataRegistrationAdressScreen();
    }

    @Step("Verify 'PersonalDataRegistrationAdressOpen' is open")
    public void verifyIsPersonalDataRegistrationAdressOpen() {
        personalDataRegistrationAdressScreen.verifyPageIsOpened();
    }

    @Step("Tap return button")
    public void tapReturnButton() {
        personalDataRegistrationAdressScreen.tapReturnButton();
    }

    @Step("Enter Country Field")
    public void enterCountryTextEdit() {
        personalDataRegistrationAdressScreen.enterCountryTextEdit();
    }

    @Step("Enter CityScreen Field")
    public void enterCityTextEdit() {
        personalDataRegistrationAdressScreen.enterCityTextEdit();
    }

    @Step("Enter Street Field")
    public void enterStreetTextEdit() {
        personalDataRegistrationAdressScreen.enterStreetTextEdit();
    }

    @Step("Enter House Field")
    public void enterHouseTextEdit() {
        personalDataRegistrationAdressScreen.enterHouseTextEdit();
    }

    @Step("Enter Flat Field")
    public void enterFlatTextEdit() {
        personalDataRegistrationAdressScreen.enterFlatTextEdit();
    }

    @Step("Set CheckBox")
    public void tapCheckBox() {
        personalDataRegistrationAdressScreen.tapCheckBox();
    }

    @Step("Tap Data Incorrect button")
    public void tapDataIncorrectButton() {
        personalDataRegistrationAdressScreen.tapDataIncorrectButton();
    }

    @Step("Tap Confirm button")
    public void tapConfirmButton() {
        personalDataRegistrationAdressScreen.tapConfirmButton();
    }

    @Step("PopUp Screen - Tap Back button")
    public void tapPopUpBackButton() {
        personalDataRegistrationAdressScreen.tapPopUpBackButton();
    }

    @Step("PopUp Screen - Tap Ok button")
    public void tapPopUpOkButton() {
        personalDataRegistrationAdressScreen.tapPopUpOkButton();
    }
}
