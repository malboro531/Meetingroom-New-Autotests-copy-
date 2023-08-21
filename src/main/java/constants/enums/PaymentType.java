package constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    DEBIT_CARD("DEBIT_CARD"),
    DEPOSIT("DEPOSIT"),
    CREDIT_ACCOUNT("CREDIT_ACCOUNT"),
    BANK_ACCOUNT("BANK_ACCOUNT"),
    DEBIT_ACCOUNT("DEBIT_ACCOUNT"),
    PAYMENT("TRANSFER_TYPE_PAYMENT");

    private final String paymentType;
}