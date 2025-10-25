package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory2 {

    public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static AppiumDriverLocalService serviceBuilder;

    public static void initDriver() throws MalformedURLException {
        if (driver.get() != null) return;
        System.out.println("[DriverFactory] Starting Appium Service");

        serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/Users/aldymochamadheryana/.nvm/versions/node/v20.19.5/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        serviceBuilder.start();

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(System.getProperty("user.dir") + "/src/test/resources/mda-1.0.13-15.apk")
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/"), options));

        System.out.println("[DriverFactory] Appium Started and App Launched ");
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        System.out.println("[DriverFactory] Stopping Appium Service");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
        if (serviceBuilder != null) {
            serviceBuilder.stop();
        }
    }
}
