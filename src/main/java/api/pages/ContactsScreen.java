package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.CONTACTS_TITLE;

@PageName(pageName = CONTACTS_TITLE)
public class ContactsScreen extends BaseScreen {

    @Required
    @FindBy(id = "textViewTitle")
    private WebElement contactsTitle;

    @FindBy(id = "image_free_calls")
    private WebElement mobilePhone;

    @FindBy(id = "international_calls_image")
    private WebElement landlinePhone;

    @FindBy(id = "email_image")
    private WebElement email;

    @FindBy(id = "bank_branches_address_image")
    private WebElement bankAddress;

    @FindBy(id = "fb")
    private WebElement faceBook;

    @FindBy(id = "twitter")
    private WebElement twitter;

    @FindBy(id = "vk")
    private WebElement vKontakte;

    @FindBy(id = "inst")
    private WebElement instagram;

    @FindBy(id = "tg")
    private WebElement telegram;

    @FindBy(id = "youTube")
    private WebElement youTube;

    @FindBy(id = "social_networks_text_view")
    private WebElement socialNetworksTitle;

    @FindBy(id = "imageViewMain")
    private WebElement backButton;

    public String getContactsTitleText() {
        return contactsTitle.getText();
    }

    public boolean isMobilePhoneEnabled() {
        return mobilePhone.isEnabled();
    }

    public boolean isLandlinePhoneEnabled() {
        return landlinePhone.isEnabled();
    }

    public boolean isEmailEnabled() {
        return email.isEnabled();
    }

    public boolean isBankAddressEnabled() {
        return bankAddress.isEnabled();
    }

    public boolean isFacebookLinkEnabled() {
        return faceBook.isEnabled();
    }

    public boolean isTwitterLinkEnabled() {
        return twitter.isEnabled();
    }

    public boolean isVKLinkEnabled() {
        return vKontakte.isEnabled();
    }

    public boolean isInstagramLinkEnabled() {
        return instagram.isEnabled();
    }

    public boolean isTelegramLinkEnabled() {
        return telegram.isEnabled();
    }

    public boolean isYouTubeLinkEnabled() {
        return youTube.isEnabled();
    }

    public boolean isBackButtonEnabled() {
        return backButton.isEnabled();
    }

    public void tapOnBackButton() {
        backButton.click();
    }
}
