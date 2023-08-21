package steps.api;

import api.managers.InformationService.FileStorageManager;
import api.models.controllers.FileStorageModel;
import retrofit2.Response;

import java.util.List;

public class FileStorageApiStep {
    private FileStorageManager fileStorageManager = new FileStorageManager();

    public Response<List<FileStorageModel>> getAllFileInfoDto() {
        return fileStorageManager.getAllFileInfoDto();
    }
}
