package steps.cards;

import api.pages.products.MyCardManageScreen;
import io.qameta.allure.Step;

public class MyCardManageStep {

    public MyCardManageScreen myCardManageScreen;

    @Step("On MyCardManageScreen")
    public void onMyCardManageScreen() {
        myCardManageScreen = new MyCardManageScreen();
    }

    @Step("Verify card Manage page is open")
    public void verifyMyCardManageScreeIsOpen() {
        myCardManageScreen.verifyPageIsOpened();
    }

    @Step("Tap on block card switch")
    public void tapOnBlockCardSwitch() {
        myCardManageScreen.tapOnBlockCardSwitch();
    }

    @Step("Tap on details tab")
    public void tapOnDetailsTab() {
        myCardManageScreen.tapOnDetailsTab();
    }

    @Step("Tap on close card")
    public void tapOnCloseCard() {
        myCardManageScreen.tapOnCloseCard();
    }
}
