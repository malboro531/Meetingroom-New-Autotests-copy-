package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditPenaltyModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_DELETE_CREDIT_PENALTY_BY_ID;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_PENALTY_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class UpdateCreditPenaltyAdminTest extends BaseApiTestUsingDataBase {

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

    @TestRails(id = "C6121544")
    @Test(description = "Update credit penalty, valid data, role - Admin", groups = {"Api"})
    public void c6121544() {
        creditPenalty.setName(FakeGenerator.getLastName());
        Response<CreditPenaltyModel> responseUpdate = creditPenaltyApiStep
                .updateCreditPenalty(creditPenaltyId, creditPenalty);
        checkResponseCode(responseUpdate, HTTP_OK);
        CreditPenaltyModel creditPenaltySQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PENALTY_BY_ID,
                responseUpdate.body().getId()), CreditPenaltyModel.class);
        creditPenaltyApiStep.checkCreditPenaltyInDataBase(responseUpdate.body(), creditPenaltySQL);
        checkAll();
    }

    @TestRails(id = "C6121546")
    @Test(description = "Update credit penalty, invalid id, role - Admin", groups = {"Api"})
    public void c6121546() {
        Response<CreditPenaltyModel> responseUpdate = creditPenaltyApiStep
                .updateCreditPenalty(invalidPenaltyId, creditPenalty);
        checkResponseCode(responseUpdate, HTTP_NOT_FOUND);
        checkAll();
    }

    @AfterTest
    public void deleteCreatedPenalty() {
        creditPenaltyDataBaseManager.deleteFromDataBaseById(SQL_DELETE_CREDIT_PENALTY_BY_ID, creditPenaltyId);
    }
}
