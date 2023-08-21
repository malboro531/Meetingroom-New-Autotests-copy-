package steps;

import api.pages.RegistrationAddressScreen;
import io.qameta.allure.Step;
import steps.transfers.CommonStep;
import verification.VerifySoft;

import static constants.PersonalDetails.*;

public class RegistrationAddressStep extends CommonStep {

    RegistrationAddressScreen registrationAddressScreen;

    @Step("On 'Registration address' screen")
    public void onRegistrationAddressScreen() {
        registrationAddressScreen = new RegistrationAddressScreen();
    }

    @Step("Verify 'Registration address' screen is open")
    public void verifyRegistrationAddressScreenIsOpen() {
        registrationAddressScreen.verifyPageIsOpened();
    }

    @Step("Tap Back Arrow Button")
    public void tapBackArrowButton() {
        registrationAddressScreen.tapBackArrowButton();
    }

    @Step("Verify Country field is displayed")
    public void verifyCountryFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isCountryFieldDisplayed(), "Field country is displayed");
    }

    @Step("Verify City field is displayed")
    public void verifyCityFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isCityFieldDisplayed(), "Field city is displayed");
    }

    @Step("Verify Street field is displayed")
    public void verifyStreetFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isStreetFieldDisplayed(), "Field street is displayed");
    }

    @Step("Verify House field is displayed")
    public void verifyHouseFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isHouseFieldDisplayed(), "Field house is displayed");
    }

    @Step("Verify Building field is displayed")
    public void verifyBuildingFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isBuildingFieldDisplayed(), "Field building is displayed");
    }

    @Step("Verify Flat field is displayed")
    public void verifyFlatFieldIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isFlatFieldDisplayed(), "Field flat is displayed");
    }

    @Step("Verify Country field is correct")
    public void verifyCountryFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getCountryFieldText(), COUNTRY, "Field country is correct");
    }

    @Step("Verify City field is correct")
    public void verifyCityFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getCityFieldText(), CITY, "Field city is correct");
    }

    @Step("Verify Street field is correct")
    public void verifyStreetFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getStreetFieldText(), STREET, "Field street is correct");
    }

    @Step("Verify House field is correct")
    public void verifyHouseFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getHouseFieldText(), HOUSE, "Field house is correct");
    }

    @Step("Verify Building field is correct")
    public void verifyBuildingFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getBuildingFieldText(), BUILDING, "Field building is correct");
    }

    @Step("Verify Flat field is correct")
    public void verifyFlatFieldIsCorrect() {
        VerifySoft.verifyEqualsSoft(registrationAddressScreen.getFlatFieldText(), FLAT, "Field flat is correct");
    }

    @Step("Verify 'My data is not correct' button is displayed")
    public void verifyMyDataIsNotCorrectButtonIsDisplayed() {
        VerifySoft.verifyTrueSoft(registrationAddressScreen.isMyDataIsNotCorrectButtonDisplayed(), "Button 'My data is not correct' is displayed");
    }
}