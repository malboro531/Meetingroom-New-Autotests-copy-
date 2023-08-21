package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditModel;
import api.services.TestRails;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import javax.xml.crypto.Data;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_PRODUCT_BY_ID;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditProductUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    public String getCreditProductId() {
        Response<AllCreditAccountsModel> creditProductIdResponse = creditProductApiStep
                .getAllActiveCreditProducts(0, 10, Strings.EMPTY);
        return creditProductIdResponse.body().getContent().get(0).getId();
    }

    @TestRails(id = "C6214061")
    @Test(description = "Get credit product by id with valid data, role - USER", groups = {"Api"})
    public void c6214061() {
        Response<CreditModel> response = creditProductApiStep.getCreditProductById(getCreditProductId());
        checkResponseCode(response, HTTP_OK);
        CreditModel creditModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_PRODUCT_BY_ID,
                getCreditProductId()), CreditModel.class);
        creditProductApiStep.checkCreditProductInDataBase(response.body(), creditModelSql);
        checkAll();
    }

    @TestRails(id = "C6214040")
    @Test(description = "Get all active credit products, role - USER", groups = {"Api"})
    public void c6214040() {
        Response<AllCreditAccountsModel> response = creditProductApiStep
                .getAllActiveCreditProducts(0, 100, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditProductApiStep.checkAllActiveCreditProducts(response.body());
        checkAll();
    }

    @TestRails(id = "C6214042")
    @Test(description = "Get all credit products, role - USER", groups = {"Api"})
    public void c6214042() {
        Response<AllCreditAccountsModel> response = creditProductApiStep
                .getAllCreditProducts(0, 200, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditProductApiStep.checkCountOfAllCreditProducts(creditProductDBManager.getCountAllCreditProducts(),
                response.body().getContent().size());
        checkAll();
    }
}
