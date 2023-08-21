package api.managers.InformationService;

import api.managers.BaseManager;
import api.models.controllers.FileStorageModel;
import api.services.FileStorageService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class FileStorageManager extends BaseManager {

    private FileStorageService fileStorageService = initialise(BASE_URL).create(FileStorageService.class);

    public Response<List<FileStorageModel>> getAllFileInfoDto() {
        Call<List<FileStorageModel>> call = fileStorageService.getAllFileInfoDto();
        return getResponse(call);
    }
}
