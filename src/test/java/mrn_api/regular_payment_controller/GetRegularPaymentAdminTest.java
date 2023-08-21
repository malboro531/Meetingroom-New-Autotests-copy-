package mrn_api.regular_payment_controller;

import api.models.controllers.AllRegularPaymentsModel;
import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetRegularPaymentAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6204944")
    @Test(description = "Get regular payment by id with valid data, role - ADMIN", groups = {"Api"})
    public void c6204944() {
        RegularPaymentModel regularPaymentModel = FakeGenerator.generateFakeAdminRegularPayment();
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep
                .createRegularPayment(regularPaymentModel);
        checkResponseCode(responseCreate, HTTP_OK);
        Response<RegularPaymentModel> response = regularPaymentApiStep
                .getRegularPaymentById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        regularPaymentApiStep.verifyFieldsNotNull(response.body());
        checkAll();
        regularPaymentDBManager.deleteRegularPayment(responseCreate.body().getId());
    }

    @TestRails(id = "C6204941")
    @Test(description = "Get all regular payments, role - ADMIN", groups = {"Api"})
    public void c6204941() {
        Response<AllRegularPaymentsModel> response = regularPaymentApiStep
                .getAllRegularPayments(0, 1000, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        regularPaymentApiStep.checkAllRegularPayments(regularPaymentDBManager.getCountAll(),
                response.body().getContent().size());
        checkAll();
    }
}
