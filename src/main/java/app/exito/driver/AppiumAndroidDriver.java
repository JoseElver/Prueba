package app.exito.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class AppiumAndroidDriver {
    public static AppiumDriver driver;
        public static AppiumDriver initializeDriver() throws IOException {
            if (driver == null) {
                try {
                Properties properties = new Properties();
                InputStream inputStream = AppiumAndroidDriver.class.getClassLoader().getResourceAsStream("serenity.properties");
                properties.load(inputStream);

                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability("noReset", true);
                capabilities.setCapability("platformName", properties.getProperty("platformName"));
                capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
                capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
                capabilities.setCapability("udid", properties.getProperty("udid"));
                capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
                capabilities.setCapability("appActivity", properties.getProperty("appActivity"));

                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return driver;
        }

        public static void tearDown() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }

}


