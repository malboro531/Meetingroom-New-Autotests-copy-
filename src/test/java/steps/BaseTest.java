package steps;

import api.managers.TokenManager;
import driver.manager.DriverManager;
import helpers.AlertHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.api.AuthenticationApiStep;
import steps.api.NotificationApiStep;
import steps.cards.MyCardDetailsStep;
import steps.cards.MyCardManageStep;
import steps.demo.DemoUseProfileStep;
import steps.demo.UseDemoStep;
import steps.deposits.*;
import steps.order_cards.*;
import steps.products.*;
import steps.products.account.*;
import steps.transfers.*;
import verification.Verify;

import java.lang.reflect.Method;

import static constants.Configuration.APP_PACKAGE;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;
import static constants.TestRail.IS_ADD_RUN_REQUIRED;
import static constants.TestRail.IS_ADD_STATUS_REQUIRED;
import static helpers.FakeGenerator.getInvalidConfirmCode;

public class BaseTest implements TestRailAble {

    protected AppiumDriver driver;
    protected WelcomeStep welcomeStep = new WelcomeStep();
    protected LoginStep loginStep = new LoginStep();
    protected ConfirmationCodeStep confirmationCodeStep = new ConfirmationCodeStep();
    protected FilterStep filterStep = new FilterStep();
    protected PromoStep promoStep = new PromoStep();
    protected MainStep mainStep = new MainStep();
    protected MoreStep moreStep = new MoreStep();
    protected UserProfileStep userProfileStep = new UserProfileStep();
    protected UserNotificationsStep userNotificationsStep = new UserNotificationsStep();
    protected SetNewEmailStep setNewEmailStep = new SetNewEmailStep();
    protected ConfirmChangedEmailStep confirmChangedEmailStep = new ConfirmChangedEmailStep();
    protected PersonalCabinetStep personalCabinetStep = new PersonalCabinetStep();
    protected RegistrationAddressStep registrationAddressStep = new RegistrationAddressStep();
    protected UserSafetyScreenSteps userSafetyScreenSteps = new UserSafetyScreenSteps();
    protected SetApplicationPasswordScreenSteps setApplicationPasswordScreenSteps = new SetApplicationPasswordScreenSteps();
    protected EnterApplicationPasswordScreenStep enterApplicationPasswordScreenStep = new EnterApplicationPasswordScreenStep();
    protected ProductsStep productsStep = new ProductsStep();
    protected CardsStep cardsStep = new CardsStep();
    protected OpenCreditStep openCreditsStep = new OpenCreditStep();
    protected OpenDepositStep openDepositStep = new OpenDepositStep();
    protected OpenCardStep openCardStep = new OpenCardStep();
    protected DepositsStep depositsStep = new DepositsStep();
    protected OpenAccountStep openAccountStep = new OpenAccountStep();
    protected AccountCreateMenuStep accountCreateMenuStep = new AccountCreateMenuStep();
    protected OpenAccountCreatingStep openAccountCreatingStep = new OpenAccountCreatingStep();
    protected OpenAccountPersonalStep openAccountPersonalStep = new OpenAccountPersonalStep();
    protected OpenAccountRegAddressStep openAccountRegAddressStep = new OpenAccountRegAddressStep();
    protected OpenAccountDocumentsStep openAccountDocumentsStep = new OpenAccountDocumentsStep();
    protected OpenAccountReedDocStep openAccountReedDocStep = new OpenAccountReedDocStep();
    protected MyCardDetailsStep myCardDetailsStep = new MyCardDetailsStep();
    protected MyCardManageStep myCardManageStep = new MyCardManageStep();
    protected DepositDetailsStep depositDetailsStep = new DepositDetailsStep();
    protected SelectionStep selectionStep = new SelectionStep();
    protected DepositDescriptionsStep depositDescriptionsStep = new DepositDescriptionsStep();
    protected SelectAccountStep selectAccountStep = new SelectAccountStep();
    protected SelectionResultsStep selectionResultsStep = new SelectionResultsStep();
    protected MainOrderCardStep mainOrderCardStep = new MainOrderCardStep();
    protected CardDetailsStep cardDetailsStep = new CardDetailsStep();
    protected OwnCardDetailsStep ownCardDetailsStep = new OwnCardDetailsStep();
    protected CardProcessingStep cardProcessingStep = new CardProcessingStep();
    protected PersonalDataStep personalDataStep = new PersonalDataStep();
    protected PersonalDataRegistrationAdressStep personalDataRegistrationAdressStep = new PersonalDataRegistrationAdressStep();
    protected TwoButtonsConfirmationScreenStep twoButtonsConfirmationScreenStep = new TwoButtonsConfirmationScreenStep();
    protected DocumentsStep documentsStep = new DocumentsStep();
    protected PassportDetailsScreenStep passportDetailsScreenStep = new PassportDetailsScreenStep();
    protected FirstDocumentStep firstDocumentStep = new FirstDocumentStep();
    protected SecondDocumentStep secondDocumentStep = new SecondDocumentStep();
    protected ThirdDocumentStep thirdDocumentStep = new ThirdDocumentStep();
    protected OrderConfirmationStep orderConfirmationStep = new OrderConfirmationStep();
    protected CityStep cityStep = new CityStep();
    protected DeliveryMethodStep deliveryMethodStep = new DeliveryMethodStep();
    protected ConfirmationCodeOptionsStep confirmationCodeOptionsStep = new ConfirmationCodeOptionsStep();
    protected TokenManager tokenManager = new TokenManager();
    protected NotificationApiStep notificationApiStep = new NotificationApiStep();
    protected ChangePasswordStep changePasswordStep = new ChangePasswordStep();
    protected TransfersStep transfersStep = new TransfersStep();
    protected TransferByCardNumberStep transferByCardNumberStep = new TransferByCardNumberStep();
    protected TransfersToConnectedCardStep transfersToConnectedCardStep = new TransfersToConnectedCardStep();
    protected AmountStep amountStep = new AmountStep();
    protected ConfirmationTransferStep confirmationTransferStep = new ConfirmationTransferStep();
    protected TransferResultStep transferResultStep = new TransferResultStep();
    protected AuthenticationApiStep authenticationApiStep = new AuthenticationApiStep();
    protected Hooks hooks = new Hooks();
    protected AlertHelper alertHelper = new AlertHelper();
    protected OpenChooseCreditStep openChooseCreditStep = new OpenChooseCreditStep();
    protected OpenInlayInformationStep openInlayInformationStep = new OpenInlayInformationStep();
    protected HomeSettingsStep homeSettingsStep = new HomeSettingsStep();
    protected NewAccountStep newAccountStep = new NewAccountStep();
    protected AccountCreatedStep accountCreatedStep = new AccountCreatedStep();
    protected CommonStep commonStep = new CommonStep();
    protected UseDemoStep useDemoStep = new UseDemoStep();
    protected DemoUseProfileStep demoUseProfileStep = new DemoUseProfileStep();

    @BeforeClass
    public void testBeforeClass() {
        if (IS_ADD_RUN_REQUIRED) {
            hooks.addRun(getClass());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverManager.getDriver();
        ((AndroidDriver) driver).activateApp(APP_PACKAGE);
        alertHelper.acceptAlertIfPresented();
    }

    public void activateAppWithoutAlert() {
        driver = DriverManager.getDriver();
        ((AndroidDriver) driver).activateApp(APP_PACKAGE);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method, ITestResult result) throws InterruptedException {
        if (driver != null) {
            terminateApp();
        }
        if (IS_ADD_STATUS_REQUIRED) {
            hooks.setStatusWrapper(method, result, getClass());
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("adb shell pm clear com.example.meetingroom_new_android");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConfirmCode() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        return notificationApiStep.getEmailNotificationAll().body().getCode();
    }

    @AfterMethod(alwaysRun = true)
    public void userLogout() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        authenticationApiStep.userLogout(tokenManager.getRefreshToken());
    }

    public String getExactlyInvalidConfirmCode() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        String validCode = notificationApiStep.getEmailNotificationAll().body().getCode();
        String invalidCode = getInvalidConfirmCode();
        if (validCode.equals(invalidCode))
            invalidCode = getInvalidConfirmCode();
        return invalidCode;
    }

    public void loginUser() {
        welcomeStep.onWelcomeScreen();
        if (welcomeStep.isWelcomeScreenIsOpen()) {
            welcomeStep.tapOnLoginButton();
            loginStep.onLoginScreen();
            loginStep.enterLoginToLoginField(VALID_LOGIN_USER);
            loginStep.enterPasswordToPasswordField(VALID_PASSWORD_USER);
            loginStep.tapOnLogInButton();
            confirmationCodeStep.onConfirmScreen();
            confirmationCodeStep.waitSecondCode();
            confirmationCodeStep.enterConfirmationCodeToField(getConfirmCode());
            confirmationCodeStep.tapOnConfirmButton();
            //promoStep.onPromoScreen();
            //promoStep.tapOnCrossImage();
        }
    }

    public void terminateApp() {
        ((AndroidDriver) driver).terminateApp(APP_PACKAGE);
    }

    public void keyboardIsShown() {
        Verify.verifyTrue(((AndroidDriver) driver).isKeyboardShown(), "Keyboard is open");
    }

    public void goToMoreScreen() {
        loginUser();
        mainStep.onMainScreen();
        mainStep.tapOnMoreButton();
    }
}
