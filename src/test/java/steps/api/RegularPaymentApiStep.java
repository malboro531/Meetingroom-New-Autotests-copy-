package steps.api;

import api.managers.RegularPaymentManager;
import api.models.controllers.AllRegularPaymentsModel;
import api.models.controllers.RegularPaymentModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;

public class RegularPaymentApiStep {

    private RegularPaymentManager regularPaymentManager = new RegularPaymentManager();

    @Step("Create regular payment")
    public Response<RegularPaymentModel> createRegularPayment(RegularPaymentModel pojoRegularPaymentModel) {
        return regularPaymentManager.createRegularPayment(pojoRegularPaymentModel);
    }

    @Step("Update regular payment")
    public Response<RegularPaymentModel> updateRegularPayment(RegularPaymentModel pojoRegularPaymentModel) {
        return regularPaymentManager.updateRegularPayment(pojoRegularPaymentModel);
    }

    @Step("Get credit product by id")
    public Response<RegularPaymentModel> getRegularPaymentById(String id) {
        return regularPaymentManager.getRegularPaymentById(id);
    }

    @Step("Get all regular payments")
    public Response<AllRegularPaymentsModel> getAllRegularPayments(int page, int size, String sort) {
        return regularPaymentManager.getAllRegularPayments(page, size, sort);
    }

    @Step("Check regular payment in DB")
    public void verifyRegularPaymentInDataBase(RegularPaymentModel pojoRegularPaymentModel, RegularPaymentModel regularPaymentModel) {
        Verify.verifyEquals(pojoRegularPaymentModel.getId(), regularPaymentModel.getId(), "Regular payment id found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getDescription(), regularPaymentModel.getDescription(), "Regular payment description found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getStartDate() + " 00:00:00", regularPaymentModel.getStartDate(), "Regular payment start date found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getNextDate() + " 00:00:00", regularPaymentModel.getNextDate(), "Regular payment next date found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getSourceCardId(), regularPaymentModel.getSourceCardId(), "Regular payment source card id found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getRecipientCardId(), regularPaymentModel.getRecipientCardId(), "Regular payment recipient card id found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getAmount(), regularPaymentModel.getAmount(), "Regular payment amount found in DB");
        Verify.verifyEquals(pojoRegularPaymentModel.getFrequency(), regularPaymentModel.getFrequency(), "Regular payment frequency found in DB");
        Verify.verifyTrue(pojoRegularPaymentModel.isActive(), "Regular payment active found in DB");
    }

    @Step("Delete regular payment by id")
    public Response<RegularPaymentModel> deleteRegularPayment(String id) {
        return regularPaymentManager.deleteRegularPayment(id);
    }

    @Step("Verify that all fields in response body 'get regular payment by id' are not null")
    public void verifyFieldsNotNull(RegularPaymentModel regularPaymentModel) {
        Verify.verifyNotNull(regularPaymentModel.getId(), "There is id in response body");
        Verify.verifyNotNull(regularPaymentModel.getDescription(), "There is description in response body");
        Verify.verifyNotNull(regularPaymentModel.getStartDate(), "There is start date in response body");
        Verify.verifyNotNull(regularPaymentModel.getNextDate(), "There is next date in response body");
        Verify.verifyNotNull(regularPaymentModel.getSourceCardId(), "There is source card in response body");
        Verify.verifyNotNull(regularPaymentModel.getRecipientCardId(), "There is recipient card in response body");
        Verify.verifyNotNull(regularPaymentModel.getAmount(), "There is amount in response body");
        Verify.verifyNotNull(regularPaymentModel.getFrequency(), "There is frequency in response body");
        Verify.verifyNotNull(regularPaymentModel.isActive(), "There is 'is active'-information in response body");
    }

    @Step("Check count of regular payments in Data Base")
    public void checkAllRegularPayments(Integer baseCount, Integer responseCount) {
        Verify.verifyEquals(baseCount, responseCount, "Count regular payments in DataBase matches with response count");
    }
}
