package steps;

import api.managers.*;
import api.managers.DataBaseManager.*;
import api.managers.InformationService.FileStorageManager;
import api.managers.InformationService.InformationManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import retrofit2.Response;
import steps.api.*;
import verification.VerifySoft;

import java.lang.reflect.Method;

import static constants.TestRail.IS_ADD_RUN_REQUIRED;
import static constants.TestRail.IS_ADD_STATUS_REQUIRED;

public class BaseApiTest implements TestRailAble {

    protected TokenManager tokenManager = new TokenManager();
    protected UserApiStep userApiStep = new UserApiStep();
    protected NotificationApiStep notificationApiStep = new NotificationApiStep();
    protected NotificationManager notificationManager = new NotificationManager();
    protected AddressApiStep addressApiStep = new AddressApiStep();
    protected AddressManager addressManager = new AddressManager();
    protected AccountApiStep accountApiStep = new AccountApiStep();
    protected AccountManager accountManager = new AccountManager();
    protected UserManager userManager = new UserManager();
    protected FileStorageApiStep fileStorageApiStep = new FileStorageApiStep();
    protected FileStorageManager fileStorageManager = new FileStorageManager();
    protected InformationApiStep informationApiStep = new InformationApiStep();
    protected InformationManager informationManager = new InformationManager();
    protected PassportApiStep passportApiStep = new PassportApiStep();
    protected PassportManager passportManager = new PassportManager();
    protected PersonalDataStep personalDataStep = new PersonalDataStep();
    protected PersonalDataManager personalDataManager = new PersonalDataManager();
    protected CardProductManager cardProductManager = new CardProductManager();
    protected CardProductApiStep cardProductApiStep = new CardProductApiStep();
    protected CardApiStep cardApiStep = new CardApiStep();
    protected CardManager cardManager = new CardManager();
    protected CardProductControllerDataBaseManager cardProductControllerDataBaseManager = new CardProductControllerDataBaseManager();
    protected CardProductDataBaseManager cardProductDataBaseManager = new CardProductDataBaseManager();
    protected TransferApiStep transferApiStep = new TransferApiStep();
    protected TransferManager transferManager = new TransferManager();
    protected TransferDataBaseManager transferDBManager = new TransferDataBaseManager();
    protected DepositProductApiStep depositProductApiStep = new DepositProductApiStep();
    protected DepositApiStep depositApiStep = new DepositApiStep();
    protected CreditProductApiStep creditProductApiStep = new CreditProductApiStep();
    protected CreditAccountApiStep creditAccountApiStep = new CreditAccountApiStep();
    protected DepositProductManager depositProductManager = new DepositProductManager();
    protected DepositManager depositManager = new DepositManager();
    protected DepositProductDataBaseManager depositProductDBManager = new DepositProductDataBaseManager();
    protected DepositDataBaseManager depositDBManager = new DepositDataBaseManager();
    protected AddressDataBaseManager addressDbManager = new AddressDataBaseManager();
    protected PassportDataBaseManager passportDbManager = new PassportDataBaseManager();
    protected AccountDataBaseManager accountDbManager = new AccountDataBaseManager();
    protected CreditProductManager creditProductManager = new CreditProductManager();
    protected CreditAccountManager creditAccountManager = new CreditAccountManager();
    protected CreditProductDataBaseManager creditProductDBManager = new CreditProductDataBaseManager();
    protected CreditAccountDataBaseManager creditAccountDataBaseManager = new CreditAccountDataBaseManager();

    protected UserDataBaseManager userDbManager = new UserDataBaseManager();
    protected RegularPaymentApiStep regularPaymentApiStep = new RegularPaymentApiStep();
    protected RegularPaymentManager regularPaymentManager = new RegularPaymentManager();
    protected RegularPaymentDataBaseManager regularPaymentDBManager = new RegularPaymentDataBaseManager();
    protected CreditProductDataBaseManager creditProductDataBaseManager = new CreditProductDataBaseManager();
    protected CardDataBaseManager cardDataBaseManager = new CardDataBaseManager();
    protected CreditCardProductApiStep creditCardProductApiStep = new CreditCardProductApiStep();
    protected CreditCardProductManager creditCardProductManager = new CreditCardProductManager();
    protected CreditCardProductDataBaseManager creditCardProductDBManager = new CreditCardProductDataBaseManager();
    protected CreditCardManager creditCardManager = new CreditCardManager();
    protected CreditCardApiStep creditCardApiStep = new CreditCardApiStep();
    protected CreditCardDataBaseManager creditCardDataBaseManager = new CreditCardDataBaseManager();
    protected CreditOrderApiStep creditOrderApiStep = new CreditOrderApiStep();
    protected CreditOrderManager creditOrderManager = new CreditOrderManager();
    protected CreditOrderDataBaseManager creditOrderDataBaseManager = new CreditOrderDataBaseManager();
    protected CreditPenaltyApiStep creditPenaltyApiStep = new CreditPenaltyApiStep();
    protected CreditPenaltyManager creditPenaltyManager = new CreditPenaltyManager();
    protected CreditPenaltyDataBaseManager creditPenaltyDataBaseManager = new CreditPenaltyDataBaseManager();


    protected Hooks hooks = new Hooks();

    @BeforeClass
    public void baseBeforeClass() {
        tokenManager.getTokenModel();
        if (IS_ADD_RUN_REQUIRED) {
            hooks.addRun(getClass());
        }
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) {
        if (IS_ADD_STATUS_REQUIRED) {
            hooks.setStatusWrapper(method, result, getClass());
        }
    }

    public <T> void checkResponseCode(Response<T> response, int expected) {
        VerifySoft.verifyEqualsSoft(response.code(), expected, "Response code");
    }

    public void checkAll() {
        VerifySoft.showAllChecking();
    }
}
