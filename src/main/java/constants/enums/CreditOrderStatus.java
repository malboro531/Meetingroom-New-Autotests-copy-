package constants.enums;

import lombok.Getter;

@Getter
public enum CreditOrderStatus {
    PREPARED,
    REJECTED,
    APPROVED,
    PENDING,
    BLOCK,
    DONE
}
