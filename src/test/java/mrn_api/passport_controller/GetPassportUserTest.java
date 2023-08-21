package mrn_api.passport_controller;

import api.models.controllers.AllPassportModel;
import api.models.controllers.PassportModel;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_PASSPORT_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_PASSPORT_CONTROLLER)
public class GetPassportUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6275387")
    @Test(description = "Get  passport data by passport id, role - USER", groups = {"Api"})
    public void c6275387() {
        Response<PassportModel> response = passportApiStep.getPassportInfoByPassportId(Integer.parseInt(passportId));
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6328403")
    @Test(description = "Get all passports, role - USER", groups = {"Api"})
    public void c6328403() {
        Response<AllPassportModel> response = passportApiStep.getAllPassportInfo(DEFAULT_PAGE_DB_REQUEST,
                DEFAULT_SIZE_DB_REQUEST, DEFAULT_SORT_DB_REQUEST);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6328405")
    @Test(description = "Get passport data by user id, role - USER", groups = {"Api"})
    public void c6328405() {
        Response<PassportModel> response = passportApiStep.getPassportInfoByUserId(userId);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6328404")
    @Test(description = "Get passport by address id, role - USER", groups = {"Api"})
    public void c6328404() {
        Response<PassportModel> response = passportApiStep.getPassportByAddressId(Integer.parseInt(addressId));
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
