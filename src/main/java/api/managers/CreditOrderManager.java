package api.managers;

import api.models.controllers.AllCreditOrdersModel;
import api.models.controllers.CreditOrderModel;
import api.services.CreditOrderService;
import retrofit2.Call;
import retrofit2.Response;

import static constants.ApiDataBase.BASE_URL;

public class CreditOrderManager extends BaseManager {

    private CreditOrderService creditOrderService = initialise(BASE_URL).create(CreditOrderService.class);

    public Response<CreditOrderModel> createCreditOrder(CreditOrderModel pojoCreditOrderModel) {
        Call<CreditOrderModel> call = creditOrderService
                .createCreditOrder(TokenManager.getToken(), pojoCreditOrderModel);
        return getResponse(call);
    }

    public Response<CreditOrderModel> getCreditOrderById(String id) {
        Call<CreditOrderModel> call = creditOrderService.getCreditOrderById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<AllCreditOrdersModel> getAllCreditOrdersByOwnerId(String id, int page, int size, String sort) {
        Call<AllCreditOrdersModel> call = creditOrderService
                .getAllCreditOrdersByOwnerId(TokenManager.getToken(), id, page, size, sort);
        return getResponse(call);
    }

    public Response<AllCreditOrdersModel> getAllCreditOrders(int page, int size, String sort) {
        Call<AllCreditOrdersModel> call = creditOrderService
                .getAllCreditOrders(TokenManager.getToken(), page, size, sort);
        return getResponse(call);
    }

    public Response<CreditOrderModel> updateCreditOrder(CreditOrderModel pojoCreditOrderModel) {
        Call<CreditOrderModel> call = creditOrderService
                .updateCreditOrder(TokenManager.getToken(), pojoCreditOrderModel);
        return getResponse(call);
    }

    public Response<CreditOrderModel> rejectCreditOrderById(String id) {
        Call<CreditOrderModel> call = creditOrderService
                .rejectCreditOrderById(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<CreditOrderModel> changeCreditOrderStatus(String id, CreditOrderModel pojoCreditOrderModel) {
        Call<CreditOrderModel> call = creditOrderService
                .changeCreditOrderStatus(TokenManager.getToken(), id, pojoCreditOrderModel);
        return getResponse(call);
    }

    public Response<Void> approveCreditOrder(String id) {
        Call<Void> call = creditOrderService.approveCreditOrder(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> blockCreditOrder(String id) {
        Call<Void> call = creditOrderService.blockCreditOrder(TokenManager.getToken(), id);
        return getResponse(call);
    }

    public Response<Void> prepareCreditOrder(String id) {
        Call<Void> call = creditOrderService.prepareCreditOrder(TokenManager.getToken(), id);
        return getResponse(call);
    }
}
