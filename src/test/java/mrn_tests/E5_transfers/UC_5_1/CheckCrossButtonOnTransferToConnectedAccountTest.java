package mrn_tests.E5_transfers.UC_5_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_1)
public class CheckCrossButtonOnTransferToConnectedAccountTest extends BaseTest {

    @TestRails(id = "C5973735")
    @Test(description = "Cross button is working on Transfers to connected card page", groups = {"Smoke & Sanity"})
    public void C5973735() {
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
        cardsStep.chooseFirstCard();

        ownCardDetailsStep.onCardDetailsScreen();
        ownCardDetailsStep.tapOnTransferButton();

        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();

        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnCrossButton()
                .okButtonIsDisplayed()
                .cancelButtonIsDisplayed()
                .descriptionCancelMoneyIsDisplayed();
    }
}
