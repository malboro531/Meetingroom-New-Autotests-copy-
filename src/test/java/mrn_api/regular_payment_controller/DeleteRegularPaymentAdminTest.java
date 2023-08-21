package mrn_api.regular_payment_controller;

import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteRegularPaymentAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6204947")
    @Test(description = "Delete regular payment, role - ADMIN", groups = {"Api"})
    public void c6204947() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(responseCreate, HTTP_OK);
        regularPaymentApiStep.deleteRegularPayment(responseCreate.body().getId());
        Response<RegularPaymentModel> response = regularPaymentApiStep
                .getRegularPaymentById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}
