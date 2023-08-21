package mrn_tests.E4_order_card.UC_4_1;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import steps.BaseTest;
import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_1;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_1)
public class SwipeCreditCard extends BaseTest {

    @Ignore//Требуется создание локаторов для написания проверки сдвига карты
    //Тест перемещен в бэклог MRN-1551
    @TestRails(id = "c6058128")
    @Test(description = "Swipe credit card", groups = {"GUI"})
    public void c6058128() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();

        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();

        productsStep.onProductsScreen();
        productsStep.swipeCardImageInlayToLeft();
        productsStep.swipeCardImageInlayToRight();
    }
}