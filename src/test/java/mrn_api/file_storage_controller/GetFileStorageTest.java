package mrn_api.file_storage_controller;

import api.models.controllers.FileStorageModel;
import api.services.TestRails;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.Verify;
import verification.VerifySoft;

import java.util.List;

import static constants.AllureData.API_FILE_STORAGE_CONTROLLER;
import static constants.AllureData.EPIC_4_ORDER_CARD;
import static constants.ApiFileStorageData.*;
import static constants.ApiPassportData.ERROR_NULL_BODY_MSG;
import static java.net.HttpURLConnection.HTTP_OK;

@Epic(EPIC_4_ORDER_CARD)
@Feature(API_FILE_STORAGE_CONTROLLER)
public class GetFileStorageTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5978815")
    @Test(description = "Check that all documents exist", groups = {"Api"})
    public void testAllDocumentsNamesArePresented() {
        Response<List<FileStorageModel>> response = fileStorageApiStep.getAllFileInfoDto();
        checkResponseCode(response, HTTP_OK);
        Verify.verifyNotNull(response.body(), ERROR_NULL_BODY_MSG);
        List<FileStorageModel> fileStorageBody = response.body();
        VerifySoft.verifyEqualsSoft(fileStorageBody.size(), 3, ERROR_MESSAGE_DOCUMENTS_SIZE);
        VerifySoft.verifyEqualsSoft(fileStorageBody.get(0).getFileName(), DOC_TERMS_NAME, ERROR_MESSAGE_DOCUMENTS_NAME);
        VerifySoft.verifyEqualsSoft(fileStorageBody.get(1).getFileName(), DOC_TARIFF_NAME, ERROR_MESSAGE_DOCUMENTS_NAME);
        VerifySoft.verifyEqualsSoft(fileStorageBody.get(2).getFileName(), DOC_FORM_NAME, ERROR_MESSAGE_DOCUMENTS_NAME);
        checkAll();
    }

    @TestRails(id = "C5978816")
    @Test(description = "Checl that all file download links exist", groups = {"Api"})
    public void testAllFilesGetExistedLinks() {
        Response<List<FileStorageModel>> response = fileStorageApiStep.getAllFileInfoDto();
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyFalseSoft(response.body() != null, ERROR_NULL_BODY_MSG);
        List<FileStorageModel> fileStorageBody = response.body();
        VerifySoft.verifyEqualsSoft(fileStorageBody.size(), 3, ERROR_MESSAGE_DOCUMENTS_SIZE);
        VerifySoft.verifyEqualsSoft(response.body().get(0).getLink(), DOC_TERMS_LINK, ERROR_MESSAGE_DOCUMENTS_LINK);
        VerifySoft.verifyEqualsSoft(response.body().get(1).getLink(), DOC_TARIFF_LINK, ERROR_MESSAGE_DOCUMENTS_LINK);
        VerifySoft.verifyEqualsSoft(response.body().get(2).getLink(), DOC_FORM_LINK, ERROR_MESSAGE_DOCUMENTS_LINK);
        checkAll();
    }
}
