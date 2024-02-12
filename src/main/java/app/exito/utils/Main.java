package app.exito.utils;

import app.exito.driver.AppiumAndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = AppiumAndroidDriver.class.getClassLoader().getResourceAsStream("serenity.properties");
        properties.load(inputStream);
        UiAutomator2Options capabilities = new UiAutomator2Options();

        capabilities.setNoReset(true);
        capabilities.setPlatformName(properties.getProperty("platformName"));
        capabilities.setPlatformVersion(properties.getProperty("platformVersion"));
        capabilities.setDeviceName(properties.getProperty("deviceName"));
        capabilities.setUdid(properties.getProperty("udid"));
        capabilities.setAppPackage(properties.getProperty("appPackage"));
        capabilities.setAppActivity(properties.getProperty("appActivity"));
        capabilities.setApp("C:\\Users\\jarturot\\Documentos\\dafiti-moda-online\\dafiti-moda-online.apk");

        AndroidDriver driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
