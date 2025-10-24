package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en_scouse.An;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @And("on login page")
    public void loginPage() {
        loginPage.verifyLoginText();
    }

//    @And("fill credential")
//    public void fillCredential(String email, String password) {
//        loginPage.fillLoginForm(email, password);
//    }

    @And("fill credential")
    public void fillCredential(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : credentials) {
            String email = row.get("email");
            String password = row.get("password");

            System.out.println("🔹 Trying login with: " + email + " / " + password);
            loginPage.fillLoginForm(email, password);
        }
    }


}
