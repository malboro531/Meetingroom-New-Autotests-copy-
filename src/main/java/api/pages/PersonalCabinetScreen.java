package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.PERSONAL_CABINET_TITLE;

@PageName(pageName = PERSONAL_CABINET_TITLE)
public class PersonalCabinetScreen extends BaseScreen {

    @FindBy(id = "imageViewMain")
    private WebElement backArrowButton;
    @FindBy(id = "user_photo")
    private WebElement userPhoto;

    @FindBy(id = "email_text")
    private WebElement emailText;

    @Required
    @FindBy(id = "pass_details")
    private WebElement passportDetails;

    @FindBy(id = "reg_address")
    private WebElement registrationAddress;

    @FindBy(id = "delete_acc")
    private WebElement deleteAccount;

    @FindBy(id = "change_password")
    private WebElement changePassword;

    public void tapUserPhoto() {
        userPhoto.click();
    }

    public void tapBackArrowButton() {
        backArrowButton.click();
    }

    private String getEmail() {
        return emailText.getText();
    }

    public boolean isChangedEmailMatch(String email) {
        return getEmail().equals(email);
    }

    public void tapPassportDetailsButton() {
        passportDetails.click();
    }

    public void tapRegistrationAddressButton() {
        registrationAddress.click();
    }

    public void tapDeleteAccountButton() {
        deleteAccount.click();
    }

    public void tapChangePassword() {changePassword.click();}
}