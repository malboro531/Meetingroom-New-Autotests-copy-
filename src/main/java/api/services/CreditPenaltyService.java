package api.services;

import api.models.controllers.CreditPenaltyModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.API_AUTHORIZATION;
import static constants.ApiInterfaceServicesData.API_ID;

public interface CreditPenaltyService {

    @POST(CREATE_CREDIT_PENALTY)
    Call<CreditPenaltyModel> createCreditPenalty(@Header(API_AUTHORIZATION) String token, @Body CreditPenaltyModel pojoCreditPenaltyModel);

    @PUT(UPDATE_CREDIT_PENALTY_BY_ID)
    Call<CreditPenaltyModel> updateCreditPenalty(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body CreditPenaltyModel pojoCreditPenaltyModel);

    @GET(GET_CREDIT_PENALTY_BY_ID)
    Call<CreditPenaltyModel> getCreditPenaltyById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);
}
