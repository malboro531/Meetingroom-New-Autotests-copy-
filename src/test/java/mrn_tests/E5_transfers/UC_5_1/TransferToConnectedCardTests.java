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
public class TransferToConnectedCardTests extends BaseTest {

    private final double transferedAmount100 = Double.parseDouble(AMOUNT_100);

    public void openAppProductsCards() {
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
    }

    @TestRails(id = "C5972684")
    @Test(description = "Transfer to connected card (USD)", groups = {"Smoke & Sanity"})
    public void C5972684() {
        openAppProductsCards();
        cardsStep.onCardsScreen();
        double firstCardBalanceAmount = cardsStep.getFirstCardBalance();
        double secondCardBalanceAmount = cardsStep.getSecondCardBalance();
        cardsStep.chooseFirstCard();

        ownCardDetailsStep.onCardDetailsScreen();
        ownCardDetailsStep.tapOnTransferButton();

        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();

        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnFromCardField()
                .chooseFirstCard()
                .tapOnToCardField()
                .chooseFirstCard()
                .tapOnContinueButton();

        amountStep.onAmountScreen()
                .enterAmountToAmountField(AMOUNT_100)
                .tapOnConfirmButton();

        confirmationTransferStep.onConfirmationTransferScreen()
                .verifyAmount$IsDisplayed(AMOUNT_100)
                .verifySourceCardFieldDisplaysCorrectData(FIRST_CARD_NUMBER_USER_1110010)
                .verifyDestinationCardFieldDisplaysCorrectData(SECOND_CARD_NUMBER_USER_1110010)
                .tapOnTransferButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent")
                .tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        cardsStep.onCardsScreen();
        double firstCardBalanceAmountAfterTransaction = cardsStep.getFirstCardBalance();
        double secondCardBalanceAmountAfterTransaction = cardsStep.getSecondCardBalance();
        cardsStep.verifyCardBalanceAfterTransaction
                (firstCardBalanceAmount - transferedAmount100, firstCardBalanceAmountAfterTransaction);
        cardsStep.verifyCardBalanceAfterTransaction
                (secondCardBalanceAmount + transferedAmount100, secondCardBalanceAmountAfterTransaction);
    }

    @TestRails(id = "C6037653")
    @Test(description = "Transfer to connected card - transfer of all funds from the card", groups = {"Smoke & Sanity"})
    public void C6037653() {
        openAppProductsCards();
        cardsStep.onCardsScreen();
        double firstCardBalanceAmount = cardsStep.getFirstCardBalance();
        String firsCardBalanceAmountText = cardsStep.getFirstCardBalanceText() + ".00";
        //TODO The cents is not displayed yet
        double secondCardBalanceAmount = cardsStep.getSecondCardBalance();
        cardsStep.chooseFirstCard();

        ownCardDetailsStep.onCardDetailsScreen();
        ownCardDetailsStep.tapOnTransferButton();

        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();

        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnFromCardField()
                .chooseFirstCard()
                .tapOnToCardField()
                .chooseFirstCard()
                .tapOnContinueButton();

        amountStep.onAmountScreen()
                .enterAmountToAmountField(firsCardBalanceAmountText)
                .tapOnConfirmButton();

        confirmationTransferStep.onConfirmationTransferScreen()
                .verifyAmount$IsDisplayed(firsCardBalanceAmountText)
                .verifySourceCardFieldDisplaysCorrectData(FIRST_CARD_NUMBER_USER_1110010)
                .verifyDestinationCardFieldDisplaysCorrectData(SECOND_CARD_NUMBER_USER_1110010)
                .tapOnTransferButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent")
                .tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        cardsStep.onCardsScreen();
        double firstCardBalanceAmountAfterTransaction = cardsStep.getFirstCardBalance();
        double secondCardBalanceAmountAfterTransaction = cardsStep.getSecondCardBalance();
        cardsStep.verifyCardBalanceAfterTransaction
                (firstCardBalanceAmount - firstCardBalanceAmount, firstCardBalanceAmountAfterTransaction);
        cardsStep.verifyCardBalanceAfterTransaction
                (secondCardBalanceAmount + firstCardBalanceAmount, secondCardBalanceAmountAfterTransaction);
    }

    @TestRails(id = "C6037654")
    @Test(description = "'Transfer to connected card - transfer 0.00 conventional units from the card",
            groups = {"Smoke & Sanity"})
    public void C6037654() {
        openAppProductsCards();
        cardsStep.onCardsScreen();
        cardsStep.chooseFirstCard();

        ownCardDetailsStep.onCardDetailsScreen();
        ownCardDetailsStep.tapOnTransferButton();

        transfersStep.onTransfersScreen()
                .tapOnTransferToConnectedCardButton();

        transfersToConnectedCardStep.onTransfersToConnectedCardScreen()
                .tapOnFromCardField()
                .chooseFirstCard()
                .tapOnToCardField()
                .chooseFirstCard()
                .tapOnContinueButton();

        amountStep.onAmountScreen()
                .enterAmountToAmountField(AMOUNT_0)
                .tapOnConfirmButton()
                .verifyErrorMessageIsCorrect("Amount must be greater than zero");
    }
}
