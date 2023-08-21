package mrn_tests.E2_main_page;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.*;

public class MoreSectionTest extends BaseTest {

    private MoreStep moreStep = new MoreStep();
    private CurrencyExchangeStep currencyExchangeStep = new CurrencyExchangeStep();
    private BankBranchesStep bankBranchesStep = new BankBranchesStep();
    private ContactsStep contactsStep = new ContactsStep();
    private static final String CURRENCY_EXCHANGE = "Currency exchange";
    private static final String BANK_BRANCHES = "Bank branches";
    private static final String CONTACTS = "Contacts";

    @BeforeMethod
    public void openAppAndMoreSection() {
        goToMoreScreen();
        moreStep.onMoreScreen();
    }

    @TestRails(id = "C6033877")
    @Test(description = "Transfer to 'More' section", groups = {"Functional"})
    public void c6033877() {
        moreStep.verifyCurrencyExchangeText(CURRENCY_EXCHANGE);
        moreStep.verifyBankBranchesText(BANK_BRANCHES);
        moreStep.verifyContactsText(CONTACTS);
        moreStep.verifyCurrencyExchangeIsEnabled();
        moreStep.verifyBankBranchesIsEnabled();
        moreStep.verifyContactsIsEnabled();
    }

    @TestRails(id = "C6049689")
    @Test(description = "Currency exchange checking", groups = {"Functional"})
    public void c6049689() {
        moreStep.tapOnCurrencyExchange();

        currencyExchangeStep.onCurrencyExchangeScreen();
        currencyExchangeStep.verifyCurrencyExchangeTitleText(CURRENCY_EXCHANGE);
        currencyExchangeStep.verifyEurIsDisplayed();
        currencyExchangeStep.verifyUsdIsDisplayed();
        currencyExchangeStep.verifyBynIsDisplayed();
        currencyExchangeStep.verifyBackButtonIsEnabled();
        currencyExchangeStep.verifyEurIsEnabled();
        currencyExchangeStep.verifyUsdIsEnabled();
        currencyExchangeStep.verifyBynIsEnabled();
    }

    @TestRails(id = "C6049702")
    @Test(description = "Return to the previous screen from 'Currency exchange'", groups = {"Functional"})
    public void c6049702() {
        moreStep.tapOnCurrencyExchange();

        currencyExchangeStep.tapOnBackButton();

        moreStep.onMoreScreen();
        moreStep.verifyMoreTitleIsDisplayed();
    }

    @TestRails(id = "C6341107")
    @Test(description = "Bank branches checking", groups = {"Functional"})
    public void c6341107() {
        moreStep.tapOnBankBranches();

        bankBranchesStep.onBankBranchesScreen();
        bankBranchesStep.verifyBankBranchesTitleText(BANK_BRANCHES);
        bankBranchesStep.verifyBackButtonIsEnabled();
    }

    @TestRails(id = "C6341106")
    @Test(description = "Return to the previous screen from 'Bank branches'", groups = {"Functional"})
    public void c6341106() {
        moreStep.tapOnBankBranches();

        bankBranchesStep.onBankBranchesScreen();
        bankBranchesStep.tapOnBackButton();

        moreStep.onMoreScreen();
        moreStep.verifyMoreTitleIsDisplayed();
    }

    @TestRails(id = "C6341138")
    @Test(description = "Bank branches checking", groups = {"Functional"})
    public void c6341138() {
        moreStep.tapOnContactsField();

        contactsStep.onContactsScreen();
        contactsStep.verifyContactsTitleText(CONTACTS);
        contactsStep.verifyMobilePhoneIsEnabled();
        contactsStep.verifyLandlinePhoneIsEnabled();
        contactsStep.verifyEmailFieldIsEnabled();
        contactsStep.verifyAddressFieldIsEnabled();
        contactsStep.verifyBackButtonIsEnabled();
        contactsStep.verifyFacebookIsEnabled();
        contactsStep.verifyInstagramIsEnabled();
        contactsStep.verifyTelegramIsEnabled();
        contactsStep.verifyTwitterIsEnabled();
        contactsStep.verifyYoutubeIsEnabled();
        contactsStep.verifyVKontakteIsEnabled();
    }

    @TestRails(id = "C6341140")
    @Test(description = "Return to the previous screen from 'Bank branches'", groups = {"Functional"})
    public void c6341140() {
        moreStep.tapOnContactsField();

        contactsStep.onContactsScreen();
        contactsStep.tapOnBackButton();

        moreStep.onMoreScreen();
        moreStep.verifyMoreTitleIsDisplayed();
    }
}
