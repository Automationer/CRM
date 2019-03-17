package step_definitions;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

import static junit.framework.TestCase.assertTrue;

public class Login_StepDef {

    static LoginPage loginPage;


    @Given("^User goes to CRM$")
    public void user_goes_to_CRM()  {
        loginPage = new LoginPage(TestBase.getDriver());
    }

    @Given("^User logs into CRM$")
    public void user_logs_into_CRM() throws Throwable {
        loginPage = new LoginPage(TestBase.getDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        Thread.sleep(2000);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isSuccessfullyLoggedIn());
        Thread.sleep(2000);
    }

    @When("^User enters valid credentials$")
    public void user_enters_valid_credentials() throws Throwable {
        loginPage.enterUsername();
        loginPage.enterPassword();
        Thread.sleep(2000);
        loginPage.clickLoginButton();
    }

    @Then("^User should successfully log into CRM$")
    public void user_should_successfully_log_into_CRM() throws Throwable {
        assertTrue(loginPage.isSuccessfullyLoggedIn());
    }


}
