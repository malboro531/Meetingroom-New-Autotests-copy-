package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonAutoDetect;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
@Getter
public class ErrorMessageModel {

    private String message;
    private int errorCode;
    private int status;
    private String error;
}
