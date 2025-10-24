package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage extends BasePage {
    private final By hamburgerBtn = AppiumBy.accessibilityId("View menu");
    private final By showLogin = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[12]");
    private final By grayColorBtn = AppiumBy.accessibilityId("Gray color");
    private final By addToCartBtn = AppiumBy.accessibilityId("Tap to add product to cart");
    private final By cartButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final String addToCartResourceId = "com.saucelabs.mydemoapp.android:id/addToCartLL";
    private final By increaseQty = AppiumBy.accessibilityId(" Increase item quantity");
    private final By qty = AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private final By cartBadge = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartTV");

//    public SearchResultPage(AndroidDriver driver) {
//        super(driver);
//    }


    public void hamburgerBtnClick() {
        click(hamburgerBtn);
    }
    public void loginBtnClick() {
        click(showLogin);
    }
    public void selectProduct(String productName) {
        scrollToDescription(productName);
        click(AppiumBy.accessibilityId(productName));
    }

    public void selectGrayColor() {
        click(grayColorBtn);
    }
    public void scrollDown(){
           scrollToElementById(addToCartResourceId);
    }



    public void increaseQty() {
        waitForVisibility(increaseQty);
        for (int i = 0; i < 3; i++) {
            click(qty);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public void addToCart() {
        click(cartButton);

    }
    public void checkCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

        if (badge.isDisplayed()) {
            System.out.println("Cart badge is visible on the screen");
        } else {
            throw new AssertionError(" Cart badge is NOT visible!");
        }
    }


}
