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
public class BackButtonOnCardsPage extends BaseTest {

    @TestRails(id = "c5883550")
    @Test(description = "Back button on 'Cards' page", groups = {"Functional"})
    public void c5883550() {
        loginUser();
        promoStep.tapOnOrderACard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnBackButton();
        promoStep.verifyPromoScreenIsOpen();
    }
}