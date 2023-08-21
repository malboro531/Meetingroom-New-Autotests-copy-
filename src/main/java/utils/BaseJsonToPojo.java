package utils;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class BaseJsonToPojo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getDataFromJson(String path, Class<T> tClass) {
        try {
            return objectMapper.readValue(new File(path), tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
