package steps.api;

import api.managers.InformationService.InformationManager;
import api.models.controllers.InformationModel;
import retrofit2.Response;

import java.util.List;

public class InformationApiStep {

    private InformationManager informationManager = new InformationManager();

    public Response<List<InformationModel>> getAllCountries() {
        return informationManager.getAllCountries();
    }

    public Response<List<InformationModel>> getAllCitiesByCountryID(int id, int page, int size,
                                                                    String sort,
                                                                    boolean onlyWithBranches, boolean singlePage) {
        return informationManager.getAllCitiesByCountryID(id, page, size, sort, onlyWithBranches, singlePage);
    }

    public Response<List<InformationModel>> getAllStreetsByCountryID(int id) {
        return informationManager.getAllStreetsByCountryID(id);
    }

    public Response<List<InformationModel>> getAllBankBranchesByCityID(int id) {
        return informationManager.getAllBankBranchesByCityID(id);
    }

    public Response<List<InformationModel>> getAlTimetablesByBranchID(int id) {
        return informationManager.getAllTimetablesByBranchID(id);
    }
}
