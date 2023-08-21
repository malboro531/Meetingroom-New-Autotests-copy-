package api.managers;

import api.models.controllers.AddressModel;
import api.services.AddressService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class AddressManager extends BaseManager {

    private AddressService addressService = initialise(BASE_URL).create(AddressService.class);

    public Response<List<AddressModel>> getAllAddresses() {
        Call<List<AddressModel>> call = addressService.getAllAddresses(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<AddressModel> getAddressById(String id) {
        Call<AddressModel> call = addressService.getAddressById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AddressModel> getAddressByUserId(String userId) {
        Call<AddressModel> call = addressService.getAddressByUserId(TokenManager.getToken(),userId);
        return getResponse(call);
    }

    public Response<Void> updateAddress(AddressModel address) {
        Call<Void> call = addressService.updateAddress(TokenManager.getToken(), address);
        return getResponse(call);
    }
}