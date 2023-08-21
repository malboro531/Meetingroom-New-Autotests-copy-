package mrn_api.information_controller;

import api.models.controllers.InformationModel;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.Verify;
import verification.VerifySoft;

import java.util.List;
import java.util.stream.Collectors;

import static constants.AllureData.API_FILE_STORAGE_CONTROLLER;
import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.ApiInformationData.*;
import static constants.ApiPassportData.ERROR_NULL_BODY_MSG;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_4_ORDER_CARD)
@Feature(API_FILE_STORAGE_CONTROLLER)
public class GetInformationTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5978809")
    @Test(description = "Get list of all countries is not null", groups = {"Api"})
    public void testGetAllCountriesNotNull() {
        Response<List<InformationModel>> response = informationApiStep.getAllCountries();
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        List<InformationModel> listBodyResponse = response.body();
        List<String> listActualCountries = listBodyResponse.stream()
                .map(InformationModel::getName)
                .collect(Collectors.toList());
        VerifySoft.verifyEqualsSoft(listActualCountries.toString(), LIST_EXPECTED_COUNTRIES.toString(), ERROR_MESSAGE_NOT_EQUAL);
        checkAll();
    }

    @TestRails(id = "C5958129")
    @Test(description = "Get list of cities by valid country id", groups = {"Api"})
    public void testGetAllCitiesByValidCountryIdNotNull() {
        Response<List<InformationModel>> response = informationApiStep.getAllCitiesByCountryID(
                API_VALID_ID, API_DEFAULT_PAGE, API_DEFAULT_SIZE,
                API_DEFAULT_SORT,
                API_DEFAULT_FALSE_ONLY_WITH_BRANCHES, API_DEFAULT_FALSE_SINGLE_PAGE);
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        checkAll();
    }

    @Test(description = "Get list of cities by invalid country id")
    public void testGetAllCitiesByNotValidCountryId() {
        Response<List<InformationModel>> response = informationApiStep.getAllCitiesByCountryID(
                API_INVALID_ID, API_DEFAULT_PAGE, API_DEFAULT_SIZE,
                API_DEFAULT_SORT,
                API_DEFAULT_FALSE_ONLY_WITH_BRANCHES, API_DEFAULT_FALSE_SINGLE_PAGE);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        checkResponseCode(response, HTTP_OK);
        checkAll();

        //TODO returns 200 and empty message
    }

    @TestRails(id = "C5958131")
    @Test(description = "Get list of street by valid city id", groups = {"Api"})
    public void testGetAllStreetsByCityIdNotNull() {
        Response<List<InformationModel>> response = informationApiStep.getAllStreetsByCountryID(API_VALID_ID);
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        checkAll();
    }

    @TestRails(id = "C5958129")
    @Test(description = "Get list of bank branches by valid city id", groups = {"Api"})
    public void testGetAllBankBranchesByCityIdNotNull() {
        Response<List<InformationModel>> response = informationApiStep.getAllBankBranchesByCityID(API_VALID_ID);
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        checkAll();
    }

    @TestRails(id = "C5958129")
    @Test(description = "Get list of timetables branch by valid id", groups = {"Api"})
    public void testGetAlTimetablesByBranchIdNotNull() {
        Response<List<InformationModel>> response = informationApiStep.getAlTimetablesByBranchID(API_VALID_ID);
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        checkAll();
    }
}
