package steps;
import io.cucumber.java.en.*;
import pages.SearchResultPage;

public class SearchResultSteps {
    //pages.SearchResultPage searchPage = new pages.SearchResultPage();
    SearchResultPage searchPage = new SearchResultPage();
    @Given("user on Search Result Product")
    public void userOnSearchResultProduct() throws InterruptedException {
        Thread.sleep(3000);

    }

    @And("select gray color")
    public void selectGrayColor() {
        searchPage.selectGrayColor();
    }

    @And("scroll little bit")
    public void scrollLittleBit() {
        searchPage.scrollDown();
    }

    @And("click hamburger")
    public void clickHamburger() {
        searchPage.hamburgerBtnClick();
    }
    @And("click login")
    public void clickLogin() {
        searchPage.loginBtnClick();
    }
    @And("Sauce Lab Back Packs")
    public void selectProduct() {
        searchPage.selectProduct("Sauce Lab Back Packs");
    }
}
