package mrn_api.address_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AddressModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import java.util.List;

import static constants.AllureData.API_ADDRESS_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.SQL_SELECT_ADDRESS_BY_USER_ID;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_ADDRESS_CONTROLLER)
public class GetAddressAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C5958129")
    @Test(description = "Get all addresses, role - Admin", groups = {"Api"})
    public void c5958129() {
        Response<List<AddressModel>> response = addressApiStep.getAllAddresses();
        checkResponseCode(response, HTTP_OK);
        addressApiStep.checkResponceDataBaseCountAddresses(addressDbManager.getCountAll(), response.body().size());
        checkAll();
    }

    @TestRails(id = "C5958131")
    @Test(description = "Get address by id, role - Admin", groups = {"Api"})
    public void c5958131() {
        Response<AddressModel> response = addressApiStep.getAddressById(addressId);
        checkResponseCode(response, HTTP_OK);
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID, userId),
                AddressModel.class);
        addressApiStep.checkAddress(response.body(), addressModelSql);
        checkAll();
    }

    @TestRails(id = "C5958337")
    @Test(description = "Get address by user id, role - Admin", groups = {"Api"})
    public void c5958337() {
        Response<AddressModel> response = addressApiStep.getAddressByUserId(userId);
        checkResponseCode(response, HTTP_OK);
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID, userId),
                AddressModel.class);
        addressApiStep.checkAddress(response.body(), addressModelSql);
        checkAll();
    }

    @TestRails(id = "C5958338")
    @Test(description = "Trying to get a non-existent address by id, role - Admin", groups = {"Api"})
    public void c5958338() {
        Response<AddressModel> response = addressApiStep
                .getAddressById(String.valueOf(FakeGenerator.getAddressId()));
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C5958340")
    @Test(description = "Trying to get an address by invalid id, role - Admin", groups = {"Api"})
    public void c5958340() {
        Response<AddressModel> response = addressApiStep
                .getAddressById(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C5958341")
    @Test(description = "Trying to get an address by valid but not existing user_id, role - Admin", groups = {"Api"})
    public void c5958341() {
        Response<AddressModel> response = addressApiStep
                .getAddressByUserId(FakeGenerator.generateUuid());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }
}