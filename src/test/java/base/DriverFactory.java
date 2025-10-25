package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class DriverFactory {

    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static AppiumDriverLocalService service;

    public static void initDriver() throws MalformedURLException {
        if (driver.get() != null) return;
        System.out.println("[DriverFactory] Starting Appium Service...");

        // === Load configs from environment variables or system properties ===
        String nodePath = System.getProperty("appium.node.path",
                System.getenv("APPIUM_NODE_PATH"));
        String ipAddress = System.getProperty("appium.ip", "127.0.0.1");
        int port = Integer.parseInt(System.getProperty("appium.port", "4723"));
        String deviceName = System.getProperty("device.name", "emulator-5554");
        String appPath = System.getProperty("app.path",
                System.getProperty("user.dir") + "/src/test/resources/mda-1.0.13-15.apk");

        // === Validate Node Path ===
        if (Objects.isNull(nodePath) || nodePath.isEmpty()) {
            throw new RuntimeException(
                    "❌ Appium Node path not set. Please set 'APPIUM_NODE_PATH' env variable or system property.");
        }

        // === Start Appium service dynamically ===
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(nodePath))
                .withIPAddress(ipAddress)
                .usingPort(port)
                .build();
        service.start();

        // === Configure Android options ===
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(deviceName)
                .setApp(appPath)
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        driver.set(new AndroidDriver(new URL("http://" + ipAddress + ":" + port + "/"), options));
        System.out.println("[DriverFactory] ✅ Appium Service started and App launched");
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        System.out.println("[DriverFactory] Stopping Appium Service...");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
        if (service != null) {
            service.stop();
        }
    }
}
