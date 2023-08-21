package mrn_api.address_controller;

import api.models.controllers.AddressModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_ADDRESS_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_ADDRESS_CONTROLLER)
public class UpdateAddressAdminTest extends BaseApiTestUsingDataBase {

    private AddressModel address;

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
        address = FakeGenerator.generateFakeAddress();
        address.setId(Integer.parseInt(addressId));
    }

    @TestRails(id = "C5958342")
    @Test(description = "User updating by id valid data, role - Admin", groups = {"Api"})
    public void c5958342() {
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C5958344")
    @Test(description = "User updating without country, role - Admin", groups = {"Api"})
    public void c5958344() {
        address.setCountry(null);
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958345")
    @Test(description = "User updating without house, role - Admin", groups = {"Api"})
    public void c5958345() {
        address.setHouse(null);
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958346")
    @Test(description = "User updating over boundary country, role - Admin", groups = {"Api"})
    public void c5958346() {
        address.setCountry(FakeGenerator.getRandomString());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958350")
    @Test(description = "User updating over boundary house, role - Admin", groups = {"Api"})
    public void c5958350() {
        address.setHouse(FakeGenerator.getRandomNumber());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958351")
    @Test(description = "User updating with none existing id, role - Admin", groups = {"Api"})
    public void c5958351() {
        address.setId(-1);
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C5958357")
    @Test(description = "User updating with invalid region, role - Admin", groups = {"Api"})
    public void c5958357() {
        address.setRegion(FakeGenerator.getRandomString());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958359")
    @Test(description = "User updating with invalid location, role - Admin", groups = {"Api"})
    public void c5958359() {
        address.setLocation(FakeGenerator.getRandomString());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958360")
    @Test(description = "User updating with invalid city, role - Admin", groups = {"Api"})
    public void c5958360() {
        address.setCity(FakeGenerator.getRandomString());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958363")
    @Test(description = "User updating with invalid street, role - Admin", groups = {"Api"})
    public void c5958363() {
        address.setStreet(FakeGenerator.getRandomString());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958366")
    @Test(description = "User updating with invalid building, role - Admin", groups = {"Api"})
    public void c5958366() {
        address.setBuilding(FakeGenerator.getInvalidNumber());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958369")
    @Test(description = "User updating with invalid flat, role - Admin", groups = {"Api"})
    public void c5958369() {
        address.setFlat(FakeGenerator.getInvalidNumber());
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }
}
