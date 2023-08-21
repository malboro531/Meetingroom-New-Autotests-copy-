package verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static constants.Messages.CONDITIONS_NOT_REACHED;

public class VerifySoft {

    private static final Logger logger = LogManager.getLogger(Verify.class.getName());
    private static SoftAssert softAssert = new SoftAssert();

    private static void addMessage(String message) {
        logger.info(message);
        AllureLog.addAttachmentAndMessage(message);
    }

    public static void verifyTrueSoft(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public static void verifyFalseSoft(boolean condition, String message) {
        softAssert.assertFalse(condition, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(int actual, int expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(long actual, long expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(boolean actual, boolean expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(double actual, double expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyEqualsSoft(List actual, List expected, String message) {
        softAssert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyNotNullSoft(String actual, String message) {
        softAssert.assertNotNull(actual, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyNotEqualsSoft(String actual, String expected, String message) {
        softAssert.assertNotEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
    }

    public static void verifyFailSoft(String message) {
        softAssert.fail(message);
    }

    public static void showAllChecking() {
        try {
            softAssert.assertAll();
        } finally {
            resetSoftAssert();
        }
    }

    public static void showAllChecking(String message) {
        showAllChecking();
        addMessage(message);
    }

    public static void resetSoftAssert() {
        softAssert = new SoftAssert();
    }
}
