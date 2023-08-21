package helpers;

import java.io.IOException;

public class PropertiesProvider {

    public static String provideProperty(String property) {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty(property);
    }

    public static String provideTestRailProperty(String property) {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config/testrail.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty(property);
    }
}
