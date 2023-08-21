package api.managers;

import api.models.AllUserPersonalDataModel;
import api.models.controllers.UserInfoModel;
import api.services.PersonalDataService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class PersonalDataManager extends BaseManager {

    private PersonalDataService personalDataService = initialise(BASE_URL).create(PersonalDataService.class);

    public Response<AllUserPersonalDataModel> getUserPersonalData() {
        Call<AllUserPersonalDataModel> call = personalDataService
                .getUserPersonalData(TokenManager.getToken());
        return getResponse(call);
    }

    public Response<AllUserPersonalDataModel> getUserPersonalDataByPhone(String phone) {
        Call<AllUserPersonalDataModel> call = personalDataService
                .getUserPersonalDataByPhone(TokenManager.getToken(), phone);
        return getResponse(call);
    }

    public Response<UserInfoModel> getUserInfoByEntryData(String typeOfData, String entryData) {
        Call<UserInfoModel> call = personalDataService
                .getUserInfoByEntryData(TokenManager.getToken(), typeOfData, entryData);
        return getResponse(call);
    }

    public Response<AllUserPersonalDataModel> getUserPersonalDataByUserId(String userId){
        Call<AllUserPersonalDataModel> call = personalDataService
                .getUserPersonalDataByUserId(TokenManager.getToken(), userId);
        return getResponse(call);
    }
}
