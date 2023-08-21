package mrn_tests.E4_order_card.UC_4_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_1;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_1)
public class OrderAnyCard extends BaseTest {

    @TestRails(id = "C5883111")
    @Test(description = "Order any card (end-to-end)", groups = {"Smoke & Sanity"})
    public void c5883111() {
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

        documentsStep.tapSecondDocument();
        secondDocumentStep.onSecondDocumentScreen();
        secondDocumentStep.tapConfirmButton();

        documentsStep.tapThirdDocument();
        thirdDocumentStep.onThirdDocumentScreen();
        thirdDocumentStep.tapConfirmButton();

        documentsStep.tapContinueButton();
        // TODO - dont finished. Need checking screens from documents
    }
}
