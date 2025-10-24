package steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.CartPage;
import pages.SearchResultPage;

import java.time.Duration;

import static base.DriverFactory.driver;

public class CartSteps extends BasePage {
    SearchResultPage searchPage = new SearchResultPage();
    CartPage cartPage = new CartPage();


    @And("select gray color")
    public void selectGrayColor() {
        searchPage.selectGrayColor();
    }

    @And("scroll little bit")
    public void scrollLittleBit() {
       searchPage.scrollDown();
    }

    @And("set quantity to 3")
    public void setQuantity() {
        searchPage.increaseQty();
    }

    @And("click add to cart")
    public void clickAddToCart() {
        searchPage.addToCart();
    }
//    @And("verify cart is updated")
//    public void verifyCartIsUpdated() {
//        searchPage.checkCart();
//    }



//    @And("verify color is {string}")
//    public void verifyColor(String color) {
//        cartPage.verifyColor(color);
//    }


//    @And("verify product name Sauce Lab Back Packs")
//    public void verifyProductName(String name) {
//        cartPage.verifyProductName(name);
//    }
}
