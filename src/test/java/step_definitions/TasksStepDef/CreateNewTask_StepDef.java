package step_definitions.TasksStepDef;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.TasksTestPages.NewTasksOptionPage;
import pageObjects.TasksTestPages.TasksPage;

public class CreateNewTask_StepDef {

  TasksPage tasksPage = new TasksPage();
  NewTasksOptionPage newTasksOptionPage = new NewTasksOptionPage();

  @When("^User clicks on New Task option$")
  public void user_clicks_on_New_Task_option() throws InterruptedException {
    tasksPage.clickOnNewTaskOption();
  }

  @When("^User creates a new task$")
  public void user_creates_a_new_task() throws InterruptedException {
    newTasksOptionPage.fillOut_form();
  }

  @Then("^User should successfully create a new task$")
  public void user_should_successfully_create_a_new_task() {
    assertThat(newTasksOptionPage.isTaskSuccessfullyCreated()).isTrue();
  }

}
