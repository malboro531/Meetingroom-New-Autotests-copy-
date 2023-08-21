package api.services;

import api.models.controllers.InformationModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface InformationService {
    @GET(GET_ALL_COUNTRIES)
    Call<List<InformationModel>> getAllCountries();

    @GET(GET_ALL_CITIES_BY_COUNTRY_ID)
    Call<List<InformationModel>> getAllCitiesByCountryID(@Path(API_ID) int id,
                                            @Query(API_PAGE) int page,
                                            @Query(API_SIZE) int size,
                                            @Query(API_SORT) String sort,
                                            @Query(API_ONLY_WITH_BRANCHES) Boolean onlyWithBranches,
                                            @Query(API_SINGLE_PAGE) Boolean singlePage);

    @GET(GET_ALL_STREETS_BY_CITY_ID)
    Call<List<InformationModel>> getAllStreetsByCountryID(@Path(API_ID) int id);

    @GET(GET_ALL_BANK_BRANCHES_BY_CITY_ID)
    Call<List<InformationModel>> getAllBankBranchesByCityID(@Path(API_ID) int id);

    @GET(GET_ALL_TIMETABLES_BY_BRANCH_ID)
    Call<List<InformationModel>> getAllTimetablesByBranchID(@Path(API_ID) int id);
}
