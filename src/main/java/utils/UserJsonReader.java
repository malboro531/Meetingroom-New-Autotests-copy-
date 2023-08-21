package utils;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserJsonReader {

    private static Map<String, String> testData = new HashMap<>();

    public static String getValueByKey(String fileSource, String key) {
        if (testData.isEmpty())
            jsonFileToTestData(fileSource);
        return testData.get(key);
    }

    private static void jsonFileToTestData(String fileSource) {
        File file = new File(fileSource);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testData = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
