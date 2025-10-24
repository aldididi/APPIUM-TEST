package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;

public class SearchResultPage extends BasePage {
    private final By grayColorBtn = AppiumBy.accessibilityId("Gray color");
    private final By addToCartBtn = AppiumBy.accessibilityId("Tap to add product to cart");
    private final By cartIcon = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private final By scrollLittle = AppiumBy.id("com.saucelabs.mydemoapp.android:id/addToCartLL");
    private final String addToCartResourceId = "com.saucelabs.mydemoapp.android:id/addToCartLL";
    private final By increaseQty = AppiumBy.accessibilityId(" Increase item quantity");
    private final By qty = AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV");

//    public SearchResultPage(AndroidDriver driver) {
//        super(driver);
//    }

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
        click(addToCartBtn);
    }

//    public void openCart() {
//        click(cartIcon);
//    }
}
