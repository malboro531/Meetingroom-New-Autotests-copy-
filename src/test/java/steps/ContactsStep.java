package steps;

import api.pages.ContactsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class ContactsStep {

    protected ContactsScreen contactsScreen;

    @Step("On 'Contacts' screen")
    public void onContactsScreen() {
        contactsScreen = new ContactsScreen();
    }

    @Step("Verify that mobile phone is enabled")
    public void verifyMobilePhoneIsEnabled() {
        Verify.verifyTrue(contactsScreen.isMobilePhoneEnabled(), "Mobile phone is enabled");
    }

    @Step("Verify that landline phone is enabled")
    public void verifyLandlinePhoneIsEnabled() {
        Verify.verifyTrue(contactsScreen.isLandlinePhoneEnabled(), "Landline phone is enabled");
    }

    @Step("Verify that email field is enabled")
    public void verifyEmailFieldIsEnabled() {
        Verify.verifyTrue(contactsScreen.isEmailEnabled(), "Email is enabled");
    }

    @Step("Verify that address field is enabled")
    public void verifyAddressFieldIsEnabled() {
        Verify.verifyTrue(contactsScreen.isBankAddressEnabled(), "Bank address field is enabled");
    }

    @Step("Verify that facebook is enabled")
    public void verifyFacebookIsEnabled() {
        Verify.verifyTrue(contactsScreen.isFacebookLinkEnabled(), "Facebook link is enabled");
    }

    @Step("Verify that twitter is enabled")
    public void verifyTwitterIsEnabled() {
        Verify.verifyTrue(contactsScreen.isTwitterLinkEnabled(), "Twitter link is enabled");
    }

    @Step("Verify that vKontakte is enabled")
    public void verifyVKontakteIsEnabled() {
        Verify.verifyTrue(contactsScreen.isVKLinkEnabled(), "VKontakte link is enabled");
    }

    @Step("Verify that instagram is enabled")
    public void verifyInstagramIsEnabled() {
        Verify.verifyTrue(contactsScreen.isInstagramLinkEnabled(), "Instagram link is enabled");
    }

    @Step("Verify that telegram is enabled")
    public void verifyTelegramIsEnabled() {
        Verify.verifyTrue(contactsScreen.isTelegramLinkEnabled(), "Telegram link is enabled");
    }

    @Step("Verify that youtube is enabled")
    public void verifyYoutubeIsEnabled() {
        Verify.verifyTrue(contactsScreen.isYouTubeLinkEnabled(), "Youtube link is enabled");
    }

    @Step("Verify that back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(contactsScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        contactsScreen.tapOnBackButton();
    }

    @Step("Verify contacts title text")
    public void verifyContactsTitleText(String title) {
        Verify.verifyEquals(contactsScreen.getContactsTitleText(), title, "Contacts title is correct");
    }
}
