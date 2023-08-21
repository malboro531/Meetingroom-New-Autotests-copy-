package mrn_tests.E5_transfers.UC_5_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_5_TRANSFERS;
import static constants.AllureData.FEATURE_UC_5_1;
import static constants.GlobalData.*;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_1)
public class TransferToConnectedCardInvalidConfirmationCodeTests extends BaseTest {

    public void openAppAndMakeTransferBetweenOwnCards() {
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
                .tapOnFromCardField()
                .chooseSecondCard()
                .tapOnToCardField()
                .chooseFirstCard()
                .tapOnContinueButton();

        amountStep.onAmountScreen()
                .enterAmountToAmountField(AMOUNT_100)
                .tapOnConfirmButton();

        confirmationTransferStep.onConfirmationTransferScreen()
                .tapOnTransferButton();
    }

    @TestRails(id = "C6037748")
    @Test(description = "Transfer to connected card - tap on button 'Confirm' without enter an confirmation code",
            groups = {"Smoke & Sanity"})
    public void C6037748() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.tapOnConfirmButton();
        confirmationCodeStep.verifyErrorTextEqualsQuantityAttemptsLeft(4);
    }

    @TestRails(id = "C6037750")
    @Test(description = "Transfer to connected card - tap on button 'Confirm' without enter an confirmation code twice",
            groups = {"Smoke & Sanity"})
    public void C6037750() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 2; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyErrorTextEqualsQuantityAttemptsLeft(3);
    }

    @TestRails(id = "C6037752")
    @Test(description = "Transfer to connected card - tap on button 'Confirm' without enter an confirmation code in" +
            "third time",
            groups = {"Smoke & Sanity"})
    public void C6037752() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 3; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyErrorTextEqualsQuantityAttemptsLeft(2);
    }

    @TestRails(id = "C6037763")
    @Test(description = "Transfer to connected card - tap on button 'Confirm' without enter an confirmation code in" +
            "fourth time",
            groups = {"Smoke & Sanity"})
    public void C6037763() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 4; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyErrorTextEqualsQuantityAttemptsLeft(1);
    }

    @TestRails(id = "C6037753")
    @Test(description = "Transfer to connected card - tap on button 'Confirm' without enter an confirmation code five" +
            "times", groups = {"Smoke & Sanity"})
    public void C6037753() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyGetErrorTextTitle(YOU_ENTERED_THE_WRONG_CODE_5_TIMES);
        confirmationCodeStep.verifyChangeMethodButtonIsEnabled();
        confirmationCodeStep.verifyRepeatLaterButtonIsEnabled();
    }

    @TestRails(id = "C6037765")
    @Test(description = "Transfer to connected card - check the 'Change method' function after entering the wrong" +
            "confirmation code five times", groups = {"Smoke & Sanity"})
    public void C6037765() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyGetErrorTextTitle(YOU_ENTERED_THE_WRONG_CODE_5_TIMES);
        confirmationCodeStep.tapOnChangeMethodButton();

        confirmationCodeOptionsStep.onConfirmationCodeOptionsScreen();
        confirmationCodeOptionsStep.verifyEmailRadioButtonIsChecked();
        confirmationCodeOptionsStep.verifySmsRadioButtonIsNotChecked();
        confirmationCodeOptionsStep.verifyPushRadioButtonIsNotChecked();
        confirmationCodeOptionsStep.verifyBackIconIsEnabled();
        confirmationCodeOptionsStep.verifyProceedButtonIsEnabled();
    }

    @TestRails(id = "C6038061")
    @Test(description = "Transfer to connected card - check the 'Repeat later' function after entering the wrong" +
            "confirmation code five times", groups = {"Smoke & Sanity"})
    public void C6038061() {
        openAppAndMakeTransferBetweenOwnCards();
        confirmationCodeStep.onConfirmScreen();
        for (int i = 0; i < 5; i++) {
            confirmationCodeStep.tapOnConfirmButton();
        }
        confirmationCodeStep.verifyGetErrorTextTitle(YOU_ENTERED_THE_WRONG_CODE_5_TIMES);
        confirmationCodeStep.tapOnRepeatLaterButton();
        welcomeStep.onWelcomeScreen();
    }
}
