package mrn_api.deposit_controller;

import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.*;
import api.services.TestRails;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import utils.JsonToPojoDepositProduct;
import utils.JsonToPojoDepositProductEdit;

import java.util.List;

import static constants.AllureData.API_DEPOSIT_PRODUCT_CONTROLLER;
import static constants.ApiDataBase.SQL_SELECT_DEPOSIT_PRODUCT_BY_ID;
import static constants.GlobalData.INVALID_ID_FOR_DEPOSIT_PRODUCT_GET;
import static constants.GlobalData.VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

@Feature(API_DEPOSIT_PRODUCT_CONTROLLER)
public class DepositProductAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6137071")
    @Test(description = "Get deposit product by id with valid data, role Admin", groups = {"Api"})
    public void C6137071() {
        Response<PojoDepositProductModel> responseCreate = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        Response<DepositProductModel> response = depositProductApiStep
                .getDepositProductById(responseCreate.body().getId());
        checkResponseCode(response, HTTP_OK);
        DepositProductModel depositProductModelSql = depositProductDBManager
                .getById(SQL_SELECT_DEPOSIT_PRODUCT_BY_ID, responseCreate.body().getId());
        depositProductApiStep.checkDepositProduct(response.body(), depositProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6137073")
    @Test(description = "Get deposit product by id with non-existent data, role Admin", groups = {"Api"})
    public void C6137073() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(VALID_ID_FOR_NON_EXISTENT_DEPOSIT_PRODUCT);
        checkResponseCode(responseGet, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137080")
    @Test(description = "Get All deposit products with valid data, role Admin", groups = {"Api"})
    public void C6137080() {
        Response<AllDepositProductsModel> responseGet = depositProductApiStep
                .getAllDepositModel(0, 1000);
        checkResponseCode(responseGet, HTTP_OK);
        checkAll();
        int quantityDepositProductsDB = depositProductDBManager.getAll().size();
        depositProductApiStep.checkResponceDataBaseCountDepositProduct(quantityDepositProductsDB,
                responseGet.body().getNumberOfElements());
    }

    @TestRails(id = "C6137089")
    @Test(description = "Edit deposit product valid data, role Admin", groups = {"Api"})
    public void C6137089() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_OK);

        String depositProductID = JsonToPojoDepositProductEdit.getDepositProductEditModel().getId();

        Response<DepositProductModel> depositProduct = depositProductApiStep
                .getDepositProductById(depositProductID);
        DepositProductModel depositProductModelSql = depositProductDBManager
                .getById(SQL_SELECT_DEPOSIT_PRODUCT_BY_ID, depositProductID);
        depositProductApiStep.checkDepositProduct(depositProduct.body(), depositProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6137091")
    @Test(description = "Edit deposit product non-existent data, role Admin", groups = {"Api"})
    public void C6137091() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductModelNonExistentData());
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    @TestRails(id = "C6137092")
    @Test(description = "Edit previously edited deposit product valid data, role Admin", groups = {"Api"})
    public void C6137092() {
        Response<Void> response = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(response, HTTP_OK);
        Response<Void> repeatResponse = depositProductApiStep
                .editDepositProduct(JsonToPojoDepositProductEdit.getDepositProductEditModel());
        checkResponseCode(repeatResponse, HTTP_OK);

        String depositProductID = JsonToPojoDepositProductEdit.getDepositProductEditModel().getId();

        Response<DepositProductModel> depositProduct = depositProductApiStep
                .getDepositProductById(depositProductID);
        DepositProductModel depositProductModelSql = depositProductDBManager
                .getById(SQL_SELECT_DEPOSIT_PRODUCT_BY_ID, depositProductID);
        depositProductApiStep.checkDepositProduct(depositProduct.body(), depositProductModelSql);
        checkAll();
    }

    @TestRails(id = "C6137115")
    @Test(description = "Search deposit product by depositName and currencyName with valid data," +
            " role Admin", groups = {"Api"})
    public void C6137115() {
        Response<PojoDepositProductModel> responseCreate = depositProductApiStep
                .createDepositProduct(JsonToPojoDepositProduct.getPojoDepositProductModel());
        checkResponseCode(responseCreate, HTTP_OK);
        Response<AllDepositProductsModel> responseGetAll = depositProductApiStep
                .getDepositProductByNameAndCurrency(0, 1000,
                        responseCreate.body().getDepositName(),
                        responseCreate.body().getCurrency().getName());
        int quantityDepositProductsWithNameAndCurrencyDB =
                depositProductDBManager.getAllWithNameAndCurrency(responseCreate.body().getCurrency().getName(),
                        responseCreate.body().getDepositName()).size();
        depositProductApiStep.checkResponceDataBaseCountDepositProduct(quantityDepositProductsWithNameAndCurrencyDB,
                responseGetAll.body().getNumberOfElements());
        depositProductApiStep.deleteDepositProductByID(responseCreate.body().getId());
        checkAll();
    }

    @TestRails(id = "C6137072")
    @Test(description = "Get deposit product by id with invalid data, role Admin", groups = {"Api"})
    public void C6137072() {
        Response<DepositProductModel> responseGet = depositProductApiStep
                .getDepositProductById(INVALID_ID_FOR_DEPOSIT_PRODUCT_GET);
        checkResponseCode(responseGet, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6137083")
    @Test(description = "Get all currencies for deposit products, role Admin", groups = {"Api"})
    public void C6137083() {
        Response<List<Currency>> allDepositCurrencies = depositProductApiStep.getAllDepositCurrencies();
        checkResponseCode(allDepositCurrencies, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6137086")
    @Test(description = "Get all types for deposit products, role Admin", groups = {"Api"})
    public void C6137086() {
        Response<List<Type>> getAllTypesForDepositProducts = depositProductApiStep.getAllTypesForDepositProducts();
        checkResponseCode(getAllTypesForDepositProducts, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6137119")
    @Test(description = "Get filtered deposit products, role Admin", groups = {"Api"})
    public void C6137119() {
        Response<AllSortDepositProductModel> response = depositProductApiStep
                .getFilteredDepositProducts(0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }
}
