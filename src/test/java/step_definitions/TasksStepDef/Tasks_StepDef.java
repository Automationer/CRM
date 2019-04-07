package step_definitions.TasksStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class Tasks_StepDef {

    private HomePage homePage = new HomePage();

    @When("^User clicks on Tasks tab$")
    public void user_clicks_on_Tasks_tab() {
        homePage.clickOn_TasksTab();
    }

    @Then("^User should verify that the Tasks contents are displayed$")
    public void user_should_verify_that_the_Tasks_contents_are_displayed() {
        assertThat(homePage.isTasksContentDisplayed()).isTrue();
    }

}
