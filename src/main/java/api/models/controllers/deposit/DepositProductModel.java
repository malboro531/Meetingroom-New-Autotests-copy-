package api.models.controllers.deposit;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositProductModel {

    private String id;
    private String depositName;
    private Type type;
    private Currency currency;
    private int minTermMonths;
    private int maxTermMonths;
    private int minAmount;
    private int maxAmount;
    private boolean fixedInterest;
    private boolean subsequentReplenishment;
    private boolean earlyWithdrawal;
    private double interestWithdrawalRate;
    private boolean capitalization;
    @SerializedName("isRevocable")
    private boolean isRevocable;
    @SerializedName("isCustomizable")
    private boolean isCustomizable;
    @SerializedName("isActive")
    private boolean isActive;
    private List<Description> descriptions;
}