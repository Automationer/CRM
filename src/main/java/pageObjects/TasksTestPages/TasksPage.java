package pageObjects.TasksTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ComponentClick;

public class TasksPage extends PageBase {

  @FindBy(css = "[title='Tasks']")
  private WebElement tasks_Tab;

  @FindBy(css = "a[title='New Task']")
  private WebElement newTaskOption;

  public TasksPage() {
    PageFactory.initElements(driver(), this);
  }

  private ComponentClick componentClick = new ComponentClick();

  public void clickOnNewTaskOption() {
    componentClick.hoverOverThenClick(tasks_Tab, newTaskOption);
  }


}
