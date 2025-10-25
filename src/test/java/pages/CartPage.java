package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class CartPage extends BasePage {

    private final By colorLabel = AppiumBy.id("com.saucelabs.mydemoapp.android:id/colorIV");
    private final By productName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By addToCartBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By cartIcon = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private final By myCartText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");
    private final By proceedCheckout = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");

    public void verifyOnCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(myCartText));
        if(loginButton.isDisplayed()) {
            System.out.println("showing");
        } else {
            throw new AssertionError("myCartText is not displayed");
        }
    }

    public void verifyProductName(String expectedName) {
        String name = waitForVisibility(productName).getText();
        Assert.assertEquals(name, expectedName, "Sauce Lab Back Packs");
    }

    public void setProceedCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // check fresh element each time
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(proceedCheckout));
            System.out.println("Checkout button ready: " + element.getTagName());

            // Try click; retry once if DOM refreshes
            try {
                element.click();
            } catch (StaleElementReferenceException e) {

                element = driver.findElement(proceedCheckout);
                element.click();
            }

            // Give the new screen a sec to load
            Thread.sleep(800);

            // Wait for next page
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.saucelabs.mydemoapp.android:id/checkoutHeader")),
                    ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("checkoutTitle")),
                    ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[contains(@content-desc,'Checkout')]"))
            ));

            System.out.println("Checkout clicked — new screen loaded.");

        } catch (Exception e) {
            System.out.println("Failed to click checkout: " + e.getMessage());
        }
    }
}
