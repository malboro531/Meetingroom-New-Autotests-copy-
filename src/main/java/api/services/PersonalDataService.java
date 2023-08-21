package api.services;

import api.models.AllUserPersonalDataModel;
import api.models.controllers.UserInfoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static constants.ApiAddressData.API_PHONE;
import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface PersonalDataService {

    @GET(GET_USER_PERSONAL_DATA)
    Call<AllUserPersonalDataModel> getUserPersonalData(@Header(API_AUTHORIZATION) String token);

    @GET(GET_USER_PERSONAL_DATA_BY_PHONE)
    Call<AllUserPersonalDataModel> getUserPersonalDataByPhone(@Header(API_AUTHORIZATION) String token,
                                                              @Path(API_PHONE) String phone);

    @GET(GET_USER_INFORMATION_BY_ENTRY_DATA)
    Call<UserInfoModel> getUserInfoByEntryData(@Header(API_AUTHORIZATION) String token,
                                               @Query(API_TYPE_OF_DATA) String typeOfData,
                                               @Query(API_ENTRY_DATA) String entryData);

    @GET(GET_USER_PERSONAL_DATA_BY_USER_ID)
    Call<AllUserPersonalDataModel> getUserPersonalDataByUserId(@Header(API_AUTHORIZATION) String token,
                                                               @Path(API_TRANSFER_USER_ID) String userId);
}
