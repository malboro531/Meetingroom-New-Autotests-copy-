package api.services;

import api.models.controllers.AllRegularPaymentsModel;
import api.models.controllers.RegularPaymentModel;
import retrofit2.Call;
import retrofit2.http.*;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface RegularPaymentService {

    @POST(CREATE_REGULAR_PAYMENT)
    Call<RegularPaymentModel> createRegularPayment(@Header(API_AUTHORIZATION) String token, @Body RegularPaymentModel pojoRegularPaymentModel);

    @PUT(UPDATE_REGULAR_PAYMENT)
    Call<RegularPaymentModel> updateRegularPayment(@Header(API_AUTHORIZATION) String token, @Body RegularPaymentModel pojoRegularPaymentModel);

    @GET(GET_REGULAR_PAYMENT_BY_ID)
    Call<RegularPaymentModel> getRegularPaymentById(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);

    @GET(GET_ALL_REGULAR_PAYMENTS)
    Call<AllRegularPaymentsModel> getAllRegularPayments(@Header(API_AUTHORIZATION) String token, @Query(API_PAGE) int page, @Query(API_SIZE) int size,
                                             @Query(API_SORT) String sort);

    @DELETE(DELETE_REGULAR_PAYMENT)
    Call<RegularPaymentModel> deleteRegularPayment(@Header(API_AUTHORIZATION) String token, @Path(API_ID) String id);
}
