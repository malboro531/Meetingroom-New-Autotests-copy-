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
public class TransferByCardNumberTest extends BaseTest {

    public void openAppAndChooseTransferByCardNumber() {
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
                .tapOnTransferByCardNumberButton();
    }

    @TestRails(id = "C5972803")
    @Test(description = "Transfer by valid card number", groups = {"Smoke & Sanity"})
    public void c5972803() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.onTransferByCardNumberScreen()
                .tapOnFromCardField()
                .chooseSecondCard()
                .enterCardNumberToToCardField(VALID_CARD_NUMBER)
                .tapOnNextButton();

        amountStep.enterAmountToAmountField(AMOUNT_100)
                .tapOnConfirmButton();

        confirmationTransferStep.onConfirmationTransferScreen()
                .verifyAmount$IsDisplayed(AMOUNT_100)
                .verifySourceCardFieldDisplaysCorrectData(SECOND_CARD_NUMBER_USER_1110010)
                .verifyDestinationCardFieldDisplaysCorrectData(VALID_CARD_NUMBER)
                //TODO — functionality is faulty
                .tapOnTransferButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent")
                .verifyIsBackToMainButtonEnabled();
    }

    @TestRails(id = "C5978752")
    @Test(description = "Push the 'arrow' button on the page with fields 'Transfer amount' and 'Transfer assignment'",
            groups = {"Smoke & Sanity"})
    public void c5978752() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.onTransferByCardNumberScreen()
                .tapOnFromCardField()
                .chooseSecondCard()
                .enterCardNumberToToCardField(VALID_CARD_NUMBER) //TODO — functionality is faulty
                .tapOnNextButton();

        amountStep.onAmountScreen()
                .tapOnArrowButton();

        transferByCardNumberStep.onTransferByCardNumberScreen()
                .verifyFromCardFieldDisplaysCorrectData(SECOND_CARD_NUMBER_USER_1110010)
                .verifyToCardFieldDisplaysCorrectData(VALID_CARD_NUMBER);
    }

    @TestRails(id = "C5982744")
    @Test(description = "Enter a value greater than the card balance",
            groups = {"Smoke & Sanity"})
    public void c5982744() {
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
        double firstCardGreaterBalanceAmount = cardsStep.getFirstCardBalance() + 10;
        String firstCardGreaterBalanceAmountText = Double.toString(firstCardGreaterBalanceAmount);
        cardsStep.chooseFirstCard();

        ownCardDetailsStep.onCardDetailsScreen();
        ownCardDetailsStep.tapOnTransferButton();

        transfersStep.onTransfersScreen()
                .tapOnTransferByCardNumberButton();

        transferByCardNumberStep.onTransferByCardNumberScreen()
                .tapOnFromCardField()
                .chooseFirstCard()
                .enterCardNumberToToCardField(VALID_CARD_NUMBER)
                .tapOnNextButton();

        amountStep.onAmountScreen()
                .enterAmountToAmountField(firstCardGreaterBalanceAmountText)
                .verifyHelperMessageIsCorrect("Transfer amount is greater than account balance")
                .verifyConfirmButtonIsNotEnabled();
    }
}
