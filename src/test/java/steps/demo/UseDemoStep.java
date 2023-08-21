package steps.demo;

import api.pages.demo.DemoScreen;
import io.qameta.allure.Step;

public class UseDemoStep {

    protected DemoScreen demoScreen;

    @Step("On DemoScreen")
    public void onDemoScreen() {
        demoScreen = new DemoScreen();
    }

    @Step("Tap on image view Main")
    public void tapOnImageViewMain() {
        demoScreen.tapOnImageViewMain();
    }

    @Step("Verify demo screen is open")
    public void verifyDemoScreenIsOpen() {
        demoScreen.verifyPageIsOpened();
    }
}