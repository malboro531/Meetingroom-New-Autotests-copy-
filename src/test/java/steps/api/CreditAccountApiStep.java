package steps.api;

import api.managers.CreditAccountManager;
import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;

public class CreditAccountApiStep {

    private CreditAccountManager creditAccountManager = new CreditAccountManager();

    @Step("Get all credit accounts")
    public Response<AllCreditAccountsModel> getAllCreditAccounts(int page, int size, String sort) {
        return creditAccountManager.getAllCreditAccounts(page, size, sort);
    }

    @Step("Check count of credit accounts in Data Base")
    public void checkAllCreditAccounts(Integer dbCount, Integer responseCount) {
        Verify.verifyEquals(dbCount, responseCount, "Count credit accounts in DataBase matches with response count");
    }

    @Step("Get credit account by id")
    public Response<CreditAccountsModel> getCreditAccountById(String id) {
        return creditAccountManager.getCreditAccountById(id);
    }

    @Step("Get credit accounts by owner id")
    public Response<AllCreditAccountsModel> getCreditAccountByOwnerId(String id, int page, int size, String sort) {
        return creditAccountManager.getCreditAccountsByOwnerId(id, page, size, sort);
    }

    @Step("Get transfers info by credit account number")
    public Response<CreditAccountsModel> getCreditTransferByAccountNumber(String creditAccountNumber) {
        return creditAccountManager.getCreditTransferByAccountNumber(creditAccountNumber);
    }

    @Step("Verify that all fields in response body 'get credit account by id' are not null")
    public void verifyFieldsNotNull(CreditAccountsModel creditAccountsModel) {
        Verify.verifyNotNull(creditAccountsModel.getId(), "Id is not null");
        Verify.verifyNotNull(creditAccountsModel.getOwnerId(), "Owner id is not null");
        Verify.verifyNotNull(creditAccountsModel.getOpenDate(), "Open date is not null");
        Verify.verifyNotNull(creditAccountsModel.getCloseDate(), "Close date is not null");
        Verify.verifyNotNull(creditAccountsModel.getBankName(), "Bank name is not null");
        Verify.verifyNotNull(creditAccountsModel.getAccountNumber(), "Account number is not null");
        Verify.verifyNotNull(creditAccountsModel.getCurrencyName(), "Currency is not null");
        Verify.verifyNotNull(creditAccountsModel.getBalance(), "Balance is not null");
        Verify.verifyNotNull(creditAccountsModel.getPrincipalDebt(), "Principal debt is not null");
        Verify.verifyNotNull(creditAccountsModel.getBorrowingLimit(), "Borrowing limit is not null");
        Verify.verifyNotNull(creditAccountsModel.getBillingPeriod(), "Billing period is not null");
        Verify.verifyNotNull(creditAccountsModel.getPrincipalDebt(), "Principal debt is not null");
        Verify.verifyNotNull(creditAccountsModel.isActive(), "Is-active field is not null");
    }

    @Step("Verify that all fields in response body 'Get transfers info by credit account number' are not null")
    public void verifyTransfersInfoFieldsNotNull (CreditAccountsModel creditAccountsModel) {
        Verify.verifyNotNull(creditAccountsModel.getId(), "Id is not null");
        Verify.verifyNotNull(creditAccountsModel.getOwnerId(), "Owner id is not null");
        Verify.verifyNotNull(creditAccountsModel.getAccountNumber(), "Account number is not null");
        Verify.verifyNotNull(creditAccountsModel.getOpenDate(), "Open date is not null");
        Verify.verifyNotNull(creditAccountsModel.getCloseDate(), "Close date is not null");
        Verify.verifyNotNull(creditAccountsModel.getBalance(), "Balance is not null");
    }
}
