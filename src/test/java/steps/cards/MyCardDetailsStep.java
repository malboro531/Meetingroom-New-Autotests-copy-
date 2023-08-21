package steps.cards;

import api.pages.products.MyCardDetailsScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class MyCardDetailsStep {

    public MyCardDetailsScreen myCardDetailsScreen;

    @Step("On MyCardScreen")
    public void onMyCardDetailsScreen() {
        myCardDetailsScreen = new MyCardDetailsScreen();
    }

    @Step("Verify card Details page is opened")
    public void verifyMyCardDetailsIsOpen() {
        myCardDetailsScreen.verifyPageIsOpened();
    }

    @Step("Transfer to tab Manage")
    public void tapOnTabManage() {
        myCardDetailsScreen.tapOnTabManage();
    }

    @Step("Transfer to tab Details")
    public void tapOnTabDetails() {
        myCardDetailsScreen.tapOnTabDetails();
    }

    @Step("Tap on back button")
    public void tapOnBackButton() {
        myCardDetailsScreen.tapOnBackButton();
    }

    @Step("Check that card status is correct")
    public void verifyCardStatusText(String text) {
        Verify.verifyEquals(text, myCardDetailsScreen.getCardStatusText(), "Card status is correct");
    }
}
