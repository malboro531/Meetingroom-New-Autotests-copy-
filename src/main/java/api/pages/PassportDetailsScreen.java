package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.PASSPORT_DETAILS_TITLE;

@PageName(pageName = PASSPORT_DETAILS_TITLE)
public class PassportDetailsScreen extends BaseScreen {

    @Required
    @FindBy(id = "passport_number")
    private WebElement passportNumber;

    @FindBy(id = "passport_series")
    private WebElement passportSeries;

    @FindBy(id = "imageViewMain")
    private WebElement backArrowButton;

    @FindBy(id = "secondary_button")
    private WebElement myDataIsNotCorrectButton;

    @FindBy(id = "primary_button")
    private WebElement nextButton;

    @FindBy(id = "given_name")
    private WebElement givenName;

    @FindBy(id = "surname")
    private WebElement surname;

    @FindBy(id = "date_of_birth")
    private WebElement dateOfBirth;

    @FindBy(id = "authority")
    private WebElement authority;

    @FindBy(id = "date_of_issue")
    private WebElement dateOfIssue;

    @FindBy(id = "date_of_expiry")
    private WebElement dateOfExpiry;

    @FindBy(id = "phone_number")
    private WebElement phone;

    @FindBy(id = "email")
    private WebElement email;

    public void tapBackArrowButton() {
        backArrowButton.click();
    }

    public String getGivenNameText() {
        return givenName.getText();
    }

    public String getSurnameText() {
        return surname.getText();
    }

    public String getDateOfBirthText() {
        return dateOfBirth.getText();
    }

    public String getPassportNumberText() {
        return passportNumber.getText();
    }

    public String getPassportSeriesText() {
        return passportSeries.getText();
    }

    public String getIssuedByFromText() {
        return authority.getText();
    }

    public String getDateOfIssue() {
        return dateOfIssue.getText();
    }

    public String getDateOfExpiry() {
        return dateOfExpiry.getText();
    }

    public String getPhoneText() {
        return phone.getText();
    }

    public String getEmailText() {
        return email.getText();
    }

    public boolean isMyDataIsNoCorrectButtonDisplayed() {
        return myDataIsNotCorrectButton.isDisplayed();
    }
}