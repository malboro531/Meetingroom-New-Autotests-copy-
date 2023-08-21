package mrn_api.passport_controller;

import api.models.controllers.PassportModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_PASSPORT_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_PASSPORT_CONTROLLER)
@Test
public class PassportInfoTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void createFakeAddress() {
        addressDbManager.create(FakeGenerator.generateFakeAddress());
    }

    @Ignore
    @TestRails(id = "C6032893")
    @Test(description = "Create passport")
    public void createPassportTest() {
        PassportModel passport = FakeGenerator.generateFakePassport();
        passport.setAddressId(Integer.parseInt(addressId));
        passport.setUserId(userId);
        passport.setFirstName(firstName);
        passport.setLastName(lastName);
        Response<Void> response = passportApiStep.createPassport(passport);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6032894")
    @Test(description = "Update passport with fake data")
    public void updatePassportTest() {
        PassportModel passport = FakeGenerator.generateFakePassport();
        passport.setId(Integer.parseInt(passportId));
        passport.setUserId(userId);
        passport.setAddressId(Integer.parseInt(addressId));
        passport.setFirstName(firstName);
        passport.setLastName(lastName);
        Response<Void> response = passportApiStep.updatePassport(passport);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @Ignore
    @TestRails(id = "C6032895")
    @Test(description = "Delete passport by passport id")
    public void deletePassport() {
        Response<PassportModel> response = passportApiStep.deletePassport(Integer.parseInt(passportId));
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @AfterClass
    public void deleteUserAddressPassport() {
        addressDbManager.delete();
        passportDbManager.delete();
    }
}
