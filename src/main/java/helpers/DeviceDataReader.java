package helpers;

import constants.Configuration;
import constants.SettingData;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;

public class DeviceDataReader {

    private static final Logger logger = LogManager.getLogger(Waiter.class.getName());

    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String platformName = Configuration.PLATFORM_NAME;
        String partialAppPath = getProperty(MobileCapabilityType.APP);
        String fullAppPath = System.getProperty("user.dir") + partialAppPath;
        if (platformName.equals(MobilePlatform.ANDROID)) {
            String appPackage = getProperty(AndroidMobileCapabilityType.APP_PACKAGE);
            String appActivity = getProperty(AndroidMobileCapabilityType.APP_ACTIVITY);
            capabilities.setCapability(NEW_COMMAND_TIMEOUT, "3000");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
            capabilities.setCapability(MobileCapabilityType.APP, fullAppPath);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Configuration.DEVICE_NAME);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Configuration.PLATFORM_NAME);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Configuration.VERSION);
        } else {
            String automationName = getProperty(MobileCapabilityType.AUTOMATION_NAME);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        }
        return capabilities;
    }

    public static String getProperty(String propertyName) {
        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream(SettingData.PATH_PROPERTIES)) {
            property.load(fis);
            return property.getProperty(propertyName);
        } catch (IOException e) {
            logger.error("Error: File is not found or it not available or something wrong with reading file!");
            throw new UnsupportedOperationException("Error reading property: " + propertyName);
        }
    }
}
