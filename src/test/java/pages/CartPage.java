package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage {

    private final By colorLabel = AppiumBy.id("com.saucelabs.mydemoapp.android:id/colorIV");
    private final By productName = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/titleTV");


    public void verifyColor(String expectedColor) {
        String color = waitForVisibility(colorLabel).getText();
        Assert.assertTrue(color.contains(expectedColor), "Color mismatch: " + color);
    }

    public void verifyProductName(String expectedName) {
        String name = waitForVisibility(productName).getText();
        Assert.assertEquals(name, expectedName, "Sauce Lab Back Packs");
    }
}
