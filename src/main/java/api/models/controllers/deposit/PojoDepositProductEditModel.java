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
public class PojoDepositProductEditModel {
    private String id;
    private String depositName;
    private String type_id;
    private Type type;
    private String currency_id;
    private Currency currency;
    private int minTermMonths;
    private int maxTermMonths;
    private int minAmount;
    private int maxAmount;
    private int minInterestRate;
    private int maxInterestRate;
    private boolean fixedInterest;
    private boolean subsequentReplenishment;
    private boolean earlyWithdrawal;
    private boolean interestWithdrawal;
    private double interestWithdrawalRate;
    private boolean capitalization;
    @SerializedName("isRevocable")
    private boolean isRevocable;
    @SerializedName("isCustomizable")
    private boolean isCustomizable;
    @SerializedName("isActive")
    private boolean isActive;
    private List<DescriptionEditDepositProduct> descriptions;
}
