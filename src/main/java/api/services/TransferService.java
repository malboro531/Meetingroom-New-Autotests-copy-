package api.services;

import api.models.controllers.TransferModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static constants.ApiEndpoints.REQUEST_ON_TRANSFER_MONEY;
import static constants.ApiInterfaceServicesData.*;

public interface TransferService {

    @GET(REQUEST_ON_TRANSFER_MONEY)
    Call<List<TransferModel>> getAllTransferForUser(@Header(API_AUTHORIZATION) String token, @Query(API_TRANSFER_USER_ID) String id, @Query(API_PAGE) int page, @Query(API_SIZE) int size, @Query(API_SORT) String sort);

    @POST(REQUEST_ON_TRANSFER_MONEY)
    Call<TransferModel> createRequestOnTransferMoney(@Header(API_AUTHORIZATION) String token, @Body TransferModel transferModel);
}