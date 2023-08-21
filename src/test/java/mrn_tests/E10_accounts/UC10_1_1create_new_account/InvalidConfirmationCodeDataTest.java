package mrn_tests.E10_accounts.UC10_1_1create_new_account;

import api.services.TestRails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.products.account.BaseAccountStep;

import static helpers.WordProcessor.generateCodeByLength;
import static verification.VerifySoft.showAllChecking;

public class InvalidConfirmationCodeDataTest extends BaseAccountStep {

    public static final String CONFIRM_CODE_ERROR_TEXT = "Invalid code entered. You have 4 attempts left.";

    @BeforeMethod
    public void createAccount() {
        loginUser();
        setAccountCurrency();
    }

    @TestRails(id = "c6113049")
    @Test(description = "Enter confirmation code one number", groups = {"Functional"})
    public void c6113049() {
        openConfirmScreenSteps();
        String tempCode = generateCodeByLength(1);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.tapOnNextButton();
        confirmationCodeStep.verifyErrorTextEquals(CONFIRM_CODE_ERROR_TEXT);
        showAllChecking();
    }

    @TestRails(id = "c6113070")
    @Test(description = "Enter confirmation code two number", groups = {"Functional"})
    public void c6113070() {
        openConfirmScreenSteps();
        String tempCode = generateCodeByLength(2);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.tapOnNextButton();
        confirmationCodeStep.verifyErrorTextEquals(CONFIRM_CODE_ERROR_TEXT);
        showAllChecking();
    }

    @TestRails(id = "c6113076")
    @Test(description = "Enter confirmation code three number", groups = {"Functional"})
    public void c6113076() {
        openConfirmScreenSteps();
        String tempCode = generateCodeByLength(3);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.tapOnNextButton();
        confirmationCodeStep.verifyErrorTextEquals(CONFIRM_CODE_ERROR_TEXT);
        showAllChecking();
    }

    @TestRails(id = "c6113083")
    @Test(description = "Enter confirmation code four number", groups = {"Functional"})
    public void c6113083() {
        openConfirmScreenSteps();
        String tempCode = generateCodeByLength(4);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.tapOnNextButton();
        confirmationCodeStep.verifyErrorTextEquals(CONFIRM_CODE_ERROR_TEXT);
        showAllChecking();
    }

    @TestRails(id = "c6113077")
    @Test(description = "Enter confirmation code five number", groups = {"Functional"})
    public void c6113077() {
        openConfirmScreenSteps();
        String tempCode = generateCodeByLength(5);
        confirmationCodeStep.enterConfirmationCodeToField(tempCode);
        confirmationCodeStep.tapOnNextButton();
        confirmationCodeStep.verifyErrorTextEquals(CONFIRM_CODE_ERROR_TEXT);
        confirmationCodeStep.verifySymbolsAreCorrectlyInConfirmationField(tempCode.substring(0, 4));
        showAllChecking();
    }

    private void openConfirmScreenSteps() {
        openAccountCreatingStep.onOpenAccountCreatingScreen();
        openAccountCreatingStep.verifyAccountCreatingScreenIsOpened();
        openAccountCreatingStep.tapOnNextButton();
        passportDetailsScreenStep.onPassportDetailsScreen();
        passportDetailsScreenStep.onCommonScreen();
        passportDetailsScreenStep.verifyPassportDetailsScreenIsOpened();
        passportDetailsScreenStep.tapOnNextButton();
        registrationAddressStep.onRegistrationAddressScreen();
        registrationAddressStep.onCommonScreen();
        registrationAddressStep.verifyRegistrationAddressScreenIsOpen();
        registrationAddressStep.tapOnNextButton();
        newAccountStep.onNewAccountScreen();
        newAccountStep.onCommonScreen();
        newAccountStep.verifyNewAccountScreenIsOpen();
        newAccountStep.tapOnNextButton();

        documentsStep.onDocumentsScreen();
        documentsStep.onCommonScreen();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.tupOnFirstDocument();
        firstDocumentStep.onFirstDocumentScreen();
        firstDocumentStep.verifyIsFirstDocumentOpen();
        documentsStep.tapContinueButton();
        documentsStep.tupOnSecondDocument();
        secondDocumentStep.onSecondDocumentScreen();
        secondDocumentStep.verifyIsSecondDocumentOpen();
        documentsStep.tapContinueButton();
        documentsStep.tupOnThirdDocument();
        thirdDocumentStep.onThirdDocumentScreen();
        thirdDocumentStep.verifyIsThirdDocumentOpen();
        documentsStep.tapContinueButton();
        documentsStep.verifyIsDocumentsOpen();
        documentsStep.verifyCheckMarkIsDisplayed();
        documentsStep.verifyNextButtonIsEnable();
        documentsStep.tapContinueButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.onCommonScreen();
        confirmationCodeStep.verifyConfirmScreenIsOpen();
        confirmationCodeStep.verifyCodeFieldIsDisplayed();
    }
}
