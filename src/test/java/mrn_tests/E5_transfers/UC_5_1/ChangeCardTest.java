package mrn_tests.E5_transfers.UC_5_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;
import static constants.GlobalData.*;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_1)
public class ChangeCardTest extends BaseTest {

    public void openTransfer() {
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
    }

    @TestRails(id = "C5978499")
    @Test(description = "Card which had been chosen for the transfer before is not displayed",
            groups = {"Smoke & Sanity"})
    public void C5973735() {
        openTransfer();
        transfersStep.onTransfersScreen()
                .tapOnTransferByCardNumberButton();

        transferByCardNumberStep.onTransferByCardNumberScreen()
                .tapOnFromCardField()
                .chooseSecondCard()
                .tapOnFromCardField()
                .verifySecondCardButtonIsNotDisplayed();
    }

    @TestRails(id = "C6037510")
    @Test(description = "Change selected card in a 'From card' field", groups = {"Functional"})
    public void C6037510() {
        openTransfer();
        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();
        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnFromCardField()
                .chooseSecondCard()
                .tapOnFromCardField()
                .chooseFirstCard()
                .verifyFromCardFieldDisplaysCorrectData(FIRST_CARD_NUMBER_USER_1110010)
                .verifyToCardFieldDisplaysCorrectData(EMPTY_FIELD)
                .verifyArrowButtonIsEnabled()
                .verifyCrossButtonIsEnabled()
                .verifyContinueButtonIsNotEnabled();
    }

    @TestRails(id = "C6037512")
    @Test(description = "Change selected card in a 'To card' field with an empty 'From card' field",
            groups = {"Functional"})
    public void C6037512() {
        openTransfer();
        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();
        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnToCardField()
                .chooseSecondCard()
                .tapOnToCardField()
                .chooseFirstCard()
                .verifyToCardFieldDisplaysCorrectData(FIRST_CARD_NUMBER_USER_1110010)
                .verifyFromCardFieldDisplaysCorrectData(EMPTY_FIELD)
                .verifyArrowButtonIsEnabled()
                .verifyCrossButtonIsEnabled()
                .verifyContinueButtonIsNotEnabled();
    }
}
