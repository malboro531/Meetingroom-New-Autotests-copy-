package mrn_api.deposit_controller;

import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.AllSortDepositProductModel;
import api.models.controllers.deposit.Currency;
import api.models.controllers.deposit.DepositProductModel;
import api.models.controllers.deposit.Type;
import api.services.TestRails;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProductEdit;

import java.util.List;

import static constants.AllureData.API_DEPOSIT_PRODUCT_CONTROLLER;
import static constants.GlobalData.*;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.*;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DepositProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6137074")
    @Test(description = "Get deposit product by id with valid data, role User", groups = {"Api"})
    public void C6137074() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGet, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6137076")
    @Test(description = "Get deposit product by id with non-existent data, role User", groups = {"Api"})
    public void C6137076() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGet, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137081")
    @Test(description = "Get All deposit products with valid data, role User", groups = {"Api"})
    public void C6137081() {
        Response<AllDepositProductsModel> responseGet = depositProductApiStep
                .getAllDepositModel(0, 1000);
        checkResponseCode(responseGet, HTTP_OK);
        checkAll();
        int quantityDepositProductsDB = depositProductDBManager.getAll().size();
        Assert.assertEquals(responseGet.body().getNumberOfElements(), quantityDepositProductsDB);
    }

    @TestRails(id = "C6137093")
    @Test(description = "Edit deposit product with valid data, role User", groups = {"Api"})
    public void C6137093() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137095")
    @Test(description = "Edit deposit product non-existent data, role User", groups = {"Api"})
    public void C6137095() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137096")
    @Test(description = "Edit previously edited deposit product valid data, role User", groups = {"Api"})
    public void C6137096() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6137116")
    @Test(description = "Search deposit product by depositName and currencyName with valid data," +
            " role User", groups = {"Api"})
    public void C6137116() {
        Response<AllDepositProductsModel> responseGetAll = depositProductApiStep
                .getDepositProductByNameAndCurrency(0, 1000, VALID_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT,
                        VALID_CURRENCY_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGetAll, HTTP_OK);
        checkAll();
        int quantityDepositProductsWithNameAndCurrencyDB =
                depositProductDBManager.getAllWithNameAndCurrency(VALID_CURRENCY_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT,
                        VALID_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT).size();
        depositProductApiStep.checkResponceDataBaseCountDepositProduct(quantityDepositProductsWithNameAndCurrencyDB,
                responseGetAll.body().getNumberOfElements());
    }

    @TestRails(id = "C6137084")
    @Test(description = "Get all currencies for deposit products, role User", groups = {"Api"})
    public void C6137084() {
        Response<List<Currency>> allDepositCurrencies = depositProductApiStep.getAllDepositCurrencies();
        checkResponseCode(allDepositCurrencies, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6137087")
    @Test(description = "Get all types for deposit products, role User", groups = {"Api"})
    public void C6137087() {
        Response<List<Type>> getAllTypesForDepositProducts = depositProductApiStep.getAllTypesForDepositProducts();
        checkResponseCode(getAllTypesForDepositProducts, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6137120")
    @Test(description = "Get filtered deposit products, role User", groups = {"Api"})
    public void C6137120() {
        Response<AllSortDepositProductModel> response = depositProductApiStep
                .getFilteredDepositProducts(0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }
}
