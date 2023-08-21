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
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditPenaltyUserTest extends BaseApiTestUsingDataBase {

    private String invalidPenaltyId;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(USER);

        invalidPenaltyId = FakeGenerator.generateUuid();
    }

    @TestRails(id = "C6120035")
    @Test(description = "Get credit penalty by id, valid data, role - User", groups = {"Api"})
    public void c6120035() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.getCreditPenaltyById(VALID_CREDIT_PENALTY_ID);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6120036")
    @Test(description = "Get credit penalty by id, invalid id, role - User", groups = {"Api"})
    public void c6120036() {
        Response<CreditPenaltyModel> response = creditPenaltyApiStep.getCreditPenaltyById(invalidPenaltyId);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
