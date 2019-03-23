package pageObjects;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

  @FindBy(css = "[title='Contacts']")
  WebElement contacts_Tab;

  @FindBy(css = "[title='Tasks']")
  WebElement tasks_Tab;

  @FindBy(css = "form[name='CONTACTSEARCH']")
  WebElement contacts_SearchForm;

  @FindBy(css = "[name='TASKSEARCH']")
  WebElement tasks_SearchForm;

  public HomePage() {
    PageFactory.initElements(driver(), this);
  }

  public void clickOn_ContactsTab() {
    contacts_Tab.click();
  }

  public boolean isContactsContentDisplayed() {
    return contacts_SearchForm.isDisplayed();
  }

  public void clickOn_TasksTab() { tasks_Tab.click();}

  public boolean isTasksContentDisplayed() {
    return tasks_SearchForm.isDisplayed();
  }
}
