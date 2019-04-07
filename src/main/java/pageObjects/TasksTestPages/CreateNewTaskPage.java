package pageObjects.TasksTestPages;

import base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.ComponentClick;
import utility.Highlight;

import java.util.List;

public class CreateNewTaskPage extends PageBase {

    public CreateNewTaskPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "#title")
    WebElement titleTextBox;

    @FindBy(css = "[name='task_type']")
    WebElement taskType_dropDown;

    @FindBy(css = "#taskForm > table > tbody > tr:nth-child(1) > td > input")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"vSummary\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]")
    WebElement createdTitleName;

    private ComponentClick click = new ComponentClick();

    public void fillOut_form() throws InterruptedException {
        new Highlight(titleTextBox, 3);
        titleTextBox.sendKeys("task4");
        Select select = new Select(taskType_dropDown);
        new Highlight(taskType_dropDown,5);
        select.selectByValue("Delivery");
        click.click(saveButton);
        //saveButton.click();
        Thread.sleep(2000);
    }

    public boolean isTaskCreated() {
        String titleName = createdTitleName.getText();
        System.out.println("the title name is: " + titleName);
        return titleName.equalsIgnoreCase("task4 ");
    }

   // private void highLight(WebDriver driver, WebElement element){
   //     JavascriptExecutor js = (JavascriptExecutor) driver;
   //     js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
   // }

}
