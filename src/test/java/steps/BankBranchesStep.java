package steps;

import api.pages.BankBranchesScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class BankBranchesStep {

    protected BankBranchesScreen bankBranchesScreen;

    @Step("On 'Bank branches' screen")
    public void onBankBranchesScreen() {
        bankBranchesScreen = new BankBranchesScreen();
    }

    @Step("Verify bank branches title")
    public void verifyBankBranchesTitleText(String title) {
        Verify.verifyEquals(bankBranchesScreen.getTitleText(), title, "Bank branches title is correct");
    }

    @Step("Verify that back button is enabled")
    public void verifyBackButtonIsEnabled() {
        Verify.verifyTrue(bankBranchesScreen.isBackButtonEnabled(), "Back button is enabled");
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        bankBranchesScreen.tapToBackButton();
    }
}
