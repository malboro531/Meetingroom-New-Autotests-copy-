package verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static constants.Messages.CONDITIONS_NOT_REACHED;

public class Verify {

    private static final Logger logger = LogManager.getLogger(Verify.class.getName());

    private static void addMessage(String message) {
        logger.info(message);
        AllureLog.addAttachmentAndMessage(message);
    }

    public static void verifyTrue(boolean condition, String message) {
        Assert.assertTrue(condition, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyFalse(boolean condition, String message) {
        Assert.assertFalse(condition, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyEquals(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyEquals(double actual, double expected, String message) {
        Assert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyNotNull(Object object, String message) {
        Assert.assertNotNull(object, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }

    public static void verifyNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, CONDITIONS_NOT_REACHED + message);
        addMessage(message);
    }
}
