package mrn_tests.E10_accounts.UC10_1_1create_new_account;

import api.services.TestRails;
import constants.enums.Currency;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.products.account.BaseAccountStep;

import static constants.GlobalData.EUR;
import static constants.GlobalData.USD;
import static verification.VerifySoft.showAllChecking;

public class ConfirmDocumentsAndTransferNextStepTest extends BaseAccountStep {

    @BeforeMethod
    public void createAccount() {
        loginUser();
        setAccountCurrency();
    }

    @TestRails(id = "c6113044")
    @Test(description = "Going to the next step without reading the documents", groups = {"Functional"})
    public void c6113044() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.tapContinueButton();
        documentsStep.verifyNextButtonIsNotEnable();
    }

    @TestRails(id = "c6113041")
    @Test(description = "Confirm first documents and transfer to step five", groups = {"Functional"})
    public void c6113041() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyFirstDocumentIsDisplayed();
        documentsStep.verifySecondDocumentIsDisplayed();
        documentsStep.verifyThirdDocumentIsDisplayed();
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
    }

    @TestRails(id = "c6113042")
    @Test(description = "Confirm first and second documents and transfer to step five", groups = {"Functional"})
    public void c6113042() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyFirstDocumentIsDisplayed();
        documentsStep.verifySecondDocumentIsDisplayed();
        documentsStep.verifyThirdDocumentIsDisplayed();
        documentsStep.tupOnFirstDocument();

        firstDocumentStep.onFirstDocumentScreen();
        firstDocumentStep.verifyIsFirstDocumentOpen();
        documentsStep.verifyContinueButtonIsDisplayed();
        documentsStep.verifyTitleIsDisplayed();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
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
    }

    @TestRails(id = "ñ6113001")
    @Test(description = "Create a new account USD", groups = {"Smoke & Sanity"})
    public void c6113001() {
        openAccountCreatingStep.setCurrency(USD);
        openAccountCreatingStep.verifyGetCurrencyText(Currency.USD);
        openAccountCreatingStep.tapOnNextButton();

        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.verifyButtonNextIsDisplayed();
        passportDetailsScreenStep.verifyMyDataIsNoCorrectButtonIsDisplayed();
        passportDetailsScreenStep.verifyPassportDetailsIsCorrect();

        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.verifyCountryFieldIsCorrect();
        registrationAddressStep.verifyCityFieldIsCorrect();
        registrationAddressStep.verifyStreetFieldIsCorrect();
        registrationAddressStep.verifyHouseFieldIsCorrect();
        registrationAddressStep.verifyBuildingFieldIsCorrect();
        registrationAddressStep.verifyFlatFieldIsCorrect();
        registrationAddressStep.verifyButtonNextIsDisplayed();
        registrationAddressStep.verifyMyDataIsNotCorrectButtonIsDisplayed();
        registrationAddressStep.tapOnNextButton();

        newAccountStep.onNewAccountScreen();
        newAccountStep.onCommonScreen();
        newAccountStep.verifyNewAccountScreenIsOpen();
        newAccountStep.verifyButtonNextIsDisplayed();
        newAccountStep.verifyCurrencyElementIsCorrect();
        newAccountStep.verifyAccountElementIsCorrect();
        newAccountStep.verifyOwnerElementIsCorrect();
        newAccountStep.verifyBankElementIsCorrect();
        newAccountStep.verifyDateElementIsCorrect();
        newAccountStep.tapOnNextButton();

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
        documentsStep.verifyToDownloadFirstDocument();
        documentsStep.verifyFirstDocument();
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
        documentsStep.verifyToDownloadSecondDocument();
        documentsStep.verifySecondDocument();
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
        documentsStep.verifyToDownloadThirdDocument();
        documentsStep.verifyThirdDocument();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsEnable();
        documentsStep.tapContinueButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.onCommonScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.verifyEmailIsDisplayed();
        confirmationCodeStep.verifyCodeFieldIsDisplayed();
        confirmationCodeStep.verifySendAgainIsDisplayed();
        confirmationCodeStep.verifyButtonNextIsDisplayed();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnNextButton();

        accountCreatedStep.onAccountCreateMenu();
        accountCreatedStep.verifyIsAccountCreatedIsOpen();
        accountCreatedStep.verifyCreateNewCardIsDisplayed();
        accountCreatedStep.verifyBackButtonIsDisplayed();
        accountCreatedStep.tapOnBackButton();
        productsStep.onProductsScreen();
        productsStep.verifyProductsIsOpen();
        showAllChecking();
    }

    @TestRails(id = "C6320807")
    @Test(description = "Create a new account EUR", groups = {"Smoke & Sanity"})
    public void c6320807() {
        openAccountCreatingStep.setCurrency(EUR);
        openAccountCreatingStep.verifyGetCurrencyText(Currency.EUR);
        openAccountCreatingStep.tapOnNextButton();

        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.verifyButtonNextIsDisplayed();
        passportDetailsScreenStep.verifyMyDataIsNoCorrectButtonIsDisplayed();
        passportDetailsScreenStep.verifyPassportDetailsIsCorrect();

        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.verifyCountryFieldIsCorrect();
        registrationAddressStep.verifyCityFieldIsCorrect();
        registrationAddressStep.verifyStreetFieldIsCorrect();
        registrationAddressStep.verifyHouseFieldIsCorrect();
        registrationAddressStep.verifyBuildingFieldIsCorrect();
        registrationAddressStep.verifyFlatFieldIsCorrect();
        registrationAddressStep.verifyButtonNextIsDisplayed();
        registrationAddressStep.verifyMyDataIsNotCorrectButtonIsDisplayed();
        registrationAddressStep.tapOnNextButton();

        newAccountStep.onNewAccountScreen();
        newAccountStep.onCommonScreen();
        newAccountStep.verifyNewAccountScreenIsOpen();
        newAccountStep.verifyButtonNextIsDisplayed();
        newAccountStep.verifyCurrencyElementIsCorrect();
        newAccountStep.verifyAccountElementIsCorrect();
        newAccountStep.verifyOwnerElementIsCorrect();
        newAccountStep.verifyBankElementIsCorrect();
        newAccountStep.verifyDateElementIsCorrect();
        newAccountStep.tapOnNextButton();

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
        documentsStep.verifyToDownloadFirstDocument();
        documentsStep.verifyFirstDocument();
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
        documentsStep.verifyToDownloadSecondDocument();
        documentsStep.verifySecondDocument();
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
        documentsStep.verifyToDownloadThirdDocument();
        documentsStep.verifyThirdDocument();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsEnable();
        documentsStep.tapContinueButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.onCommonScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.verifyEmailIsDisplayed();
        confirmationCodeStep.verifyCodeFieldIsDisplayed();
        confirmationCodeStep.verifySendAgainIsDisplayed();
        confirmationCodeStep.verifyButtonNextIsDisplayed();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnNextButton();

        accountCreatedStep.onAccountCreateMenu();
        accountCreatedStep.verifyIsAccountCreatedIsOpen();
        accountCreatedStep.verifyCreateNewCardIsDisplayed();
        accountCreatedStep.verifyBackButtonIsDisplayed();
        accountCreatedStep.tapOnBackButton();
        productsStep.onProductsScreen();
        productsStep.verifyProductsIsOpen();
        showAllChecking();
    }

    @TestRails(id = "c6113079")
    @Test(description = "Switching to the creation of a new card upon successful account creation", groups = {"Functional"})
    public void c6113079() {
        openAccountCreatingStep.onCommonScreen();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onCommonScreen();
        newAccountStep.tapOnNextButton();

        documentsStep.onDocumentsScreen();
        documentsStep.onCommonScreen();
        documentsStep.tupOnFirstDocument();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.onCommonScreen();
        documentsStep.tupOnSecondDocument();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.onCommonScreen();
        documentsStep.tupOnThirdDocument();
        documentsStep.tapContinueButton();
        documentsStep.onDocumentsScreen();
        documentsStep.onCommonScreen();
        documentsStep.tapContinueButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.onCommonScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.verifyEmailIsDisplayed();
        confirmationCodeStep.verifyCodeFieldIsDisplayed();
        confirmationCodeStep.verifySendAgainIsDisplayed();
        confirmationCodeStep.verifyButtonNextIsDisplayed();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnNextButton();

        accountCreatedStep.onAccountCreateMenu();
        accountCreatedStep.verifyIsAccountCreatedIsOpen();
        accountCreatedStep.verifyCreateNewCardIsDisplayed();
        accountCreatedStep.verifyBackButtonIsDisplayed();
        accountCreatedStep.tapOnCreateNewCardButton();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.verifyMainOrderCardScreenIsOpen();
        showAllChecking();
    }
}
