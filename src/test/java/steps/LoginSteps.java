package steps;

import io.cucumber.java.en.And;
import pages.LoginPage;
public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @And("on login page")
    public void loginPage() {
        loginPage.verifyLoginText();
    }

    @And("fill credential")
    public void fillCredential() {
        loginPage.fillCredential();
    }

    @And("login")
    public void clickBtnLogin() {
        loginPage.clickLogin();
    }

}
