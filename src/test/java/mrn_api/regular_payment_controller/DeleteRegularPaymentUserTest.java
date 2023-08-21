package mrn_api.regular_payment_controller;

import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteRegularPaymentUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6204946")
    @Test(description = "Delete regular payment, role - USER", groups = {"Api"})
    public void c6204946() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(responseCreate, HTTP_OK);
        regularPaymentApiStep.deleteRegularPayment(responseCreate.body().getId());
        Response<RegularPaymentModel> response = regularPaymentApiStep
                .getRegularPaymentById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6229559")
    @Test(description = "Delete regular payment, role - Unauthorized", groups = {"Api"})
    public void c6229559() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep
                .createRegularPayment(regularPayment);
        checkResponseCode(responseCreate, HTTP_OK);
        authorization(UNAUTHORIZED);
        regularPaymentApiStep.deleteRegularPayment(responseCreate.body().getId());
        authorization(USER);
        Response<RegularPaymentModel> response = regularPaymentApiStep
                .getRegularPaymentById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
        regularPaymentDBManager.deleteRegularPayment(responseCreate.body().getId());
    }
}
