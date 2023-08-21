package mrn_api.credit_controller;

import api.models.controllers.CreditPenaltyModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class CreateCreditPenaltyUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6121543")
    @Test(description = "Create credit penalty, valid data, role - User", groups = {"Api"})
    public void c6121543() {
        CreditPenaltyModel creditPenalty = FakeGenerator.generateFakePenalty();
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.createCreditPenalty(creditPenalty);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
