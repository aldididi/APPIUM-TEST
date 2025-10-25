package steps;
import io.cucumber.java.en.*;
import pages.BasePage;
import pages.CartBookingPage;
import pages.SearchResultPage;

public class CartBookingSteps extends BasePage {
    SearchResultPage searchPage = new SearchResultPage();
    CartBookingPage cartBookingPage = new CartBookingPage();

    @And("set quantity to 3")
    public void setQuantity() {
        searchPage.increaseQty();
    }


    @And("go to checkout page")
    public void goToCheckoutPage() {
        cartBookingPage.verifyOnCart();
    }

    @And("check product")
    public void checkColor() {
        cartBookingPage.verifyProductName("Sauce Lab Back Packs");
    }

    @And("click checkout")
    public void checkOut() {
        cartBookingPage.setProceedCheckout();
    }
    @And("verify on checkout page")
    public void verifyOnCheckoutPage() {
    cartBookingPage.verifyCheckout();
    }

    @And("fill data")
    public void fillData() {
        cartBookingPage.fillData();
    }

    @And("click payment")
    public void clickPayment() {
        cartBookingPage.scrollDown();
        cartBookingPage.clickPayment();
    }

    @And("verify on payment method")
    public void verifyOnPaymentMethod() {
        cartBookingPage.verifyOnPaymentMethod();
    }

    @And("fill payment data")
    public void fillPaymentData() {
    cartBookingPage.fillPaymentDat();
    }

    @And("click review order")
    public void clickReviewOrder() {
        cartBookingPage.clickReviewOrder();
    }
    @And("click place order")
    public void clickPlaceOrder() {
        cartBookingPage.scrollDhl();
        cartBookingPage.placeOrder();
    }

    @And("order complete")
    public void orderComplete() {
        cartBookingPage.verifyOrderComplete();
    }

    }


