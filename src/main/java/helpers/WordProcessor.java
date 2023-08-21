package helpers;

import static constants.GlobalData.*;

public class WordProcessor {

    public static String convertToAsterisks(String text) {
        return "*".repeat(text.length());
    }

    public static String generatePasswordByLength(int length) {
        return PASSWORD_EXAMPLE.substring(0, length);
    }

    public static String generateLoginByLength(int length) {
        return LOGIN_EXAMPLE.substring(0, length);
    }

    public static String generateCodeByLength(int length) {
        return CODE_EXAMPLE.substring(0, length);
    }
}
