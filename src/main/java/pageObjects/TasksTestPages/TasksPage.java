package pageObjects.TasksTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends PageBase {

  @FindBy(css = "[title='Tasks']")
  private WebElement tasks_Tab;

  @FindBy(css = "a[title='New Task']")
  private WebElement newTaskOption;

  public TasksPage() {
    PageFactory.initElements(driver(), this);
  }


  @SuppressWarnings("Duplicates")
  public void clickOnNewTaskOption() throws InterruptedException {
    Thread.sleep(2000);
    Actions actions = new Actions(driver());
    actions.moveToElement(tasks_Tab)
        .moveToElement(newTaskOption)
        .click().build().perform();
    Thread.sleep(2000);
  }


}
