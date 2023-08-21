package steps.deposits;

import api.pages.deposits.DepositsScreen;
import io.qameta.allure.Step;
import verification.Verify;

import static verification.Verify.verifyTrue;

public class DepositsStep {

    protected DepositsScreen depositsScreen;

    @Step("On DepositsScreen")
    public void onDepositsScreen() {
        depositsScreen = new DepositsScreen();
    }

    @Step("Tap on GotItButton")
    public void tapOnPlusButton() {
        depositsScreen.tapOnPlusButton();
    }

    @Step("Tap on FilterButton")
    public void tapOnFilterButton() {
        depositsScreen.tapOnFilterButton();
    }

    @Step("Tap on the first Deposit")
    public void openTheFirstDeposit() {
        depositsScreen.tapOnFirstDeposit();
    }

    @Step("Verify DepositsScreen is Open")
    public void verifyDepositsScreenIsOpen() {
        depositsScreen.verifyPageIsOpened();
    }

    @Step("Verify List of Active Deposits is displayed")
    public void verifyDepositsListIsDisplayed() {
        verifyTrue(depositsScreen.isDepositListDisplayed(), "The list of deposits is displayed");
    }

    @Step ("Verify Plus button is displayed")
    public void verifyPlusButtonIsDisplayed() {
        verifyTrue(depositsScreen.isPlusButtonDisplayed(), "Plus button is displayed");
    }

    @Step("Verify Filter button is displayed")
    public void verifyFilterButtonIsDisplayed() {
        verifyTrue(depositsScreen.isFilterButtonDisplayed(), "Filter button is displayed");
    }

    @Step("Verify Search button is displayed")
    public void verifySearchButtonIsDisplayed() {
        verifyTrue(depositsScreen.isSearchButtonDisplayed(), "Search button is displayed");
    }

    @Step ("Verify empty Deposit page displays correct text")
    public void verifyEmptyDepositPageDisplaysCorrectText(String text) {
        Verify.verifyEquals(text, depositsScreen.getTextFromEmptyDepositPage(), "Deposit page displays correct text");
    }
}
