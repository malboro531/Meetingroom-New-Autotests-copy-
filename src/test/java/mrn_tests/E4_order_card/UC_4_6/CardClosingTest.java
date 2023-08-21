package mrn_tests.E4_order_card.UC_4_6;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseTest;
import steps.cards.CloseCardStep;
import steps.cards.CloseCardSuccessStep;

import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_6;
import static constants.GlobalData.*;
import static driver.manager.DriverManager.tapBackOnDevice;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_6)
public class CardClosingTest extends BaseTest {

    private CloseCardStep closeCardStep = new CloseCardStep();

    private CloseCardSuccessStep closeCardSuccessStep = new CloseCardSuccessStep();

    @BeforeMethod
    public void openAppAndCardsSection() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        tapBackOnDevice();
        productsStep.onProductsScreen();
        productsStep.tapOnCardsInlay();
    }

    @TestRails(id = "C6169789")
    @Test(description = "Closing ACTIVE-status card", groups = {"Smoke", "Sanity"})
    public void c6169789() {

        productsStep.tapOnCardImage();

        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
        myCardDetailsStep.tapOnTabManage();

        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.tapOnCloseCard();

        closeCardStep.onCloseCardFrame();
        closeCardStep.verifyAlertTitleText(CLOSE_CARD_ALERT_TITLE);
        closeCardStep.verifyAlertMessageText(CLOSE_CARD_ALERT_MESSAGE);
        closeCardStep.tapOnConfirmButton();

        confirmationCodeStep.onConfirmScreen();
        confirmationCodeStep.waitSecondCode();
        confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
        confirmationCodeStep.tapOnConfirmButton();

        closeCardSuccessStep.onCloseCardSuccessScreen();
        closeCardSuccessStep.verifyCloseCardSuccessPageIsOpen();
        closeCardSuccessStep.verifyResultFieldDisplaysCorrectText(CLOSE_CARD_SUCCESS_MESSAGE);
        closeCardSuccessStep.tapOnPrimaryButton();

        mainStep.onMainScreen();
        mainStep.verifyMainScreenIsOpen();
    }
}
