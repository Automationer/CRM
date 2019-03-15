package base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utility.CreateDriver;

public class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUp() {
        driver = CreateDriver.startLocalBrowser("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {

      // take a screenshot if scenario fails
      if (scenario.isFailed()) {
        try {
          byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png");
          scenario.write("URL at failure: " + driver.getCurrentUrl());
        } catch (WebDriverException wde) {
          scenario.write("Embed Failed " + wde.getMessage());
        } catch (ClassCastException cce) {
          cce.printStackTrace();
        }
      }

        if (driver != null) {
          System.out.println(Serenity.getWebdriverManager().getCurrentDriver());
            driver.quit();
          Serenity.getWebdriverManager().closeDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
