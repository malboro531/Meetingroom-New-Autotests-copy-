package mrn_tests.E4_order_card.UC_4_6;

import org.testng.annotations.BeforeMethod;
import steps.cards.BlockCardAlertStep;
import steps.cards.BlockCardStep;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.*;
import static constants.GlobalData.*;
import static driver.manager.DriverManager.tapBackOnDevice;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_6)
public class CardBlockingTest extends BaseTest {
    private BlockCardStep blockCardStep = new BlockCardStep();
    private BlockCardAlertStep blockCardAlertStep = new BlockCardAlertStep();

    @BeforeMethod
    public void openAppAndCardsSection() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        tapBackOnDevice();
        productsStep.onProductsScreen();
        productsStep.tapOnCardsInlay();
        productsStep.tapOnCardImage();
    }

    @TestRails(id = "C6119829")
    @Test(description = "Cancellation of the card blocking operation", groups = {"Smoke", "Sanity"})
    public void c6119829() {
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
        myCardDetailsStep.tapOnTabManage();

        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.tapOnBlockCardSwitch();

        blockCardStep.onBlockCardFrame();
        blockCardStep.verifyAlertTitleText(BLOCK_CARD_ALERT_TITLE);
        blockCardStep.verifyAlertMessageText(BLOCK_CARD_ALERT_MESSAGE);
        blockCardStep.tapOnCancelButton();

        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.tapOnDetailsTab();

        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyCardStatusText(CARD_STATUS_ACTIVE);
    }

    @TestRails(id = "C6119753")
    @Test(description = "Blocking ACTIVE-status card", groups = {"Smoke", "Sanity"})
    public void c6119753() {
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
        myCardDetailsStep.tapOnTabManage();

        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.tapOnBlockCardSwitch();

        blockCardStep.onBlockCardFrame();
        blockCardStep.verifyAlertTitleText(BLOCK_CARD_ALERT_TITLE);
        blockCardStep.verifyAlertMessageText(BLOCK_CARD_ALERT_MESSAGE);
        blockCardStep.tapOnConfirmButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        blockCardAlertStep.onBlockConfirmationFrame();
        blockCardAlertStep.verifyAlertTitleText(BLOCK_CARD_CONFIRMATION_ALERT_TITLE);
        blockCardAlertStep.verifyAlertMessageText(BLOCK_CARD_CONFIRMATION_ALERT_MESSAGE);
        blockCardAlertStep.tapOnConfirmButton();

        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyCardStatusText(CARD_STATUS_BLOCKED);

        myCardDetailsStep.onMyCardDetailsScreen();
    }
}
