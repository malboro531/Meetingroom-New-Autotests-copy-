package steps;

import api.pages.PersonalCabinetScreen;
import io.qameta.allure.Step;
import verification.Verify;

import static constants.GlobalData.NEW_EMAIL;

public class PersonalCabinetStep {

    protected PersonalCabinetScreen personalCabinetScreen;

    @Step("On 'Personal Cabinet' screen")
    public void onUserPersonalCabinetScreen() {
        personalCabinetScreen = new PersonalCabinetScreen();
    }

    @Step("Verify 'Personal Cabinet' screen is open")
    public void verifyPersonalCabinetScreenIsOpened() {
        personalCabinetScreen.verifyPageIsOpened();
    }

    @Step("Tap user photo")
    public void tapUserPhoto() {
        personalCabinetScreen.tapUserPhoto();
    }

    @Step("Tap Back Arrow Button")
    public void tapBackArrowButton() {
        personalCabinetScreen.tapBackArrowButton();
    }

    @Step("Verify changed Email")
    public void isChangedEmailMatch() {
        Verify.verifyTrue(personalCabinetScreen.isChangedEmailMatch(NEW_EMAIL), "Changed Email is correct");
    }

    @Step("Tap Passport Details Button")
    public void tapPassportDetailsButton() {
        personalCabinetScreen.tapPassportDetailsButton();
    }

    @Step("Tap Registration Address Button")
    public void tapRegistrationAddressButton() {
        personalCabinetScreen.tapRegistrationAddressButton();
    }

    @Step("Tap delete account Button")
    public void tapDeleteAccountButton() {
        personalCabinetScreen.tapDeleteAccountButton();
    }

    @Step("Tap change password Button")
    public void tapChangePassword() {
        personalCabinetScreen.tapChangePassword();
    }
}