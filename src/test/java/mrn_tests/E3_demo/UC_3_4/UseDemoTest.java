package mrn_tests.E3_demo.UC_3_4;

import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseDemoTest;

import static constants.AllureData.EPIC_3_DEMO;
import static constants.AllureData.FEATURE_UC_3_4;

@Epic(EPIC_3_DEMO)
@Feature(FEATURE_UC_3_4)
public class UseDemoTest extends BaseDemoTest {

    @BeforeMethod
    public void transitionToDemoScreen() {
        goToDemoScreen();
    }

    @TestRails(id = "C6076296")
    @Test(description = "Checking the transition to Demo", groups = {"Smoke & Sanity"})
    public void c6076296() {
        useDemoStep.tapOnImageViewMain();
        demoUseProfileStep.onDemoUseProfileScreen();
        demoUseProfileStep.verifyDemoUseProfileScreenIsOpen();
    }

    @TestRails(id = "C6076317")
    @Test(description = "Checking the transition to 'My Products'", groups = {"Functional"})
    public void C6076317() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        productsStep.onProductsScreen();
        productsStep.verifyProductsIsOpen();
    }

    @TestRails(id = "C6076338")
    @Test(description = "Checking the transition to 'My Products - Cards'", groups = {"Functional"})
    public void C6076338() {
        mainStep.onMainScreen();
        mainStep.tapOnProductsButton();
        openCardStep.onOpenCardScreen();
        openCardStep.tapOnGotItButton();
        openCardStep.verifyOpenCardScreenIsOpen();
    }

    @TestRails(id = "C6076378")
    @Test(description = "Checking the transition to 'My Products - Accounts'", groups = {"Functional"})
    public void C6076378() {
        goToProductsScreen();
        productsStep.tapOnAccountsInlay();
        openAccountStep.onOpenAccountScreen();
        openAccountStep.tapOnAddAccountButton();
        openAccountStep.verifyOpenAccountScreenIsOpen();
    }

    @TestRails(id = "C6076383")
    @Flaky
    @Test(description = "Checking the transition to 'My Products - Credits'", groups = {"Functional"})
    public void C6076383() {
        goToProductsScreen();
        productsStep.tapOnCreditsInlay();
        openCreditsStep.onOpenCreditScreen();
        openCreditsStep.tapOnGotItButton();
        openCreditsStep.verifyCreditScreenIsOpen();
    }

    @TestRails(id = "C6076387")
    @Test(description = "Checking the transition to 'My Products - Deposits'", groups = {"Functional"})
    public void C6076387() {
        goToProductsScreen();
        productsStep.tapOnDepositsInlay();
        openDepositStep.onOpenDepositScreen();
        openDepositStep.tapOnGotItButton();
        openDepositStep.verifyOpenDepositScreenIsOpen();
    }
}
