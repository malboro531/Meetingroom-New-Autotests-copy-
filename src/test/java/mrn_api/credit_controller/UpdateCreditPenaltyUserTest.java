package mrn_api.credit_controller;

import api.models.controllers.CreditPenaltyModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.GlobalData.VALID_CREDIT_PENALTY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class UpdateCreditPenaltyUserTest extends BaseApiTestUsingDataBase {

    private CreditPenaltyModel creditPenalty;
    private String invalidPenaltyId;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(USER);

        creditPenalty = FakeGenerator.generateFakePenalty();
        invalidPenaltyId = FakeGenerator.generateUuid();
    }

    @TestRails(id = "C6121547")
    @Test(description = "Update credit penalty, valid data, role - User", groups = {"Api"})
    public void c6121547() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep
                .updateCreditPenalty(VALID_CREDIT_PENALTY_ID, creditPenalty);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6121548")
    @Test(description = "Update credit penalty, invalid id, role - User", groups = {"Api"})
    public void c6121548() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep
                .updateCreditPenalty(invalidPenaltyId, creditPenalty);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
