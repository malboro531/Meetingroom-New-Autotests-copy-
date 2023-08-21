package driver.manager;

import constants.BitMask;
import constants.Configuration;
import constants.GlobalData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static constants.BitMask.getValue;
import static constants.SettingData.WAIT_TIMEOUT;
import static helpers.DeviceDataReader.getDesiredCapabilities;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class DriverManager {

    protected static AppiumDriver driver;

    public static URL createUrl() {
        try {
            return new URL(GlobalData.BASE_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Can't create URL with this parameter: " + GlobalData.BASE_URL);
        }
    }

    private static AppiumDriver createDriver() {
        switch (Configuration.PLATFORM_NAME) {
            case ANDROID -> driver = new AndroidDriver(createUrl(), getDesiredCapabilities());
            case IOS -> driver = new IOSDriver(createUrl(), getDesiredCapabilities());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        return driver;
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                driver = createDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void setNetworkConnection(BitMask bitMask) {
        ((AndroidDriver) driver).setConnection(new ConnectionState(getValue(bitMask)));
    }

    public static void closeDeviceKeyboard() {
        ((AndroidDriver) driver).hideKeyboard();
    }

    public static void tapBackOnDevice() {
        driver.navigate().back();
    }
}