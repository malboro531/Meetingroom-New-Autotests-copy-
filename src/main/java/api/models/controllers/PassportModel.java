package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PassportModel {

    private int id;
    @SerializedName(value = "userId", alternate ="user_id")
    private String userId;
    @SerializedName(value = "addressId", alternate = "address_id")
    private int addressId;
    @SerializedName(value = "serialNumber", alternate = "serial_number")
    private String serialNumber;
    @SerializedName(value ="passportCode", alternate = "passport_code")
    private String passportCode;
    private String birthday;
    @SerializedName(value = "dateIssue", alternate = "date_issue")
    private String dateIssue;
    @SerializedName(value = "terminationDate", alternate = "termination_date")
    private String terminationDate;
    @SerializedName(value = "firstName", alternate = "first_name")
    private String firstName;
    @SerializedName(value = "lastName", alternate = "last_name")
    private String lastName;
    private String patronymic;
    @SerializedName(value = "bornPlace", alternate = "born_place")
    private String bornPlace;
    @SerializedName(value = "departmentIssued", alternate = "department_issued")
    private String departmentIssued;
    private List content;
}
