package api.models.controllers.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositModel {

    private String id;
    private String depositNumber;
    private DepositProductModel depositProduct;
    private String depositProductId;
    private Type type;
    private String typeId;
    private Currency currency;
    private String currencyId;
    private int termMonths;
    private String openDate;
    private String closeDate;
    private int amount;
    private double interestRate;
    private boolean fixedInterest;
    private boolean subsequentReplenishment;
    private boolean earlyWithdrawal;
    private boolean interestWithdrawal;
    private double interestWithdrawalRate;
    private boolean capitalization;
    private boolean isRevocable;
    private boolean isActive_status;
    private String userId;
    private List<LinkedCards> linkedCards;
}
