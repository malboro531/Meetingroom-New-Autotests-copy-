package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditPenaltyModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_PENALTY_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_PENALTY_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreateCreditPenaltyAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6121541")
    @Test(description = "Create credit penalty, valid data, role - Admin", groups = {"Api"})
    public void c6121541() {
        CreditPenaltyModel creditPenalty = FakeGenerator.generateFakePenalty();
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.createCreditPenalty(creditPenalty);
        checkResponseCode(response, HTTP_OK);
        CreditPenaltyModel creditPenaltySQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PENALTY_BY_ID,
                response.body().getId()), CreditPenaltyModel.class);
        creditPenaltyApiStep.checkCreditPenaltyInDataBase(response.body(), creditPenaltySQL);
        checkAll();
        creditPenaltyDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_PENALTY_BY_ID, response.body().getId());
    }
}
