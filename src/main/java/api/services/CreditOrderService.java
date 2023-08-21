package api.services;

import api.models.controllers.AllCreditOrdersModel;
import api.models.controllers.CreditOrderModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface CreditOrderService {

    @POST(CREATE_CREDIT_ORDER)
    Call<CreditOrderModel> createCreditOrder(@Header(API_AUTHORIZATION) String token, @Body CreditOrderModel pojoCreditOrderModel);

    @GET(GET_CREDIT_ORDER_BY_ID)
    Call<CreditOrderModel> getCreditOrderById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ALL_CREDIT_ORDERS_BY_OWNER_ID)
    Call<AllCreditOrdersModel> getAllCreditOrdersByOwnerId(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Query(API_PAGE) int page, @Query(API_SIZE) int size, @Query(API_SORT) String sort);

    @GET(GET_ALL_CREDIT_ORDERS)
    Call<AllCreditOrdersModel> getAllCreditOrders(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size, @Query(API_SORT) String sort);

    @PUT(UPDATE_CREDIT_ORDER)
    Call<CreditOrderModel> updateCreditOrder(@Header(API_AUTHORIZATION) String token, @Body CreditOrderModel pojoCreditOrderModel);

    @DELETE(DELETE_CREDIT_ORDER)
    Call<CreditOrderModel> rejectCreditOrderById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @POST(CHANGE_CREDIT_ORDER_STATUS)
    Call<CreditOrderModel> changeCreditOrderStatus(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id, @Body CreditOrderModel pojoCreditOrderModel);

    @PATCH(APPROVE_CREDIT_ORDER_BY_ID)
    Call<Void> approveCreditOrder(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(BLOCK_CREDIT_ORDER_BY_ID)
    Call<Void> blockCreditOrder(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @PATCH(PREPARE_CREDIT_ORDER_BY_ID)
    Call<Void> prepareCreditOrder(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);
}
