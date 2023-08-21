package mrn_api.regular_payment_controller;

import api.models.controllers.RegularPaymentModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_REGULAR_PAYMENT_BY_ID;
import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

public class CreateRegularPaymentUserTest extends BaseApiTestUsingDataBase {

    @BeforeMethod
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6204035")
    @Test(description = " Create regular payment, role - USER", groups = {"Api"})
    public void c6204035() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_OK);
        RegularPaymentModel regularPaymentModelSql = regularPaymentDBManager
                .getById(SQL_SELECT_REGULAR_PAYMENT_BY_ID, response.body().getId());
        regularPaymentApiStep.verifyRegularPaymentInDataBase(response.body(), regularPaymentModelSql);
        checkAll();
        regularPaymentDBManager.deleteRegularPayment(response.body().getId());
    }

    @TestRails(id = "C6229554")
    @Test(description = "Create regular payment, role - Unauthorized", groups = {"Api"})
    public void C6229554() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        authorization(UNAUTHORIZED);
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6229844")
    @Test(description = "Create regular payment with invalid source card, role - USER", groups = {"Api"})
    public void c6229844()  {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        regularPayment.setSourceCardId(FakeGenerator.generateUuid());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6229849")
    @Test(description = "Create regular payment with invalid recipient card, role - USER", groups = {"Api"})
    public void c6229849() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        regularPayment.setRecipientCardId(FakeGenerator.generateUuid());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6229793")
    @Test(description = "Create regular payment with invalid amount 0, role - USER", groups = {"Api"})
    public void c6229793() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        regularPayment.setAmount(0);
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6229795")
    @Test(description = "Create regular payment with invalid frequency, role - USER", groups = {"Api"})
    public void c6229795() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        regularPayment.setFrequency(FakeGenerator.getRandomString());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6229801")
    @Test(description = "Create regular payment with invalid start date, role - USER", groups = {"Api"})
    public void c6229801() {
        RegularPaymentModel regularPayment = FakeGenerator.generateFakeRegularPayment();
        regularPayment.setStartDate(FakeGenerator.getBirthday());
        Response<RegularPaymentModel> response = regularPaymentApiStep.createRegularPayment(regularPayment);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
