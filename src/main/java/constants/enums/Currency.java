package constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {

    RUB ("RUB"),
    USD ("USD"),
    EUR ("EUR");

    private final String currency;
}
