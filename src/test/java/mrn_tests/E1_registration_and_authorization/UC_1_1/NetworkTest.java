package mrn_tests.E1_registration_and_authorization.UC_1_1;

import api.services.TestRails;
import constants.BitMask;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTest;

import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.AllureData.FEATURE_UC_1_1;
import static constants.GlobalData.NOT_VALID_PASSWORD;
import static driver.manager.DriverManager.setNetworkConnection;
import static helpers.WordProcessor.generateLoginByLength;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(FEATURE_UC_1_1)
public class NetworkTest extends BaseTest {

    @TestRails(id = "C5867988")
    @Test(description = "Server connection error during registration", groups = {"Other"})
    public void c5867988() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        setNetworkConnection(BitMask.ALL_NETWORK_OFF);
        //TODO — The pop-up screen is displayed
    }

    @TestRails(id = "C5868141")
    @Test(description = "Hotline call", groups = {"Other"})
    public void c5868141() {
        welcomeStep.onWelcomeScreen();
        welcomeStep.tapOnLoginButton();
        loginStep.onLoginScreen();
        loginStep.verifyLoginScreenIsOpen();
        for (int i = 0; i < 2; i++) {
            loginStep.enterLoginToLoginField(generateLoginByLength(20));
            loginStep.verifySymbolsAreCorrectlyInLoginField(generateLoginByLength(20));
            loginStep.enterPasswordToPasswordField(NOT_VALID_PASSWORD);
            loginStep.verifySymbolsAreCorrectlyInPasswordField(NOT_VALID_PASSWORD, true);
            loginStep.tapOnLogInButton();
        }
        loginStep.verifyInvalidPopUp("Invalid login details");
        loginStep.tapOnHotlinePhone();
        // TODO - Verify that user is redirected and phone number is dialed
    }

}
