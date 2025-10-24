package steps;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.SearchResultPage;

public class CheckoutSteps {
    SearchResultPage searchPage = new SearchResultPage();
    CartPage cartPage = new CartPage();

    @Given("user on Search Result Product")
    public void userOnSearchResultProduct() throws InterruptedException {
        Thread.sleep(3000);
    }

    @And("Sauce Lab Back Packs")
    public void selectProduct() {
        searchPage.selectProduct("Sauce Lab Back Packs");
    }

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

//    @And("click cart icon")
//    public void clickCartIcon() {
//        searchPage.openCart();
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
