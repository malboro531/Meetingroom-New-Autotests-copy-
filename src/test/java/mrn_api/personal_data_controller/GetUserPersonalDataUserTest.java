package mrn_api.personal_data_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.AllUserPersonalDataModel;
import api.models.controllers.AddressModel;
import api.models.controllers.PassportModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_PERSONAL_DATA_CONTROLLER;
import static constants.ApiDataBase.SQL_SELECT_ADDRESS_BY_USER_ID;
import static constants.ApiDataBase.SQL_SELECT_PASSPORT_BY_USER_ID;
import static constants.enums.Role.UNAUTHORIZED;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

@Feature(API_PERSONAL_DATA_CONTROLLER)
public class GetUserPersonalDataUserTest extends BaseApiTestUsingDataBase {

    @BeforeMethod
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6328245")
    @Test(description = "Get user personal data, role USER", groups = {"Api"})
    public void c6328245() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalData();
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body().getUser());
        AddressModel addressModelSql = DataBaseAbstractManager
                .getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID, userId), AddressModel.class);
        addressApiStep.checkAddress(response.body().getAddress(), addressModelSql);
        PassportModel passportModelSql = DataBaseAbstractManager
                .getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID, userId), PassportModel.class);
        passportApiStep.checkPassport(response.body().getPassport(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6208634")
    @Test(description = "Get user personal data by phone, role USER", groups = {"Api"})
    public void c6208634() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6208640")
    @Test(description = "Get user personal data by phone, role UNAUTHORIZED", groups = {"Api"})
    public void c6208640() {
        authorization(UNAUTHORIZED);
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6208674")
    @Test(description = "Get user personal data by phone with valid but non-existent data, role USER", groups = {"Api"})
    public void c6208674() {
        String userPhone = FakeGenerator.generateFakeUser().getPhone();
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6208679")
    @Test(description = "Get user personal data by phone with valid but non-existent data, role UNAUTHORIZED", groups = {"Api"})
    public void c6208679() {
        authorization(UNAUTHORIZED);
        String userPhone = FakeGenerator.generateFakeUser().getPhone();
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6477130")
    @Test(description = "Get user personal data by user id, role User", groups = {"Api"})
    public void c6477130() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByUserId(userId);
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body().getUser());
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID,
                userId), AddressModel.class);
        addressApiStep.checkAddress(response.body().getAddress(), addressModelSql);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body().getPassport(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6477131")
    @Test(description = "Get user personal data by user id, role UNAUTHORIZED", groups = {"Api"})
    public void c6477131() {
        authorization(UNAUTHORIZED);
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByUserId(userId);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
