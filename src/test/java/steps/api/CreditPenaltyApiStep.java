package steps.api;

import api.managers.CreditPenaltyManager;
import api.models.controllers.CreditPenaltyModel;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import retrofit2.Response;
import verification.VerifySoft;

public class CreditPenaltyApiStep {

    private CreditPenaltyManager creditPenaltyManager = new CreditPenaltyManager();

    @Step("Create credit penalty")
    public Response<CreditPenaltyModel> createCreditPenalty(CreditPenaltyModel pojoCreditPenaltyModel) {
        return creditPenaltyManager.createCreditPenalty(pojoCreditPenaltyModel);
    }

    @Step("Check created credit penalty in Data Base")
    public void checkCreditPenaltyInDataBase(CreditPenaltyModel creditPenaltyModel, CreditPenaltyModel creditPenaltyModelSQL) {
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getId(), creditPenaltyModelSQL.getId(), "Credit penalty id found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getName(), creditPenaltyModelSQL.getName(), "Credit penalty name found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getPercent(), creditPenaltyModelSQL.getPercent(), "Credit penalty percent found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getAmountMin(), creditPenaltyModelSQL.getAmountMin(), "Credit penalty amount min found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getMaxPercent(), creditPenaltyModelSQL.getMaxPercent(), "Credit penalty max percent found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.getAmountMax(), creditPenaltyModelSQL.getAmountMax(), "Credit penalty amount max found in DB");
        VerifySoft.verifyEqualsSoft(creditPenaltyModel.isPenny(), creditPenaltyModelSQL.isPenny(), "Credit penalty is penny - information found in DB");
    }

    @Step("Update credit penalty")
    public Response<CreditPenaltyModel> updateCreditPenalty(String id, CreditPenaltyModel pojoCreditPenaltyModel) {
        return creditPenaltyManager.updateCreditPenalty(id, pojoCreditPenaltyModel);
    }

    @Step("Get credit penalty by id")
    public Response<CreditPenaltyModel> getCreditPenaltyById(String id) {
        return creditPenaltyManager.getCreditPenaltyById(id);
    }
}
