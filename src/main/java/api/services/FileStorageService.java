package api.services;

import api.models.controllers.FileStorageModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

import static constants.ApiEndpoints.GET_ALL_FILE_INFO_DTO;

public interface FileStorageService {

    @GET(GET_ALL_FILE_INFO_DTO)
    Call<List<FileStorageModel>> getAllFileInfoDto();
}
