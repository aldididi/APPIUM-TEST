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
    private final By fieldUsername = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By fieldPassword = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By btnLogin = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By errorLogin = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public void verifyLoginText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        if(loginButton.isDisplayed()) {
            System.out.println("showing");
        } else {
            throw new AssertionError("Login button is not displayed");
        }
    }

    public void fillCredential(){
        driver.findElement(fieldUsername).sendKeys("bod@example.com");
        driver.findElement(fieldPassword).sendKeys("10203040");
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }


}
