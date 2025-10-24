import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void AppiumConfiguration() throws MalformedURLException {
        System.out.println("=== Starting Appium Service ===");

        serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/Users/aldymochamadheryana/.nvm/versions/node/v20.19.5/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        serviceBuilder.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/mda-1.0.13-15.apk");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        System.out.println("=== Appium Started and App Launched ===");
    }

    @AfterClass
    public void Closing() {
        System.out.println("=== Stopping Appium Service ===");
        if (driver != null) driver.quit();
        if (serviceBuilder != null) serviceBuilder.stop();
    }
}
