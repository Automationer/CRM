import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = {"classpath:crm_features"},
        tags = "@ContactsFeature",
        dryRun = true)

public class cukesRunner {


}