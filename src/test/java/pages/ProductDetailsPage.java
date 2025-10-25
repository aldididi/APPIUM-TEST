package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class ProductDetailsPage extends BasePage{
    private final By addToCartBtn2 = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]");
    private final By cartIcon =AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private final By cartIcon2 = AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Displays number of items in your cart\"]");

public void addToCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartBtn2));

    System.out.println(element.getAttribute("content-desc"));

    try {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 1.0
        ));
    } catch (Exception ignore) {
    }

    //use real tap
    ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", Map.of(
            "elementId", ((RemoteWebElement) element).getId()
    ));


    // wait cart icon visible
    wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon));
}

    public void shortWait() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void cartIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element;

        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon));
        } catch (Exception e) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon2));
        }
        try {
            // First try normal click
            element.click();
        } catch (Exception e) {
            // fallback to real tap gesture
            System.out.println("Normal click failed, retrying with mobile: clickGesture...");
            ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", Map.of(
                    "elementId", ((RemoteWebElement) element).getId()
            ));
        }
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.saucelabs.mydemoapp.android:id/checkoutBtn")),
                    ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Cart"))
            ));
        } catch (Exception e) {
            System.out.println("No new screen detected yet — might still be on same view.");
        }

    }
}

