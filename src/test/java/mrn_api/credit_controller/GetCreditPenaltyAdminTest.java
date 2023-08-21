package mrn_api.credit_controller;

import api.models.controllers.CreditPenaltyModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_PENALTY_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditPenaltyAdminTest extends BaseApiTestUsingDataBase {

    private CreditPenaltyModel creditPenalty;
    private String creditPenaltyId;
    private String invalidPenaltyId;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(ADMIN);

        creditPenalty = FakeGenerator.generateFakePenalty();
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.createCreditPenalty(creditPenalty);
        creditPenaltyId = response.body().getId();
        invalidPenaltyId = FakeGenerator.generateUuid();
    }

    @TestRails(id = "C6120022")
    @Test(description = "Get credit penalty by id, valid data, role - Admin", groups = {"Api"})
    public void c6120022() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.getCreditPenaltyById(creditPenaltyId);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6120032")
    @Test(description = "Get credit penalty by id, invalid id, role - Admin", groups = {"Api"})
    public void c6120032() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.getCreditPenaltyById(invalidPenaltyId);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @AfterTest
    public void deleteCreatedPenalty() {
        creditPenaltyDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_PENALTY_BY_ID, creditPenaltyId);
    }
}
