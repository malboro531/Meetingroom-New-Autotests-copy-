package api.managers;

import api.models.controllers.AllRegularPaymentsModel;
import api.models.controllers.RegularPaymentModel;
import api.services.RegularPaymentService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class RegularPaymentManager extends BaseManager {

    private RegularPaymentService regularPaymentService = initialise(BASE_URL).create(RegularPaymentService.class);

    public Response<RegularPaymentModel> createRegularPayment(RegularPaymentModel pojoRegularPaymentModel) {
        Call<RegularPaymentModel> call = regularPaymentService
                .createRegularPayment(TokenManager.getToken(), pojoRegularPaymentModel);
        return getResponse(call);
    }

    public Response<RegularPaymentModel> updateRegularPayment(RegularPaymentModel pojoRegularPaymentModel) {
        Call<RegularPaymentModel> call = regularPaymentService
                .updateRegularPayment(TokenManager.getToken(), pojoRegularPaymentModel);
        return getResponse(call);
    }

    public Response<RegularPaymentModel> getRegularPaymentById(String id) {
        Call<RegularPaymentModel> call = regularPaymentService
                .getRegularPaymentById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllRegularPaymentsModel> getAllRegularPayments(int page, int size, String sort) {
        Call<AllRegularPaymentsModel> call = regularPaymentService
                .getAllRegularPayments(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<RegularPaymentModel> deleteRegularPayment(String id) {
        Call<RegularPaymentModel> call = regularPaymentService
                .deleteRegularPayment(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
