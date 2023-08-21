package mrn_tests.E10_accounts.UC10_1_1create_new_account;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.products.account.BaseAccountStep;

import static constants.GlobalData.EUR;
import static verification.VerifySoft.showAllChecking;

public class ReturnPreviousMenuWhenCreatingAccountTest extends BaseAccountStep {

    @BeforeMethod
    public void createAccount() {
        loginUser();
        setAccountCurrency();
        openAccountCreatingStep.setCurrency(EUR);
    }

    @TestRails(id = "c6113036")
    @Test(description = "Come back from step two when creating account", groups = {"Functional"})
    public void c6113036() {
        accountCreateMenuStep.onAccountCreateMenu();
        accountCreateMenuStep.tapOnBackButton();
        openAccountStep.verifyOpenAccountScreenIsOpen();
    }

    @TestRails(id = "c6113039")
    @Test(description = "Come back from step three when creating account", groups = {"Functional"})
    public void c6113039() {
        accountCreateMenuStep.onAccountCreateMenu();
        accountCreateMenuStep.tapOnNextButton();
        openAccountPersonalStep.onOpenAccountPersonalScreen();
        openAccountPersonalStep.verifyOpenAccountPersonalScreenIsOpened();
        accountCreateMenuStep.tapOnBackButton();
        openAccountCreatingStep.verifyAccountCreatingScreenIsOpened();
    }

    @TestRails(id = "c6113040")
    @Test(description = "Come back from step four when creating account", groups = {"Functional"})
    public void c6113040() {
        accountCreateMenuStep.onAccountCreateMenu();
        accountCreateMenuStep.tapOnNextButton();
        accountCreateMenuStep.tapOnNextButton();
        openAccountRegAddressStep.onAccountRegAddressScreen();
        openAccountRegAddressStep.verifyAccountRegAddressScreenIsOpened();
        accountCreateMenuStep.tapOnBackButton();
        openAccountPersonalStep.onOpenAccountPersonalScreen();
        openAccountPersonalStep.verifyOpenAccountPersonalScreenIsOpened();
    }

    @TestRails(id = "C6075849")
    @Test(description = "Closing the 'Account creating' page", groups = {"Functional"})
    public void C6075849() {
        accountCreateMenuStep.onAccountCreateMenu();
        accountCreateMenuStep.tapCloseButton();
        accountCreateMenuStep.verifyDisplayedCancelAccountSelection();
        accountCreateMenuStep.verifyDisplayedOK();
        accountCreateMenuStep.verifyDisplayedCancel();
        accountCreateMenuStep.tapOKButton();
        accountCreateMenuStep.verifyPopUpIsNotDisplayed();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
    }

    @TestRails(id = "c6113015")
    @Test(description = "Cancellation of the invoice creation process from step 1", groups = {"Functional"})
    public void c6113015() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tubOnCloseButton();
        openAccountCreatingStep.verifyParentPanelIsDisplayed();
        openAccountCreatingStep.verifyCancelButtonIsEnabled();
        openAccountCreatingStep.verifyOkButtonIsEnabled();
        openAccountCreatingStep.tapOnCancelButton();
        openAccountCreatingStep.verifyAccountCreatingScreenIsOpened();
        openAccountCreatingStep.tubOnCloseButton();
        openAccountCreatingStep.verifyParentPanelIsDisplayed();
        openAccountCreatingStep.verifyCancelButtonIsEnabled();
        openAccountCreatingStep.verifyOkButtonIsEnabled();
        openAccountCreatingStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113018")
    @Test(description = "Cancellation of the invoice creation process from step 2", groups = {"Functional"})
    public void c6113018() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();

        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.tubOnCloseButton();
        passportDetailsScreenStep.verifyParentPanelIsDisplayed();
        passportDetailsScreenStep.verifyCancelButtonIsEnabled();
        passportDetailsScreenStep.verifyOkButtonIsEnabled();
        passportDetailsScreenStep.tapOnCancelButton();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.tubOnCloseButton();
        passportDetailsScreenStep.verifyParentPanelIsDisplayed();
        passportDetailsScreenStep.verifyCancelButtonIsEnabled();
        passportDetailsScreenStep.verifyOkButtonIsEnabled();
        passportDetailsScreenStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113019")
    @Test(description = "Cancellation of the invoice creation process from step 3", groups = {"Functional"})
    public void c6113019() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();

        registrationAddressStep.onCommonScreen();
        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.tubOnCloseButton();
        registrationAddressStep.verifyParentPanelIsDisplayed();
        registrationAddressStep.verifyCancelButtonIsEnabled();
        registrationAddressStep.verifyOkButtonIsEnabled();
        registrationAddressStep.tapOnCancelButton();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.tubOnCloseButton();
        registrationAddressStep.verifyParentPanelIsDisplayed();
        registrationAddressStep.verifyCancelButtonIsEnabled();
        registrationAddressStep.verifyOkButtonIsEnabled();
        registrationAddressStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113023")
    @Test(description = "Cancellation of the invoice creation process from step 4", groups = {"Functional"})
    public void c6113023() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();

        newAccountStep.onCommonScreen();
        newAccountStep.onNewAccountScreen();
        newAccountStep.verifyNewAccountScreenIsOpen();
        newAccountStep.tubOnCloseButton();
        newAccountStep.verifyParentPanelIsDisplayed();
        newAccountStep.verifyCancelButtonIsEnabled();
        newAccountStep.verifyOkButtonIsEnabled();
        newAccountStep.tapOnCancelButton();
        newAccountStep.verifyNewAccountScreenIsOpen();
        newAccountStep.tubOnCloseButton();
        newAccountStep.verifyParentPanelIsDisplayed();
        newAccountStep.verifyCancelButtonIsEnabled();
        newAccountStep.verifyOkButtonIsEnabled();
        newAccountStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113025")
    @Test(description = "Cancellation of the invoice creation process from step 5", groups = {"Functional"})
    public void c6113025() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onCommonScreen();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.tubOnCloseButton();
        documentsStep.verifyParentPanelIsDisplayed();
        documentsStep.verifyCancelButtonIsEnabled();
        documentsStep.verifyOkButtonIsEnabled();
        documentsStep.tapOnCancelButton();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.tubOnCloseButton();
        documentsStep.verifyParentPanelIsDisplayed();
        documentsStep.verifyCancelButtonIsEnabled();
        documentsStep.verifyOkButtonIsEnabled();
        documentsStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113027")
    @Test(description = "Cancellation of the invoice creation process from step 5", groups = {"Functional"})
    public void c6113027() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onCommonScreen();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyFirstDocumentIsDisplayed();
        documentsStep.verifySecondDocumentIsDisplayed();
        documentsStep.verifyThirdDocumentIsDisplayed();
        documentsStep.verifyNextButtonIsNotEnable();
        documentsStep.tupOnFirstDocument();

        firstDocumentStep.onFirstDocumentScreen();
        firstDocumentStep.verifyIsFirstDocumentOpen();
        documentsStep.verifyContinueButtonIsDisplayed();
        documentsStep.verifyTitleIsDisplayed();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsNotEnable();
        documentsStep.tupOnSecondDocument();

        secondDocumentStep.onSecondDocumentScreen();
        secondDocumentStep.verifyIsSecondDocumentOpen();
        documentsStep.verifyContinueButtonIsDisplayed();
        documentsStep.verifyTitleIsDisplayed();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsNotEnable();
        documentsStep.tupOnThirdDocument();

        thirdDocumentStep.onThirdDocumentScreen();
        thirdDocumentStep.verifyIsThirdDocumentOpen();
        documentsStep.verifyContinueButtonIsDisplayed();
        documentsStep.verifyTitleIsDisplayed();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsEnable();
        documentsStep.tapContinueButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.onCommonScreen();
        confirmationCodeStep.tubOnCloseButton();
        confirmationCodeStep.verifyParentPanelIsDisplayed();
        confirmationCodeStep.verifyCancelButtonIsEnabled();
        confirmationCodeStep.verifyOkButtonIsEnabled();
        confirmationCodeStep.tapOnCancelButton();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.tubOnCloseButton();
        confirmationCodeStep.verifyParentPanelIsDisplayed();
        confirmationCodeStep.verifyCancelButtonIsEnabled();
        confirmationCodeStep.verifyOkButtonIsEnabled();
        confirmationCodeStep.tubOnOkButton();
        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }
}
