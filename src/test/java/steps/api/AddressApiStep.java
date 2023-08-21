package steps.api;

import api.managers.AddressManager;
import api.models.controllers.AddressModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

import java.util.List;

public class AddressApiStep {

    private AddressManager addressManager = new AddressManager();

    @Step("Get all addresses")
    public Response<List<AddressModel>> getAllAddresses() {
        return addressManager.getAllAddresses();
    }

    @Step("Get address by id")
    public Response<AddressModel> getAddressById(String id) {
        return addressManager.getAddressById(id);
    }

    @Step("Get address by user id")
    public Response<AddressModel> getAddressByUserId(String userId) {
        return addressManager.getAddressByUserId(userId);
    }

    @Step("Update address")
    public Response<Void> updateAddress(AddressModel address) {
        return addressManager.updateAddress(address);
    }

    @Step("Compare address")
    public void checkAddress(AddressModel address, AddressModel addressModelSql) {
        VerifySoft.verifyEqualsSoft(address.getId(), addressModelSql.getId(), "id");
        VerifySoft.verifyEqualsSoft(address.getUserId(), addressModelSql.getUserId(), "user id");
        VerifySoft.verifyEqualsSoft(address.getZipCode(), addressModelSql.getZipCode(), "zip code");
        VerifySoft.verifyEqualsSoft(address.getCountry(), addressModelSql.getCountry(), "country");
        VerifySoft.verifyEqualsSoft(address.getStreet(), addressModelSql.getStreet(), "street");
        VerifySoft.verifyEqualsSoft(address.getHouse(), addressModelSql.getHouse(), "house");
        VerifySoft.verifyEqualsSoft(address.getBuilding(), addressModelSql.getBuilding(), "building");
        VerifySoft.verifyEqualsSoft(address.getFlat(), addressModelSql.getFlat(), "flat");
    }

    public void checkResponceDataBaseCountAddresses(Integer baseCount, Integer responcecount) {
        VerifySoft.verifyEqualsSoft(baseCount, responcecount, "Count of addresses in DataBase matches with responce count");
    }
}