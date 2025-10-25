package steps;

import io.cucumber.java.en.And;
import pages.BasePage;
import pages.ProductDetailsPage;


public class ProductDetailsSteps extends BasePage {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @And("click add to cart")
    public void clickAddToCart() {
        productDetailsPage.addToCart();
    }

    @And("click cart icon")
    public void clickCartIcon() {
        productDetailsPage.shortWait();
        productDetailsPage.cartIcon();
    }
}
