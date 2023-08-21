package steps.api;

import api.managers.DepositManager;
import api.models.controllers.deposit.*;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

public class DepositApiStep {

    private DepositManager depositManager = new DepositManager();

    @Step("Get deposit by id")
    public Response<DepositModel> getDepositById(String id) {
        return depositManager.getDepositById(id);
    }

    @Step("Create deposit ")
    public Response<DepositModel> createDeposit(DepositModel depositModel) {
        return depositManager.createDeposit(depositModel);
    }

    @Step("Delete Deposit")
    public Response<DepositModel> deleteDepositByID(String id) {
        return depositManager.deleteDepositById(id);
    }

    @Step("Check that created deposits aren't equal with Id")
    public void checkDifferentDepositsWithId(String depositCreatedId, String depositId) {
        VerifySoft.verifyNotEqualsSoft(depositCreatedId, depositId, "deposits are equal");
    }

    @Step("Check created deposit in DB")
    public void checkCreatedDepositInDataBase(DepositModel depositModel, DepositModel depositModelSql) {
        VerifySoft.verifyEqualsSoft(depositModel.getId(), depositModelSql.getId(), " deposit id found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getDepositNumber(), depositModelSql.getDepositNumber(), "deposit number found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getType().getId(), depositModelSql.getType().getId(), "deposit Type id found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getType().getName(), depositModelSql.getType().getName(), "deposit Type name found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getCurrency().getId(), depositModelSql.getCurrency().getId(), "deposit Currency id found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getCurrency().getName(), depositModelSql.getCurrency().getName(), "deposit Currency name found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getTermMonths(), depositModelSql.getTermMonths(), "deposit termMonth found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getOpenDate(), depositModelSql.getOpenDate(), "deposit openDate found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getCloseDate(), depositModelSql.getCloseDate(), "deposit closeDate found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.getAmount(), depositModelSql.getAmount(), "deposit amount found in DB");
        VerifySoft.verifyEqualsSoft(depositModel.isFixedInterest(), depositModelSql.isFixedInterest(), "deposit fixedInterest match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isSubsequentReplenishment(), depositModelSql.isSubsequentReplenishment(), "deposit subsequentReplenishment match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isCapitalization(), depositModelSql.isCapitalization(), "deposit capitalization match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isEarlyWithdrawal(), depositModelSql.isEarlyWithdrawal(), "deposit earlyWithdrawal match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isInterestWithdrawal(), depositModelSql.isInterestWithdrawal(), "deposit interestWithdrawal match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isRevocable(), depositModelSql.isRevocable(), "deposit revocable match with DB");
        VerifySoft.verifyEqualsSoft(depositModel.isActive_status(), depositModelSql.isActive_status(), "deposit active_status match with DB");
    }
}
