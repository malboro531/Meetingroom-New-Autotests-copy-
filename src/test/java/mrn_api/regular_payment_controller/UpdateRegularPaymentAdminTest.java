package mrn_api.regular_payment_controller;

import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_REGULAR_PAYMENT_BY_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class UpdateRegularPaymentAdminTest extends BaseApiTestUsingDataBase {
    RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6204410")
    @Test(description = "Update regular payment, role - ADMIN", groups = {"Api"})
    public void c6204410() {
        Response<RegularPaymentModel> responseCreate = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(responseCreate, HTTP_OK);
        regularPayment.setId(responseCreate.body().getId());
        regularPayment.setNextDate(responseCreate.body().getNextDate());
        regularPayment.setActive(responseCreate.body().isActive());
        regularPayment.setAmount(responseCreate.body().getAmount() - 1);
        Response<RegularPaymentModel> responseUpdate = regularPaymentApiStep.updateRegularPayment(regularPayment);
        checkResponseCode(responseUpdate, HTTP_OK);
        RegularPaymentModel regularPaymentModelSql = regularPaymentDBManager
                .getById(SQL_SELECT_REGULAR_PAYMENT_BY_ID, responseUpdate.body().getId());
        regularPaymentApiStep.verifyRegularPaymentInDataBase(responseUpdate.body(), regularPaymentModelSql);
        checkAll();
    }

    @AfterMethod
    public void deleteRegularPayment() {
        regularPaymentApiStep.deleteRegularPayment(regularPayment.getId());
    }
}
