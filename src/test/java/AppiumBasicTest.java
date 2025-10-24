import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasicTest extends BaseTest {

    @Test
    public void testProductClick() throws InterruptedException {
        System.out.println("=== Test Started ===");

        // Wait for app to load
        Thread.sleep(3000);
        // Validate or log something
       // String productTitle = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/productTV")).getText();
      //  Assert.assertEquals(productTitle, "Products");
        //System.out.println("Clicked product: " + productTitle);

        // Example: click an element by accessibility ID
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Back Packs\"]\n")).click();



        Thread.sleep(5000);
        System.out.println("=== Test Finished ===");
    }
}
