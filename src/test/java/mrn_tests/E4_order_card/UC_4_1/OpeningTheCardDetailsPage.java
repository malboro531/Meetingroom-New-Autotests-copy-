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
public class OpeningTheCardDetailsPage extends BaseTest {

    @TestRails(id = "c6034034")
    @Test(description = "Opening the Card details page", groups = "Other")
    public void c6034034() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();

        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
    }
}
