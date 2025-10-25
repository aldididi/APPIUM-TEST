package base;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before(order = 0)
    public void startAppium() throws Exception {
        DriverFactory2.initDriver();
    }

    @After(order = 0)
    public void stopAppium() {
        DriverFactory2.quitDriver();
    }
}
