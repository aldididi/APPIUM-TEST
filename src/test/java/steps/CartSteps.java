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



    @And("set quantity to 3")
    public void setQuantity() {
        searchPage.increaseQty();
    }


    @And("go to checkout page")
    public void goToCheckoutPage() {
        cartPage.verifyOnCart();
    }

    @And("check product")
    public void checkColor() {
        cartPage.verifyProductName("Sauce Lab Back Packs");
    }

    @And("click checkout")
    public void checkOut() {
        cartPage.setProceedCheckout();
    }

    }



//    @And("verify product name Sauce Lab Back Packs")
//    public void verifyProductName(String name) {
//        cartPage.verifyProductName(name);
//    }

