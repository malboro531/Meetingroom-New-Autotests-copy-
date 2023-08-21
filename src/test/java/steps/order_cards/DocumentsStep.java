package steps.order_cards;

import api.pages.order_card.DocumentsScreen;
import io.qameta.allure.Step;
import steps.transfers.CommonStep;
import verification.Verify;
import verification.VerifySoft;

import static constants.PersonalDetails.*;
import static helpers.DownloadFileFromDevice.downloadFileFromAndroid;

public class DocumentsStep extends CommonStep {

    protected DocumentsScreen documentsScreen;

    @Step("On DocumentsScreen Screen")
    public void onDocumentsScreen() {
        documentsScreen = new DocumentsScreen();
    }

    @Step("Verify 'DocumentsScreen' is open")
    public void verifyIsDocumentsOpen() {
        documentsScreen.verifyPageIsOpened();
    }

    @Step("Tap 'First Document'")
    public void tapFirstDocument() {
        documentsScreen.tapFirstDocument();
    }

    @Step("Tap 'Second Document'")
    public void tapSecondDocument() {
        documentsScreen.tapSecondDocument();
    }

    @Step("Tap 'Third Document'")
    public void tapThirdDocument() {
        documentsScreen.tapThirdDocument();
    }

    @Step("Tap Continue Button")
    public void tapContinueButton() {
        documentsScreen.tapContinueButton();
    }

    @Step("First document  is displayed")
    public void verifyFirstDocumentIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isFirstDocumentDisplayed(), "First document is displayed");
    }

    @Step("Second document  is displayed")
    public void verifySecondDocumentIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isSecondDocumentDisplayed(), "Second document is displayed");
    }

    @Step("Third document  is displayed")
    public void verifyThirdDocumentIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isThirdDocumentDisplayed(), "Third document is displayed");
    }

    @Step("Next button is not enabled")
    public void verifyNextButtonIsNotEnable() {
        VerifySoft.verifyFalseSoft(documentsScreen.isNextButtonDisplayed(), "Button next is not Enabled");
    }

    @Step("Tap on first document")
    public void tupOnFirstDocument() {
        documentsScreen.tapOnFirstDocument();
    }

    @Step("Tap on second document")
    public void tupOnSecondDocument() {
        documentsScreen.tapOnSecondDocument();
    }

    @Step("Tap on third document")
    public void tupOnThirdDocument() {
        documentsScreen.tapOnThirdDocument();
    }

    @Step("Check mark  is displayed")
    public void verifyCheckMarkIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isCheckMarkDisplayed(), "Check mark is displayed");
    }

    @Step("Next button is enabled")
    public void verifyNextButtonIsEnable() {
        VerifySoft.verifyTrueSoft(documentsScreen.isNextButtonDisplayed(), "Button next is Enabled");
    }

    @Step("Title field is displayed")
    public void verifyTitleIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isTitleDisplayed(), "Title is displayed");
    }

    @Step("Continue button is displayed")
    public void verifyContinueButtonIsDisplayed() {
        VerifySoft.verifyTrueSoft(documentsScreen.isContinueButtonDisplayed(), "Continue button is displayed");
    }

    @Step("Checking the uploaded file'")
    public void verifyToDownloadFirstDocument() {
        downloadFileFromAndroid(
                ANDROID_PATH + TARIFF,
                COMP_PATH_DOWNLOAD + TARIFF);
    }

    @Step("Checking the uploaded file'")
    public void verifyToDownloadSecondDocument() {
              downloadFileFromAndroid(
                ANDROID_PATH + TERMS_OF_COMPREHENSIVE_BANKING,
                COMP_PATH_DOWNLOAD + TERMS_OF_COMPREHENSIVE_BANKING);
    }

    @Step("Checking the uploaded file'")
    public void verifyToDownloadThirdDocument() {
        downloadFileFromAndroid(
                ANDROID_PATH + APPLICATION_FORM_WITH_CONCERT,
                COMP_PATH_DOWNLOAD + APPLICATION_FORM_WITH_CONCERT);
    }

    @Step("Verify first document")
    public void verifyFirstDocument() {
        Verify.verifyTrue(documentsScreen.isFirstDocumentEquals(), "First document is correct");
    }

    @Step("Verify second document")
    public void verifySecondDocument() {
        Verify.verifyTrue(documentsScreen.isSecondDocumentEquals(), "Second document is correct");
    }

    @Step("Verify third document")
    public void verifyThirdDocument() {
        Verify.verifyTrue(documentsScreen.isThirdDocumentEquals(), "Third document is correct");
    }
}