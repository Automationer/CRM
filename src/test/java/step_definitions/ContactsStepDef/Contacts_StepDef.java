package step_definitions.ContactsStepDef;

import base.TestBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class Contacts_StepDef {

    private HomePage homePage = new HomePage();

    @When("^User clicks on Contacts tab$")
    public void user_clicks_on_Contacts_tab() {
        homePage.clickOn_ContactsTab();
    }

    @Then("^User should verify that the Contacts contents are displayed$")
    public void user_should_verify_that_the_Contacts_contents_are_displayed() {
        assertThat(homePage.isContactsContentDisplayed()).isTrue();
    }

}
