package pageObjects.TasksTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.ComponentClick;
import utility.ComponentTextBox;

public class NewTasksOptionPage extends PageBase {

  @FindBy(css = "#title")
  private WebElement titleTextBox;

  @FindBy(css = "[name='task_type']")
  private WebElement taskType_dropDown;

  @FindBy(css = "#taskForm > table > tbody > tr:nth-child(1) > td > input")
  private WebElement saveButton;

  @FindBy(xpath = "//*[@id='vSummary']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]")
  private WebElement createdTitleName;

  public NewTasksOptionPage() {
    PageFactory.initElements(driver(), this);
  }

  private ComponentClick componentClick = new ComponentClick();
  private ComponentTextBox componentTextBox = new ComponentTextBox();

  public void fillOut_form() throws InterruptedException {
    componentTextBox.enter(titleTextBox, "gulzire ");
    Select select = new Select(taskType_dropDown);
    select.selectByValue("Delivery");
    componentClick.click(saveButton);
    Thread.sleep(2000);
  }

  public boolean isTaskSuccessfullyCreated() {
    System.out.println("the tile coming from the webpage is: " + createdTitleName.getText());
    return createdTitleName.getText().equals("gulzire ");
  }

}
