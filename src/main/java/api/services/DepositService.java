package api.services;

import api.models.controllers.deposit.*;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface DepositService {

    @POST(CREATE_DEPOSIT)
    Call<DepositModel> createDeposit(@Header(API_AUTHORIZATION) String token,
                                     @Body DepositModel depositModel);

    @GET(GET_DEPOSIT_BY_ID)
    Call<DepositModel> getDepositById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @DELETE(DELETE_DEPOSIT_BY_ID)
    Call<DepositModel> deleteDepositById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);
}
