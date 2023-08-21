package mrn_api.regular_payment_controller;

import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import constants.enums.Role;
import helpers.FakeGenerator;
import org.testng.annotations.*;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.sql.SQLException;

import static constants.ApiDataBase.SQL_SELECT_REGULAR_PAYMENT_BY_ID;
import static java.net.HttpURLConnection.*;

public class CreateRegularPaymentAdminTest extends BaseApiTestUsingDataBase {

    private String paymentId;

    @BeforeClass
    public void initiateToken() {
        authorization(Role.ADMIN);
    }

    @TestRails(id = "C6204409")
    @Test(description = " Create regular payment, role - ADMIN", groups = {"Api"})
    public void c6204409() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_OK);
        RegularPaymentModel regularPaymentModelSql = regularPaymentDBManager
                .getById(SQL_SELECT_REGULAR_PAYMENT_BY_ID, response.body().getId());
        regularPaymentApiStep.verifyRegularPaymentInDataBase(response.body(), regularPaymentModelSql);
        paymentId = response.body().getId();
        checkAll();
    }

    @TestRails(id = "C6229845")
    @Test(description = "Create regular payment with invalid source card, role - ADMIN", groups = {"Api"})
    public void c6229845()  {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        regularPayment.setSourceCardId(FakeGenerator.generateUuid());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6229850")
    @Test(description = "Create regular payment with invalid recipient card, role - ADMIN", groups = {"Api"})
    public void c6229850() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        regularPayment.setRecipientCardId(FakeGenerator.generateUuid());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6229564")
    @Test(description = "Create regular payment with invalid amount 0, role - ADMIN", groups = {"Api"})
    public void c6229564() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        regularPayment.setAmount(0);
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6229794")
    @Test(description = "Create regular payment with invalid frequency, role - ADMIN", groups = {"Api"})
    public void c6229794() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        regularPayment.setFrequency(FakeGenerator.getRandomString());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6229802")
    @Test(description = "Create regular payment with invalid start date, role - ADMIN", groups = {"Api"})
    public void c6229802() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeAdminRegularPayment();
        regularPayment.setStartDate(FakeGenerator.getBirthday());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @AfterTest
    public void deletePayment() {
        regularPaymentDBManager.deleteRegularPayment(paymentId);
    }
}
