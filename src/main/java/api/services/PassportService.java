package api.services;

import api.models.controllers.AllPassportModel;
import api.models.controllers.PassportModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface PassportService {

    @DELETE(DELETE_PASSPORT_BY_ID)
    Call<PassportModel> deletePassportById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) int id);

    @GET(GET_PASSPORT_INFO_BY_ID)
    Call<PassportModel> getPassportInfoByPassportId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) int id);

    @GET(GET_PASSPORT_INFO_BY_USER_ID)
    Call<PassportModel> getPassportInfoByUserId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String userId);

    @GET(GET_ALL_PASSPORT_INFO)
    Call<AllPassportModel> getAllPassportInfo(@Header(API_AUTHORIZATION) String token,
                                              @Query(API_PAGE) int page,
                                              @Query(API_SIZE) int size,
                                              @Query(API_SORT) String sort);

    @GET(GET_PASSPORT_INFO_BY_ADDRESS_ID)
    Call<PassportModel> getPassportInfoByAddressId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) int addressId);

    @POST(CREATE_PASSPORT)
    Call<Void> createPassport(@Header(API_AUTHORIZATION) String token, @Body PassportModel passport);

    @PUT(UPDATE_PASSPORT)
    Call<Void> updatePassport(@Header(API_AUTHORIZATION) String token, @Body PassportModel passport);
}
