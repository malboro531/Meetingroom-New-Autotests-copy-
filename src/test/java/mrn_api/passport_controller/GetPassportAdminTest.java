package mrn_api.passport_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllPassportModel;
import api.models.controllers.PassportModel;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.Verify;
import verification.VerifySoft;

import static constants.AllureData.API_PASSPORT_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.SQL_SELECT_PASSPORT_BY_USER_ID;
import static constants.ApiPassportData.COUNT_MSG;
import static constants.ApiPassportData.ERROR_NULL_BODY_MSG;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_PASSPORT_CONTROLLER)
public class GetPassportAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6275350")
    @Test(description = "Get  passport data by passport id, role - ADMIN", groups = {"Api"})
    public void c6275350() {
        Response<PassportModel> response = passportApiStep.getPassportInfoByPassportId(Integer.parseInt(passportId));
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6328402")
    @Test(description = "Get all passports, role - ADMIN", groups = {"Api"})
    public void c6328402() {
        int countPassports = passportDbManager.getAll().size();
        Response<AllPassportModel> response = passportApiStep.getAllPassportInfo(DEFAULT_PAGE_DB_REQUEST,
                countPassports, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyEqualsSoft(response.body().getContent().size(), countPassports, COUNT_MSG);
        checkAll();
    }

    @TestRails(id = "C6536476")
    @Test(description = "Get passport data by user id, role - ADMIN", groups = {"Api"})
    public void c6536476() {
        Response<PassportModel> response = passportApiStep.getPassportInfoByUserId(userId);
        checkResponseCode(response, HTTP_OK);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6328404")
    @Test(description = "Get passport by address id, role - ADMIN", groups = {"Api"})
    public void c6328404() {
        Response<PassportModel> response = passportApiStep.getPassportByAddressId(Integer.parseInt(addressId));
        checkResponseCode(response, HTTP_OK);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body(), passportModelSql);
        checkAll();
    }
}
