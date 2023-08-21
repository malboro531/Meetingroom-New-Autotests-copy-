package helpers;

import driver.manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;

import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadFileFromDevice {
    public static byte[] downloadFileFromAndroid(String remotePath, String name) {
        byte[] bytes = ((AndroidDriver) DriverManager.getDriver()).pullFile(remotePath);
        try (FileOutputStream fos = new FileOutputStream(name)) {
            fos.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes;
    }
}