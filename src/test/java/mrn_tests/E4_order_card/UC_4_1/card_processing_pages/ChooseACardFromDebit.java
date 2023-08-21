package mrn_tests.E4_order_card.UC_4_1.card_processing_pages;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;
import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_1;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_1)
public class ChooseACardFromDebit extends BaseTest {

    @TestRails(id = "c5993714")
    @Test(description = "Card details screen", groups = "Functional")
    public void c5993714() {
        loginUser();
        promoStep.swipeFromOrderCard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnFirstDebitCard();
        cardDetailsStep.onCardDetails();
        cardDetailsStep.verifyIsCardDetailsOpen();
    }

    @TestRails(id = "c5993713")
    @Test(description = "Choose a card from Debit", groups = "Functional")
    public void c5993713() {
        loginUser();
        promoStep.swipeFromOrderCard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnRandomDebitCard();
        cardDetailsStep.onCardDetails();
        cardDetailsStep.verifyIsCardDetailsOpen();
    }

    @TestRails(id = "c5888160")
    @Test(description = "Back button on the Card details page", groups = "Functional")
    public void c5888160() {
        loginUser();
        promoStep.swipeFromOrderCard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnRandomDebitCard();

        cardDetailsStep.onCardDetails();
        cardDetailsStep.tapReturnButton();

        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.verifyMainOrderCardScreenIsOpen();
    }

    @TestRails(id = "c5888161")
    @Test(description = "Back button on the Card processing page", groups = "Functional")
    public void c5888161() {
        loginUser();
        promoStep.swipeFromOrderCard();
        mainOrderCardStep.onMainOrderCardScreen();
        mainOrderCardStep.tapOnRandomDebitCard();

        cardDetailsStep.onCardDetails();
        cardDetailsStep.tapOrderCardButton();

        cardProcessingStep.onCardProcessingScreen();
        cardProcessingStep.tapReturnButton();

        cardDetailsStep.onCardDetails();
        cardDetailsStep.verifyIsCardDetailsOpen();
    }


}
