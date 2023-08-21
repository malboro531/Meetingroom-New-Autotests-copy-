package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccountsModel {
    private String id;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("open_date")
    private String openDate;
    @SerializedName("close_date")
    private String closeDate;
    @SerializedName("bank_name")
    private String bankName;
    @SerializedName("account_number")
    private String accountNumber;
    @SerializedName("currency_name")
    private String currencyName;
    private int balance;
    @SerializedName("borrowing_limit")
    private int borrowingLimit;
    @SerializedName("next_date_temp")
    private String nextDateTemp;
    @SerializedName("billing_period")
    private int billingPeriod;
    @SerializedName("principalDebt")
    private int principalDebt;
    @SerializedName("is_active")
    private boolean isActive;
}