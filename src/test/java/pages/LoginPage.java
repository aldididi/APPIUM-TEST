package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage{
    private final By textLogin = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/loginTV");
    private final By fieldUsername = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/nameET");
    private final By fieldPassword = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By btnLogin = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By errorLogin = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public void verifyLoginText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(textLogin));

        String actualText = loginElement.getText();
        System.out.println("Found login text: " + actualText);

        Assert.assertEquals(actualText, "Login", actualText);
        System.out.println("Verified login text is 'Login'");
    }

//    public void fillLoginForm(String email, String password) {
////        driver.findElement(fieldUsername).sendKeys(email);
////        driver.findElement(fieldPassword).sendKeys(password);
////        String errorlogin = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV")).getText();
////        Assert.assertEquals(errorlogin, "Sorry this user has been locked out.");
//        driver.findElement(fieldUsername).clear();
//        driver.findElement(fieldPassword).clear();
//
//        driver.findElement(fieldUsername).sendKeys(email);
//        driver.findElement(fieldPassword).sendKeys(password);
//        driver.findElement(btnLogin).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        if (email.equalsIgnoreCase("bod@example.com") && password.equals("10203040")) {
//            // Expect an error message for locked-out user
//            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLogin));
//            String actualError = errorMsg.getText();
//            Assert.assertEquals("Error message mismatch!",
//                    "Sorry this user has been locked out.", actualError);
//            System.out.println("Verified locked user error message");
//        } else if (email.equalsIgnoreCase("alice@example.com") && password.equals("10203040")) {
//            // Expect successful login
//            // e.g., verify home screen or logout button visible
//            By homeScreen = AppiumBy.accessibilityId("Products screen");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreen));
//            System.out.println("Login successful for user: " + email);
//        } else {
//            throw new AssertionError("Unhandled credentials: " + email);
//        }
//    }

    public void fillLoginForm(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(fieldUsername).clear();
        driver.findElement(fieldUsername).sendKeys(email);
        driver.findElement(fieldPassword).clear();
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(btnLogin).click();

        // Logic: verify success or expected error
        if (email.equalsIgnoreCase("bod@example.com")) {
            String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLogin)).getText();
            Assert.assertEquals("Sorry this user has been locked out.", actualError);
            System.out.println("Locked out user verified: " + email);
        } else {
            // Example: check if successful login reached the product page
            By productsPage = AppiumBy.accessibilityId("products screen");
            wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage));
            System.out.println("Successful login: " + email);
        }
    }

}
