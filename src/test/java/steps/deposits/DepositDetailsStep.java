package steps.deposits;

import api.pages.deposits.DepositDetailsScreen;
import io.qameta.allure.Step;

public class DepositDetailsStep {

    protected DepositDetailsScreen depositDetailsScreen;

    @Step("On DepositsScreen")
    public void onDepositDetailsScreen() {
        depositDetailsScreen = new DepositDetailsScreen();
    }

    @Step("Tap on Back Button")
    public void tapOnBackButton() {
        depositDetailsScreen.tapOnBackButton();
    }

}
