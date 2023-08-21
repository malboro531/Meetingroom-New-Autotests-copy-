package mrn_tests.E5_transfers.UC_5_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;
import static constants.GlobalData.*;
import static helpers.WordProcessor.generateCodeByLength;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_1)
public class TransferByInvalidCardNumberTests extends BaseTest {

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

    public void enterInvalidCardNumber(String cardNumber) {
        transferByCardNumberStep.choseSecondCardForTransactionOnTransferByCardNumberScreen()
                .tapOnToCardField()
                .enterCardNumberToToCardField(cardNumber)
                .verifyErrorMessageIsCorrect(THIS_PAYMENT_SYSTEM_IS_UNAVAILABLE_FOR_TRANSFERS)
                .verifyNextButtonIsNotEnabled();
    }

    @TestRails(id = "C5978514")
    @Test(description = "Input invalid card number in field 'To card' with inscription 'Enter recipient's card number'",
            groups = {"Smoke & Sanity"})
    public void c5978514() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.choseSecondCardForTransactionOnTransferByCardNumberScreen()
                .enterCardNumberToToCardField("4444444444444444")
                .verifyErrorMessageIsCorrect("Invalid card number");
    }

    @TestRails(id = "C5978516")
    @Test(description = "Transfer by card which start with 4 or 51,52,53,54,55 with 15 characters in field 'To card'",
            groups = {"Smoke & Sanity"})
    public void c5978516() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.choseSecondCardForTransactionOnTransferByCardNumberScreen()
                .tapOnToCardField()
                .enterCardNumberToToCardField("51" + generateCodeByLength(13))
                .verifyErrorMessageIsCorrect("Card number must contain 16 characters")
                .verifyNextButtonIsNotEnabled();
    }

    @TestRails(id = "C5978659")
    @Test(description = "Transfer to empty card number", groups = {"Smoke & Sanity"})
    public void c5978659() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.choseSecondCardForTransactionOnTransferByCardNumberScreen()
                .tapOnNextButton()
                .verifyToCardFieldDisplaysCorrectData(ENTER_RECIPIENTS_CARD_NUMBER);
    }

    @TestRails(id = "C5978662")
    @Test(description = "Input valid card number, delete card number via cross button",
            groups = {"Smoke & Sanity"})
    public void c5978662() {
        openAppAndChooseTransferByCardNumber();
        transferByCardNumberStep.choseSecondCardForTransactionOnTransferByCardNumberScreen()
                .enterCardNumberToToCardField(VALID_CARD_NUMBER)
                .tapOnToCardFieldCrossButton()
                .verifyToCardFieldDisplaysCorrectData(ENTER_RECIPIENTS_CARD_NUMBER);
    }

    @TestRails(id = "C5982739")
    @Test(description = "Enter card number starting with 3",
            groups = {"Smoke & Sanity"})
    public void c5982739() {
        openAppAndChooseTransferByCardNumber();
        String invalidCardNumber = "3" + generateCodeByLength(15);
        enterInvalidCardNumber(invalidCardNumber);
    }

    @TestRails(id = "C5982740")
    @Test(description = "Enter card number starting with 50",
            groups = {"Smoke & Sanity"})
    public void c5982740() {
        openAppAndChooseTransferByCardNumber();
        String invalidCardNumber = "50" + generateCodeByLength(14);
        enterInvalidCardNumber(invalidCardNumber);
    }

    @TestRails(id = "C5982741")
    @Test(description = "Enter card number starting with 56",
            groups = {"Smoke & Sanity"})
    public void c5982741() {
        openAppAndChooseTransferByCardNumber();
        String invalidCardNumber = "56" + generateCodeByLength(14);
        enterInvalidCardNumber(invalidCardNumber);
    }
}
