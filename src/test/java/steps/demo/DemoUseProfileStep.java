package steps.demo;

import api.pages.demo.DemoUserProfileScreen;
import io.qameta.allure.Step;

public class DemoUseProfileStep {

    protected DemoUserProfileScreen demoUserProfileScreen;

    @Step("On DemoUseProfileScreen")
    public void onDemoUseProfileScreen() {
        demoUserProfileScreen = new DemoUserProfileScreen();
    }

    @Step("Verify demo use profile screen is open")
    public void verifyDemoUseProfileScreenIsOpen() {
        demoUserProfileScreen.verifyPageIsOpened();
    }
}
