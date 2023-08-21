package mrn_api.deposit_controller;

import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.AllSortDepositProductModel;
import api.models.controllers.deposit.Currency;
import api.models.controllers.deposit.DepositProductModel;
import api.models.controllers.deposit.Type;
import api.services.TestRails;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProductEdit;

import java.util.List;

import static constants.AllureData.API_DEPOSIT_PRODUCT_CONTROLLER;
import static constants.GlobalData.*;
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.*;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DepositProductUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6137077")
    @Test(description = "Get deposit product by id with valid data, role Unauthorized", groups = {"Api"})
    public void C6137077() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(VALID_ID_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGet, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137079")
    @Test(description = "Get deposit product by id with non-existent data, role Unauthorized", groups = {"Api"})
    public void C6137079() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGet, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137082")
    @Test(description = "Get All deposit products with valid data, role Unauthorized", groups = {"Api"})
    public void C6137082() {
        Response<AllDepositProductsModel> responseGet = depositProductApiStep
                .getAllDepositModel(0, 1000);
        checkResponseCode(responseGet, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137097")
    @Test(description = "Edit deposit product with valid data, role Unauthorized", groups = {"Api"})
    public void C6137097() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137100")
    @Test(description = "Edit deposit product non-existent data, role Unauthorized", groups = {"Api"})
    public void C6137100() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137101")
    @Test(description = "Edit previously edited deposit product valid data, role Unauthorized", groups = {"Api"})
    public void C6137101() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137117")
    @Test(description = "Search deposit product by depositName and currencyName with valid data," +
            " role Unauthorized", groups = {"Api"})
    public void C6137117() {
        Response<AllDepositProductsModel> responseGetAll = depositProductApiStep
                .getDepositProductByNameAndCurrency(0, 1000,
                        VALID_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT, VALID_CURRENCY_NAME_FOR_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGetAll, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137085")
    @Test(description = "Get all currencies for deposit products, role Unauthorized", groups = {"Api"})
    public void C6137085() {
        Response<List<Currency>> getAllDepositCurrencies = depositProductApiStep.getAllDepositCurrencies();
        checkResponseCode(getAllDepositCurrencies, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137088")
    @Test(description = "Get all types for deposit products, role Unauthorized", groups = {"Api"})
    public void C6137088() {
        Response<List<Type>> getAllTypes = depositProductApiStep.getAllTypesForDepositProducts();
        checkResponseCode(getAllTypes, HTTP_UNAUTHORIZED);
        checkAll();
    }

    @TestRails(id = "C6137121")
    @Test(description = "Get filtered deposit products, role Unauthorized", groups = {"Api"})
    public void C6137121() {
        Response<AllSortDepositProductModel> response = depositProductApiStep
                .getFilteredDepositProducts(0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
