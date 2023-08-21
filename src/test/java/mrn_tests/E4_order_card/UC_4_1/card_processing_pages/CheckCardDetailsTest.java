package mrn_tests.E4_order_card.UC_4_1.card_processing_pages;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.AllureData.FEATURE_UC_4_1;

@Epic(EPIC_4_ORDER_CARD)
@Feature(FEATURE_UC_4_1)
public class CheckCardDetailsTest extends BaseTest {

    @BeforeMethod
    public void doLoginUser() {
        loginUser();
    }

    @TestRails(id = "c6099515")
    @Test(description = "Check, that tab 'Card Details' is displaying", groups = {"GUI"})
    public void c6099515() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
    }

    @TestRails(id = "c6099518")
    @Test(description = "Check, that tab 'Manage' is displaying", groups = {"GUI"})
    public void c6099518() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.tapOnTabManage();
        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.verifyMyCardManageScreeIsOpen();
    }

    @TestRails(id = "c6099564")
    @Test(description = "Check, that tab 'Card Details' and 'My products' is displaying after visited tab 'Manage'", groups = {"GUI"})
    public void c6099564() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.tapOnTabManage();
        myCardDetailsStep.tapOnTabDetails();
        myCardDetailsStep.verifyMyCardDetailsIsOpen();
        myCardDetailsStep.tapOnBackButton();
        productsStep.verifyProductsIsOpen();
        productsStep.verifyCardsInlaySelected();
    }

    @TestRails(id = "c6099571")
    @Test(description = "Check, that page 'My products' is displaying after pressing 'back' button on tab 'Manage'", groups = {"GUI"})
    public void c6099571() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.tapOnTabManage();
        myCardDetailsStep.tapOnBackButton();
        productsStep.verifyProductsIsOpen();
    }

    @TestRails(id = "c6099570")
    @Test(description = "Check, that tab 'Manage' is displaying after transfer to 'Details' and come back", groups = {"GUI"})
    public void c6099570() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        productsStep.onProductsScreen();
        productsStep.tapOnCardImage();
        myCardDetailsStep.onMyCardDetailsScreen();
        myCardDetailsStep.tapOnTabManage();
        myCardManageStep.onMyCardManageScreen();
        myCardManageStep.verifyMyCardManageScreeIsOpen();
        myCardDetailsStep.tapOnTabDetails();
        myCardDetailsStep.tapOnTabManage();
        myCardManageStep.verifyMyCardManageScreeIsOpen();
    }
}
