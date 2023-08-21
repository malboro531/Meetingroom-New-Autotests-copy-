package api.managers.InformationService;

import api.managers.BaseManager;
import api.models.controllers.InformationModel;
import api.services.InformationService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static constants.ApiDataBase.BASE_URL;

public class InformationManager extends BaseManager {

    private InformationService informationService = initialise(BASE_URL).create(InformationService.class);

    public Response<List<InformationModel>> getAllCountries() {
        Call<List<InformationModel>> call = informationService.getAllCountries();
        return getResponse(call);
    }

    public Response<List<InformationModel>> getAllCitiesByCountryID(int id, int page, int size,
                                                              String sort,
                                                              boolean onlyWithBranches, boolean singlePage) {
        Call<List<InformationModel>> call = informationService.getAllCitiesByCountryID(id, page, size,
                sort,
                onlyWithBranches, singlePage);
        return getResponse(call);
    }

    public Response<List<InformationModel>> getAllStreetsByCountryID(int id) {
        Call<List<InformationModel>> call = informationService.getAllStreetsByCountryID(id);
        return getResponse(call);
    }

    public Response<List<InformationModel>> getAllBankBranchesByCityID(int id) {
        Call<List<InformationModel>> call = informationService.getAllBankBranchesByCityID(id);
        return getResponse(call);
    }

    public Response<List<InformationModel>> getAllTimetablesByBranchID(int id) {
        Call<List<InformationModel>> call = informationService.getAllTimetablesByBranchID(id);
        return getResponse(call);
    }
}
