package mrn_api.regular_payment_controller;

import api.models.controllers.AllRegularPaymentsModel;
import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class GetRegularPaymentUserTest extends BaseApiTestUsingDataBase {

    @BeforeMethod
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6204943")
    @Test(description = "Get regular payment by id with valid data, role - USER", groups = {"Api"})
    public void c6204943() {
        RegularPaymentModel regularPaymentModel = FakeGenerator.generateFakeRegularPayment();
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

    @TestRails(id = "C6229558")
    @Test(description = "Get regular payment by id with valid data, role - Unauthorized", groups = {"Api"})
    public void c6229558() {
        RegularPaymentModel regularPaymentModel = FakeGenerator.generateFakeRegularPayment();
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep
                .createRegularPayment(regularPaymentModel);
        checkResponseCode(responseCreate, HTTP_OK);
        authorization(UNAUTHORIZED);
        Response<RegularPaymentModel> response = regularPaymentApiStep
                .getRegularPaymentById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        authorization(USER);
        regularPaymentDBManager.deleteRegularPayment(responseCreate.body().getId());
    }

    @TestRails(id = "C6204942")
    @Test(description = "Get all regular payments, role - USER", groups = {"Api"})
    public void c6204942() {
        Response<AllRegularPaymentsModel> response = regularPaymentApiStep
                .getAllRegularPayments(0, 1000, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        regularPaymentApiStep.checkAllRegularPayments(regularPaymentDBManager.getCountAll(),
                response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6229557")
    @Test(description = "Get all regular payments, role - Unauthorized", groups = {"Api"})
    public void c6229557() {
        authorization(UNAUTHORIZED);
        Response<AllRegularPaymentsModel> response = regularPaymentApiStep
                .getAllRegularPayments(0, 1000, Strings.EMPTY);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
    }
}
