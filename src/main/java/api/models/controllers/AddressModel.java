package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddressModel {

    private int id;
    @SerializedName(value = "userId", alternate ="user_id")
    private String userId;
    @SerializedName(value = "zipCode", alternate = "zip_code")
    private int zipCode;
    private String country;
    private String region;
    private String location;
    private String city;
    private String street;
    private String house;
    private String building;
    private String flat;
}
