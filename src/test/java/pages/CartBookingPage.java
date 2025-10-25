package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartBookingPage extends BasePage {

    private final By colorLabel = AppiumBy.id("com.saucelabs.mydemoapp.android:id/colorIV");
    private final By productName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By addToCartBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By cartIcon = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private final By myCartText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");
    private final By proceedCheckout = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By shippingText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/enterShippingAddressTV");
    private final By fieldName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    private final By fieldNameCheckout = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By fieldAddress1 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET");
    private final By fieldAddress2 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET");
    private final By city = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET");
    private final By region = AppiumBy.id("com.saucelabs.mydemoapp.android:id/stateET");
    private final By zipCode = AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET");
    private final By country = AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET");
    private final String paymentButton = "com.saucelabs.mydemoapp.android:id/paymentCV";
    private final By paymentBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentCV");
    private final By paymentMethodTxt = AppiumBy.id("com.saucelabs.mydemoapp.android:id/enterPaymentMethodTV");
    private final By cardNumber = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    private final By expDate = AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    private final By CVV = AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
    private final By reviewOrder = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    private final By reviewOrder2 = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Saves payment info and launches screen to review checkout data\"]\n");
    private final By checkBox =AppiumBy.id("com.saucelabs.mydemoapp.android:id/billingAddressCB");
    private final By reviewOrderTxt = AppiumBy.id("com.saucelabs.mydemoapp.android:id/enterShippingAddressTV");
    private final String dhl ="com.saucelabs.mydemoapp.android:id/dhlTV";
    private final By dhlText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/dhlTV");
    private final By placeOrder = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    private final By complete = AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV");



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

    public void verifyCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(shippingText));
        if(loginButton.isDisplayed()) {
            System.out.println("showing");
        } else {
            throw new AssertionError("shipping text is not displayed");
        }
    }
    public void fillData(){
        driver.findElement(fieldName).sendKeys("jane foster");
        driver.findElement(fieldAddress1).sendKeys("kebun raya cbn");
        driver.findElement(fieldAddress2).sendKeys("bojong kulur 2");
        driver.findElement(city).sendKeys("jakarta barat");
        driver.findElement(region).sendKeys("jakarta");
        driver.findElement(zipCode).sendKeys("14100");
        driver.findElement(country).sendKeys("indonesia");
    }
    public void scrollDown(){
        scrollToElementById(paymentButton);
    }
    public void clickPayment(){
        driver.findElement(paymentBtn).click();
    }

    public void verifyOnPaymentMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodTxt));
        if(loginButton.isDisplayed()) {
            System.out.println("showing");
        } else {
            throw new AssertionError("shipping text is not displayed");
        }
    }

    public void fillPaymentDat() {
        driver.findElement(fieldNameCheckout).sendKeys("jane foster");
        driver.findElement(cardNumber).sendKeys("4242424242424242");
        driver.findElement(expDate).sendKeys("1228");
        driver.findElement(CVV).sendKeys("222");
    }
    public void clickReviewOrder(){
        driver.findElement(reviewOrder2).click();
    }
    public void scrollDhl(){
        scrollToElementById(dhl);
    }
    public void placeOrder(){
        driver.findElement(placeOrder).click();
    }

    public void verifyOrderComplete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(complete));
        if(loginButton.isDisplayed()) {
            System.out.println("showing");
        } else {
            throw new AssertionError("myCartText is not displayed");
        }
    }

}
