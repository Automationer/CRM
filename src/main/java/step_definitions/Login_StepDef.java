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
    public void user_goes_to_CRM() {
        loginPage = new LoginPage(TestBase.getDriver());
    }

    @When("^User enters valid credentials$")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Then("^User should successfully log into CRM$")
    public void user_should_successfully_log_into_CRM() throws InterruptedException {
        assertTrue(loginPage.isSuccessfullyLoggedIn());
    }

}
