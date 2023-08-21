package api.services;

import api.models.controllers.AddressModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static constants.ApiEndpoints.*;
import static constants.ApiInterfaceServicesData.*;

public interface AddressService {

    @GET(GET_ALL_ADDRESSES)
    Call<List<AddressModel>> getAllAddresses(@Header(API_AUTHORIZATION) String token);

    @GET(GET_ADDRESSES_BY_ID)
    Call<AddressModel> getAddressById(@Header(API_AUTHORIZATION) String token, @Path(API_ID)  String id);

    @GET(GET_ADDRESSES_BY_USER_ID)
    Call<AddressModel> getAddressByUserId(@Header(API_AUTHORIZATION) String token,@Path(API_USER_ID) String userId);

    @PUT(UPDATE_ADDRESSES)
    Call<Void> updateAddress(@Header(API_AUTHORIZATION) String token, @Body AddressModel address);
}
