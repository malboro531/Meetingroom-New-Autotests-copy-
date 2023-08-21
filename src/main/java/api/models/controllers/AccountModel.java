package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountModel {

    private String id;
    @SerializedName("account_number")
    private String accountNumber;
    @SerializedName("open_date")
    private String openDate;
    @SerializedName("close_date")
    private String closeDate;
    @SerializedName("owner_id")
    private String ownerId;
    private String currency;
    @SerializedName("bank_name")
    private String bankName;
    private long balance;
    @SerializedName("is_active")
    private boolean active;
    @SerializedName("is_available_transfer")
    private String isAvailableTransfer;
}
