package steps;

import api.pages.PassportDetailsScreen;
import io.qameta.allure.Step;
import steps.transfers.CommonStep;
import verification.VerifySoft;

import static constants.PersonalDetails.*;

public class PassportDetailsScreenStep extends CommonStep {

    protected PassportDetailsScreen passportDetailsScreen;

    @Step("On 'Passport details' screen")
    public void onPassportDetailsScreen() {
        passportDetailsScreen = new PassportDetailsScreen();
    }

    @Step("Verify 'Passport details' screen is open")
    public void verifyPassportDetailsScreenIsOpened() {
        passportDetailsScreen.verifyPageIsOpened();
    }

    @Step("Tap Back Arrow Button")
    public void tapBackArrowButton() {
        passportDetailsScreen.tapBackArrowButton();
    }

    @Step("Element 'My data is not correct' is displayed")
    public void verifyMyDataIsNoCorrectButtonIsDisplayed() {
        VerifySoft.verifyTrueSoft(passportDetailsScreen.isMyDataIsNoCorrectButtonDisplayed(), "Element 'My data is not correct' is displayed");
    }

    @Step("Verify 'Given name' is correct")
    public void verifyGivenNameIsCorrect(String givenName) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getGivenNameText(), givenName, "Given name is correct");
    }

    @Step("Verify 'Surname' is correct")
    public void verifySurnameIsCorrect(String surname) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getSurnameText(), surname, "Surname is correct");
    }

    @Step("Verify 'Date of birth' is correct")
    public void verifyDateOfBirthIsCorrect(String dateOfBirth) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getDateOfBirthText(), dateOfBirth, "Date of birth is correct");
    }

    @Step ("Verify 'Passport series' is correct")
    public void verifyPassportSeriesIsCorrect(String passportSeries) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getPassportSeriesText(), passportSeries, "Passport series is correct");
    }

    @Step("Verify 'Passport number' is correct")
    public void verifyPassportNumberIsCorrect(String passportNumber) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getPassportNumberText(), passportNumber, "Passport number is correct");
    }

    @Step("Verify 'Authority' is correct")
    public void verifyAuthorityIsCorrect(String authority) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getIssuedByFromText(), authority, "Authority is correct");
    }

    @Step("Verify 'Date of issue' is correct")
    public void verifyDateOfIssueIsCorrect(String dateOfIssue) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getDateOfIssue(), dateOfIssue, "Date of issue is correct");
    }

    @Step("Verify 'Date of expiry' is correct")
    public void verifyDateOfExpiryIsCorrect(String dateOfExpiry) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getDateOfExpiry(), dateOfExpiry, "Date of expiry is correct");
    }

    @Step("Verify 'Phone number' is correct")
    public void verifyPhoneNumberIsCorrect(String phonePassport) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getPhoneText(), phonePassport, "Phone number is correct");
    }

    @Step("Verify 'Email address' is correct")
    public void verifyEmailIsCorrect(String emailPassport) {
        VerifySoft.verifyEqualsSoft(passportDetailsScreen.getEmailText(), emailPassport, "Email address is correct");
    }

    @Step("Verify 'Passport details is correct")
    public void verifyPassportDetailsIsCorrect() {
        verifyGivenNameIsCorrect(GIVEN_NAME);
        verifySurnameIsCorrect(SURNAME);
        verifyDateOfBirthIsCorrect(DATE_OF_BIRTH);
        verifyPassportSeriesIsCorrect(PASSPORT_SERIES);
        verifyPassportNumberIsCorrect(PASSPORT_NUMBER);
        verifyAuthorityIsCorrect(AUTHORITY);
        verifyDateOfIssueIsCorrect(DATE_OF_ISSUE);
        verifyDateOfExpiryIsCorrect(DATE_OF_EXPIRY);
        verifyPhoneNumberIsCorrect(PHONE_PASSPORT);
    }
}
