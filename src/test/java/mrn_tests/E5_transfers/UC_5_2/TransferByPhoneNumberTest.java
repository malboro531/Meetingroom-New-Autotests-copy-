package mrn_tests.E5_transfers.UC_5_2;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;
import steps.transfers.ConfirmationByPhoneTransferStep;
import steps.transfers.DetailsForTransferByPhoneNumberStep;
import steps.transfers.TransferByPhoneNumberStep;
import steps.transfers.TransferResultStep;

import static constants.AllureData.EPIC_5_TRANSFERS;
import static constants.AllureData.FEATURE_UC_5_2;
import static constants.GlobalData.*;
import static driver.manager.DriverManager.closeDeviceKeyboard;
import static verification.VerifySoft.showAllChecking;

@Epic(EPIC_5_TRANSFERS)
@Feature(FEATURE_UC_5_2)
public class TransferByPhoneNumberTest extends BaseTest {
    private TransferByPhoneNumberStep transferByPhoneNumberStep = new TransferByPhoneNumberStep();
    private DetailsForTransferByPhoneNumberStep detailsForTransferByPhoneNumberStep = new DetailsForTransferByPhoneNumberStep();
    private ConfirmationByPhoneTransferStep confirmationByPhoneTransferStep = new ConfirmationByPhoneTransferStep();
    private TransferResultStep transferResultStep = new TransferResultStep();

    public void openAppAndChooseTransferByPhoneNumber() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnTransfersButton();
        transfersStep.onTransfersScreen();
        transfersStep.tapOnTransferByPhoneNumberButton();
    }

    @TestRails(id = "C6271898")
    @Test(description = "Transfer by phone number with valid credentials", groups = {"Smoke", "Sanity"})
    public void c6271898() {
        openAppAndChooseTransferByPhoneNumber();
        transferByPhoneNumberStep.onTransferByPhoneNumberScreen();
        transferByPhoneNumberStep.verifyContinueButtonNotEnabled();
        transferByPhoneNumberStep.tapOnFromAccountField();
        transferByPhoneNumberStep.tapOnClickableAreaForAccountSelection();
        transferByPhoneNumberStep.tapOnPhoneNumberField();
        transferByPhoneNumberStep.enterPhoneToPhoneNumberField(VALID_PHONE_NUMBER);
        closeDeviceKeyboard();
        transferByPhoneNumberStep.tapToContinueButton();

        detailsForTransferByPhoneNumberStep.onDetailsForTransferByPhoneNumberScreen();
        detailsForTransferByPhoneNumberStep.verifyConfirmButtonNotEnabled();
        detailsForTransferByPhoneNumberStep.tapOnEnterAmountField();
        detailsForTransferByPhoneNumberStep.enterSumToEnterAmountField(AMOUNT_1);
        detailsForTransferByPhoneNumberStep.tapOnTransferAssignmentField();
        detailsForTransferByPhoneNumberStep.enterMessageToTransferAssignmentField(TRANSFER_ASSIGNMENT_MESSAGE);
        closeDeviceKeyboard();
        detailsForTransferByPhoneNumberStep.tapOnConfirmButton();

        confirmationByPhoneTransferStep.onConfirmationByPhoneTransferScreen();
        confirmationByPhoneTransferStep.verifyFromAccountFieldText(VALID_ACCOUNT_NUMBER);
        confirmationByPhoneTransferStep.verifyPhoneNumberFieldText(VALID_PHONE_NUMBER);
        confirmationByPhoneTransferStep.verifyAmountFieldText(AMOUNT_1);
        confirmationByPhoneTransferStep.verifyTransferAssignmentFieldText(TRANSFER_ASSIGNMENT_MESSAGE);
        confirmationByPhoneTransferStep.tapOnTransferButton();

        transferResultStep.onTransferResultScreen();
        transferResultStep.verifyResultFieldDisplaysCorrectText("Transfer has been successfully sent");
        transferResultStep.verifyIsBackToMainButtonEnabled();
        transferResultStep.tapToBackToMainMenuButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
        showAllChecking();
    }
}
