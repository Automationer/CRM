package pageObjects;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    @FindBy(css = "[title='Contacts']")
    WebElement contacts_Tab;

    @FindBy(css = "[title='Tasks']")
    WebElement tasks_Tab;

    @FindBy(css = "form[name='CONTACTSEARCH']")
    WebElement contacts_SearchForm;

    @FindBy(css = "form[name='TASKSEARCH']")
    WebElement tasks_SearchForm;

    @FindBy(css = "[title = 'Docs']")
    WebElement docsTab;

    @FindBy(css = "[title = 'New Document']")
    WebElement NewDocumentOption;

    public HomePage() {
        PageFactory.initElements(driver(), this);
    }

    public void clickOn_ContactsTab() {
        contacts_Tab.click();
    }

    public boolean isContactsContentDisplayed() { return contacts_SearchForm.isDisplayed(); }

    public void clickOn_TasksTab() { tasks_Tab.click(); }

    public boolean isTasksContentDisplayed() { return tasks_SearchForm.isDisplayed();}

    public void clickOn_DocsTab(){
        docsTab.click();
    }

    public void clickOn_NewDocumentOption() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver());
        actions.moveToElement(docsTab)
                .moveToElement(NewDocumentOption)
                .click().build().perform();
        Thread.sleep(2000);
    }
}
