package constants;

import helpers.PropertiesProvider;

public class Configuration {

    public static final String DEFAULT_PLATFORM_NAME = "Android";
    public static final String DEFAULT_DEVICE_NAME = "DEVICE";
    public static final String DEFAULT_VERSION = "12.0";
    public static final String PLATFORM_NAME = System.getProperty("platformName", DEFAULT_PLATFORM_NAME);
    public static final String DEVICE_NAME = System.getProperty("device", DEFAULT_DEVICE_NAME);
    public static final String VERSION = System.getProperty("version", DEFAULT_VERSION);
    public static final String APP_PACKAGE = PropertiesProvider.provideProperty("appPackage");
}
