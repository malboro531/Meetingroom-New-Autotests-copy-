package mrn_tests.E4_order_card.UC_4_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_1;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_1)
public class SwitchingBetweenDebitAndCreditTypes extends BaseTest {

    @TestRails(id = "c5885541")
    @Test(description = "Switching between debit and credit types", groups = {"Functional"})
    public void c5885541() {
        loginUser();
        promoStep.swipeFromOrderCard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnCreditButton();
        mainOrderCardStep.verifyCreditButtonIsSelected();
        mainOrderCardStep.tapOnDebitButton();
        mainOrderCardStep.verifyDebitButtonIsSelected();
    }
}
