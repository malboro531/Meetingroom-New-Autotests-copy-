package mrn_tests.E4_order_card.UC_4_4;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_4)
public class DeliveryCardTest extends BaseTest {
    @TestRails(id = "C5888143")
    @Test(description = "Segment bar is working on Delivery method page", groups = {"Smoke & Sanity"})
    public void c5888143() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();

        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        promoStep.onPromoScreen();
        promoStep.tapOnCrossImage();

        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnDepositsInlay();

        openDepositStep.onOpenDepositScreen();
        openDepositStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnCreditsInlay();

        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnCardsInlay();

        cardsStep.onCardsScreen();
        cardsStep.tapOnPlusButton();

        cardProcessingStep.onCardProcessingScreen();
        cardProcessingStep.tapPaymentSystemDropDownListMenu();
        cardProcessingStep.chooseMasterCardPaymentSystem();
        cardProcessingStep.tapCurrencyDropDownListMenu();
        cardProcessingStep.chooseUSDCurrency();
        cardProcessingStep.tapContinueButton();

        personalDataStep.onPersonalDataScreen();
        personalDataStep.tapContinueButton();

        personalDataRegistrationAdressStep.onPersonalDataRegistrationAdressScreen();
        personalDataRegistrationAdressStep.tapCheckBox();
        personalDataRegistrationAdressStep.tapConfirmButton();

        documentsStep.onDocumentsScreen();
        documentsStep.tapFirstDocument();

        firstDocumentStep.onFirstDocumentScreen();
        firstDocumentStep.tapConfirmButton();

        secondDocumentStep.onSecondDocumentScreen();
        secondDocumentStep.tapConfirmButton();

        thirdDocumentStep.onThirdDocumentScreen();
        thirdDocumentStep.tapConfirmButton();

        documentsStep.onDocumentsScreen();
        documentsStep.tapContinueButton();

        orderConfirmationStep.onOrderConfirmationScreen();
        orderConfirmationStep.enterConfirmationCodeToField(getConfirmCode());
        orderConfirmationStep.tapContinueButton();

        cityStep.onCityScreen();
        cityStep.tapReturnButton();

        deliveryMethodStep.onDeliveryMethodScreen();
        deliveryMethodStep.tapBranchTab();
        deliveryMethodStep.cityOnTabIsDisplayed();
        deliveryMethodStep.bankOnTabIsDisplayed();
    }

    @TestRails(id = "C5888198")
    @Test(description = "\"Back\" button on the \"Delivery type\" page", groups = {"Smoke & Sanity"})
    public void c5888198() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();

        loginStep.onLoginScreen();
        loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
        loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
        loginStep.tapOnLogInButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        promoStep.onPromoScreen();
        promoStep.tapOnCrossImage();

        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnDepositsInlay();

        openDepositStep.onOpenDepositScreen();
        openDepositStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnCreditsInlay();

        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnCardsInlay();

        cardsStep.onCardsScreen();
        cardsStep.tapOnPlusButton();

        cardProcessingStep.onCardProcessingScreen();
        cardProcessingStep.tapPaymentSystemDropDownListMenu();
        cardProcessingStep.chooseMasterCardPaymentSystem();
        cardProcessingStep.tapCurrencyDropDownListMenu();
        cardProcessingStep.chooseUSDCurrency();
        cardProcessingStep.tapContinueButton();

        personalDataStep.onPersonalDataScreen();
        personalDataStep.tapContinueButton();

        personalDataRegistrationAdressStep.onPersonalDataRegistrationAdressScreen();
        personalDataRegistrationAdressStep.tapCheckBox();
        personalDataRegistrationAdressStep.tapConfirmButton();

        documentsStep.onDocumentsScreen();
        documentsStep.tapFirstDocument();

        firstDocumentStep.onFirstDocumentScreen();
        firstDocumentStep.tapConfirmButton();

        secondDocumentStep.onSecondDocumentScreen();
        secondDocumentStep.tapConfirmButton();

        thirdDocumentStep.onThirdDocumentScreen();
        thirdDocumentStep.tapConfirmButton();

        documentsStep.onDocumentsScreen();
        documentsStep.tapContinueButton();

        orderConfirmationStep.onOrderConfirmationScreen();
        orderConfirmationStep.enterConfirmationCodeToField(getConfirmCode());
        orderConfirmationStep.tapContinueButton();

        cityStep.onCityScreen();
        cityStep.tapReturnButton();

        deliveryMethodStep.onDeliveryMethodScreen();
        deliveryMethodStep.tapReturnButton();

        confirmationCodeStep.verifyConfirmScreenIsOpen();
    }
}
