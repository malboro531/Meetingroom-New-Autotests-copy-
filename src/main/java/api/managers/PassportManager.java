package api.managers;

import api.models.controllers.AllPassportModel;
import api.models.controllers.PassportModel;
import api.services.PassportService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class PassportManager extends BaseManager {

    private PassportService passportService = initialise(BASE_URL).create(PassportService.class);

    public Response<PassportModel> deletePassportById(int id) {
        Call<PassportModel> call = passportService.deletePassportById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<PassportModel> getPassportInfoByPassportId(int id) {
        Call<PassportModel> call = passportService.getPassportInfoByPassportId(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<PassportModel> getPassportInfoByUserId(String userId) {
        Call<PassportModel> call = passportService.getPassportInfoByUserId(TokenManager.getToken(), userId);
        return getResponse(call);
    }

    public Response<AllPassportModel> getAllPassportInfo(int page, int size, String sort) {
        Call<AllPassportModel> call = passportService.getAllPassportInfo(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<PassportModel> getPassportInfoByAddressId(int addressId) {
        Call<PassportModel> call = passportService.getPassportInfoByAddressId(TokenManager.getToken(), addressId);
        return getResponse(call);
    }

    public Response<Void> createPassport(PassportModel passport) {
        Call<Void> call = passportService.createPassport(TokenManager.getToken(), passport);
        return getResponse(call);
    }

    public Response<Void> updatePassport(PassportModel passport) {
        Call<Void> call = passportService.updatePassport(TokenManager.getToken(), passport);
        return getResponse(call);
    }
}
