package step_definitions.ContactsStepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.ContactsTestPages.ContactsPage;
import pageObjects.ContactsTestPages.NewContactsOptionPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewContact_StepDef {

    private ContactsPage contactsPage = new ContactsPage();
    private NewContactsOptionPage newContactsOptionPage = new NewContactsOptionPage();

    @Given("^User clicks on New Contact option$")
    public void user_clicks_on_New_Contact_option() throws Throwable {
        contactsPage.clickOnNewContactsOption();
    }

    @And("^User creates a new contact$")
    public void User_creates_a_new_contact() throws InterruptedException {
        newContactsOptionPage.fillOut_form();
    }

    @Then("^User should successfully create a new contact$")
    public void user_should_successfully_create_a_new_contact() {
        assertThat(newContactsOptionPage.isContactCreated()).isTrue();
    }

}
