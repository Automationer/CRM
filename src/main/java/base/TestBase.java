package base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utility.CreateDriver;

public class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUp() {
        driver = CreateDriver.startLocalBrowser("chrome");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
