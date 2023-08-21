package constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum CardStatus {

    CREATED,
    READY,
    ACTIVE,
    BLOCKED,
    CLOSED;
}
