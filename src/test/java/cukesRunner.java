import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
    "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extentReports/report.html"},
        features = {"classpath:crm_features"},
    tags = "@LoginTest",
    dryRun = false)

public class cukesRunner {


}