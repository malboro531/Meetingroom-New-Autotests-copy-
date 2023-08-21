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
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_ADDRESS_CONTROLLER)
public class UpdateAddressUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initialToken() {
        authorization(USER);
    }

    @TestRails(id = "C6327340")
    @Test(description = "User updating by id valid data, role - User", groups = {"Api"})
    public void c6327340() {
        AddressModel address = FakeGenerator.generateFakeAddress();
        address.setId(Integer.parseInt(addressId));
        Response<Void> response = addressApiStep.updateAddress(address);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
