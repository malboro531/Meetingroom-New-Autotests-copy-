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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_ADDRESS_CONTROLLER)
public class GetAddressUserTest extends BaseApiTestUsingDataBase {
    @BeforeClass
    public void initialToken() {
        authorization(USER);
    }

    @TestRails(id = "6299870")
    @Test(description = "Get all addresses, role - User", groups = {"Api"})
    public void c6299870() {
        Response<List<AddressModel>> response = addressApiStep.getAllAddresses();
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6299916")
    @Test(description = "Get address by id, role - User", groups = {"Api"})
    public void c6299916() {
        Response<AddressModel> response = addressApiStep.getAddressById(addressId);
        checkResponseCode(response, HTTP_OK);
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID, userId),
                AddressModel.class);
        addressApiStep.checkAddress(response.body(), addressModelSql);
        checkAll();
    }

    @TestRails(id = "C6299924")
    @Test(description = "Get address by user id, role - User", groups = {"Api"})
    public void c6299924() {
        Response<AddressModel> response = addressApiStep.getAddressByUserId(userId);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6299984")
    @Test(description = "Trying to get a non-existent address by id, role - User", groups = {"Api"})
    public void c6299984() {
        Response<AddressModel> response = addressApiStep.getAddressById(String.valueOf(FakeGenerator.getAddressId()));
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6300016")
    @Test(description = "Trying to get an address by invalid id, role - User", groups = {"Api"})
    public void c6300016() {
        Response<AddressModel> response = addressApiStep.getAddressById(FakeGenerator.getInvalidNumber());
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6300536")
    @Test(description = "Trying to get an address by valid but not existing user_id, role - User", groups = {"Api"})
    public void c6300536() {
        Response<AddressModel> response = addressApiStep.getAddressByUserId(FakeGenerator.generateUuid());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
 }
