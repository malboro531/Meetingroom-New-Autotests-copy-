package steps.api;

import api.managers.AccountManager;
import api.models.controllers.AccountModel;
import api.models.controllers.AllAccountsModel;
import api.models.controllers.CurrencyType;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Response;
import utils.DateUtils;
import verification.VerifySoft;

import java.util.List;

import static constants.GlobalData.LENGTH_ACCOUNT_NUMBER;

public class AccountApiStep {

    private AccountManager accountManager = new AccountManager();

    @Step("Get all accounts")
    public Response<AllAccountsModel> getAllAccounts(int page, int size, String sort) {
        return accountManager.getAllAccounts(page, size, sort);
    }

    @Step("Get account by id")
    public Response<AccountModel> getAccountById(String id) {
        return accountManager.getAccountById(id);
    }

    @Step("Get accounts with owner id")
    public Response<AllAccountsModel> getAccountsWithOwnerId(String ownerId) {
        return accountManager.getAccountsWithOwnerId(ownerId);
    }

    @Step("Get account info by account number")
    public Response<AccountModel> getAccountByAccountNumber(String accountNumber) {
        return accountManager.getAccountByAccountNumber(accountNumber);
    }

    @Step("Create account")
    public Response<AccountModel> createAccount(CurrencyType currencyType) {
        return accountManager.createAccount(currencyType);
    }

    @Step("Update account")
    public Response<AccountModel> updateAccount(AccountModel account) {
        return accountManager.updateAccount(account);
    }

    @Step("Get account by bank name and currency code")
    public Response<List<AccountModel>> getAccountByIdBankNameAndCurrency(String xUserId, String bankName, String currency) {
        return accountManager.getAccountByIdBankNameAndCurrency(xUserId, bankName, currency);
    }

    @Step("Compare account")
    public void checkAccount(AccountModel accountModel, AccountModel accountModelSql) {
        VerifySoft.verifyEqualsSoft(accountModel.getId(), accountModelSql.getId(), "id");
        VerifySoft.verifyEqualsSoft(accountModel.getOwnerId(), accountModelSql.getOwnerId(), "owner id");
        VerifySoft.verifyEqualsSoft(accountModel.getAccountNumber(), accountModelSql.getAccountNumber(), "account number");
        VerifySoft.verifyEqualsSoft(accountModel.getBalance(), accountModelSql.getBalance(), "balance");
        VerifySoft.verifyEqualsSoft(accountModel.getBankName(), accountModelSql.getBankName(), "bank name");
        VerifySoft.verifyEqualsSoft(accountModel.getCurrency(), accountModelSql.getCurrency(), "currency");
        VerifySoft.verifyEqualsSoft(accountModel.getOpenDate(), accountModelSql.getOpenDate(), "open date");
        VerifySoft.verifyEqualsSoft(accountModel.getCloseDate(), accountModelSql.getCloseDate(), "close date");
    }

    @Step("Compare account with active status")
    public void checkAccountAllParameters(AccountModel accountModel, AccountModel accountModelSql) {
        checkAccount(accountModel, accountModelSql);
        VerifySoft.verifyEqualsSoft(accountModel.isActive(), accountModelSql.isActive(), "account is active");
    }

    @Step("Compare account table")
    public void checkAllAccounts(List<AccountModel> accountModel, List<AccountModel> accountModelSql) {
        for (int i = 0; i < accountModel.size(); i++) {
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getId(), accountModelSql.get(i).getId(), "id");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getAccountNumber(), accountModelSql.get(i).getAccountNumber(), "account number");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getOpenDate(), accountModelSql.get(i).getOpenDate(), "open date");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getCloseDate(), accountModelSql.get(i).getCloseDate(), "close date");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getOwnerId(), accountModelSql.get(i).getOwnerId(), "owner id");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getCurrency(), accountModelSql.get(i).getCurrency(), "currency");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getBankName(), accountModelSql.get(i).getBankName(), "bank name");
            VerifySoft.verifyEqualsSoft(accountModel.get(i).getBalance(), accountModelSql.get(i).getBalance(), "balance");
        }
    }

    @Step("Check fields of new account")
    public void checkFieldsNewAccount(Response<AccountModel> response, AccountModel accountModel, String userId) {
        VerifySoft.verifyNotNullSoft(response.body().getId(), "id");
        VerifySoft.verifyFalseSoft(response.body().getId().isEmpty(),  "id");
        VerifySoft.verifyNotNullSoft(response.body().getAccountNumber(), "account_number");
        VerifySoft.verifyNotEqualsSoft(response.body().getAccountNumber(), "", "account_number");
        VerifySoft.verifyEqualsSoft(response.body().getAccountNumber().length(), LENGTH_ACCOUNT_NUMBER, "account_number");
        VerifySoft.verifyTrueSoft(StringUtils.isNumeric(response.body().getAccountNumber()), "account_number");
        VerifySoft.verifyEqualsSoft(response.body().getOpenDate(), DateUtils.getCurrentDate(), "open_date");
        VerifySoft.verifyEqualsSoft(response.body().getOwnerId(), userId, "owner_id");
        VerifySoft.verifyEqualsSoft(response.body().getCurrency(), accountModel.getCurrency(), "currency");
        VerifySoft.verifyNotNullSoft(response.body().getBankName(), "bank_name");
        VerifySoft.verifyTrueSoft(response.body().isActive(), "is_active");
    }
}
