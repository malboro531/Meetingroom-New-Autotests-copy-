package mrn_tests.E5_transfers.UC_5_3;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseTest;
import steps.transfers.*;

import static constants.AllureData.*;
import static constants.GlobalData.*;
import static driver.manager.DriverManager.closeDeviceKeyboard;
import static verification.VerifySoft.showAllChecking;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_3)
public class TransferByAccountNumberTest extends BaseTest {

    private TransferByAccountNumberStep transferByAccountNumberStep = new TransferByAccountNumberStep();

    private DetailsForTransferByPhoneNumberStep detailsForTransferByPhoneNumberStep = new DetailsForTransferByPhoneNumberStep();

    private ConfirmationByAccountTransferStep confirmationByAccountTransferStep = new ConfirmationByAccountTransferStep();

    private TransferResultStep transferResultStep = new TransferResultStep();

    @BeforeMethod
    public void openAppAndChooseTransferByAccountNumber() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnTransfersButton();
        transfersStep.onTransfersScreen();
        transfersStep.tapOnTransferByAccountNumberButton();
    }

    @TestRails(id = "C6312932")
    @Test(description = "Transfer by account number of an amount less than $100", groups = {"Smoke", "Sanity"})
    public void c6312932() {
        transferByAccountNumberStep.onTransferByPhoneNumberScreen();
        transferByAccountNumberStep.verifyNextButtonNotEnabled();
        transferByAccountNumberStep.enterAccountToFromAccountField();
        String fromAccount = transferByAccountNumberStep.getFromAccountText();
        transferByAccountNumberStep.tapOnClickableAreaForFromAccountSelection();
        transferByAccountNumberStep.tapToToAccountField();
        transferByAccountNumberStep.enterAccountToToAccountField(VALID_TO_ACCOUNT_NUMBER);
        closeDeviceKeyboard();
        String recipient = transferByAccountNumberStep.getRecipientText();
        transferByAccountNumberStep.tapToNextButton();

        detailsForTransferByPhoneNumberStep.onDetailsForTransferByPhoneNumberScreen();
        detailsForTransferByPhoneNumberStep.verifyConfirmButtonNotEnabled();
        detailsForTransferByPhoneNumberStep.tapOnEnterAmountField();
        detailsForTransferByPhoneNumberStep.enterSumToEnterAmountField(AMOUNT_1);
        detailsForTransferByPhoneNumberStep.tapOnTransferAssignmentField();
        detailsForTransferByPhoneNumberStep.enterMessageToTransferAssignmentField(TRANSFER_ASSIGNMENT_MESSAGE);
        closeDeviceKeyboard();
        detailsForTransferByPhoneNumberStep.tapOnConfirmButton();

        confirmationByAccountTransferStep.onConfirmationByAccountTransferScreen();
        confirmationByAccountTransferStep.verifyFromAccountFieldText(fromAccount);
        confirmationByAccountTransferStep.verifyToAccountFieldText(VALID_TO_ACCOUNT_NUMBER);
        confirmationByAccountTransferStep.verifyRecipientFieldText(recipient);
        confirmationByAccountTransferStep.verifyAmountFieldText(AMOUNT_1);
        confirmationByAccountTransferStep.verifyTransferAssignmentFieldText(TRANSFER_ASSIGNMENT_MESSAGE);
        confirmationByAccountTransferStep.tapOnTransferButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent");
        transferResultStep.verifyIsBackToMainButtonEnabled();
        transferResultStep.tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }

    @TestRails(id = "C6312933")
    @Test(description = "Transfer by account number of an amount more than $100", groups = {"Smoke", "Sanity"})
    public void c6312933() {
        transferByAccountNumberStep.onTransferByPhoneNumberScreen();
        transferByAccountNumberStep.verifyNextButtonNotEnabled();
        transferByAccountNumberStep.enterAccountToFromAccountField();
        String fromAccount = transferByAccountNumberStep.getFromAccountText();
        transferByAccountNumberStep.tapOnClickableAreaForFromAccountSelection();
        transferByAccountNumberStep.tapToToAccountField();
        transferByAccountNumberStep.enterAccountToToAccountField(VALID_TO_ACCOUNT_NUMBER);
        closeDeviceKeyboard();
        String recipient = transferByAccountNumberStep.getRecipientText();
        transferByAccountNumberStep.tapToNextButton();

        detailsForTransferByPhoneNumberStep.onDetailsForTransferByPhoneNumberScreen();
        detailsForTransferByPhoneNumberStep.verifyConfirmButtonNotEnabled();
        detailsForTransferByPhoneNumberStep.tapOnEnterAmountField();
        detailsForTransferByPhoneNumberStep.enterSumToEnterAmountField(AMOUNT_200);
        detailsForTransferByPhoneNumberStep.tapOnTransferAssignmentField();
        detailsForTransferByPhoneNumberStep.enterMessageToTransferAssignmentField(TRANSFER_ASSIGNMENT_MESSAGE);
        closeDeviceKeyboard();
        detailsForTransferByPhoneNumberStep.tapOnConfirmButton();

        confirmationByAccountTransferStep.onConfirmationByAccountTransferScreen();
        confirmationByAccountTransferStep.verifyFromAccountFieldText(fromAccount);
        confirmationByAccountTransferStep.verifyToAccountFieldText(VALID_TO_ACCOUNT_NUMBER);
        confirmationByAccountTransferStep.verifyRecipientFieldText(recipient);
        confirmationByAccountTransferStep.verifyAmountFieldText(AMOUNT_200);
        confirmationByAccountTransferStep.verifyTransferAssignmentFieldText(TRANSFER_ASSIGNMENT_MESSAGE);
        confirmationByAccountTransferStep.tapOnTransferButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmTransferButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent");
        transferResultStep.verifyIsBackToMainButtonEnabled();
        transferResultStep.tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }
}
