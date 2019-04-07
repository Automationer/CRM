package step_definitions.TasksStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.TasksTestPages.CreateNewTaskPage;
import pageObjects.TasksTestPages.Taskpage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateNewTask_StepDef {

    Taskpage taskPage = new Taskpage();
    CreateNewTaskPage createNewTaskPage = new CreateNewTaskPage();

    @When("^User clicks on New Tasks option$")
    public void user_clicks_on_New_Tasks_option() throws InterruptedException {
        taskPage.clickOnNewTaskOption();
    }

    @When("^User creates a new task$")
    public void user_creates_a_new_task() throws InterruptedException {
        createNewTaskPage.fillOut_form();
    }

    @Then("^User should successfully create a new task$")
    public void user_should_successfully_create_a_new_task(){
        createNewTaskPage.isTaskCreated();
        assertThat(createNewTaskPage.isTaskCreated()).isTrue();
    }

}
