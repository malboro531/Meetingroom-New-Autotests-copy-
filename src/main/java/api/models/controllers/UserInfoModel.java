package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInfoModel {

    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("first_Name")
    private String firstName;
    @SerializedName("last_Name")
    private String lastName;
    private String patronymic;
    @SerializedName("account_number")
    private String accountNumber;
    private String currency;
    @SerializedName("bank_name")
    private String bankName;
}
