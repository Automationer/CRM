package pageObjects.docsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewDocPage extends PageBase {

    @FindBy(css = "#title")
    WebElement title;

    @FindBy(css = "[name = 'description']")
    WebElement description;

    @FindBy(css = "#version")
    WebElement version;

    @FindBy(css = "[name ='file']")
    WebElement uploadFolder;

    @FindBy(xpath = "(//td/input[@class='select'])[2]")
    WebElement overwriteFileBtn;

    @FindBy(css = "(//td/select[@name='directory_id'])")
    WebElement folderDropDown;

    @FindBy(css = "[name = 'contact_lookup']")
    WebElement contact;

    @FindBy(css = "[name = 'client_lookup']")
    WebElement company;

    @FindBy(css = "[name = 'prospect_lookup']")
    WebElement prospect;

    @FindBy(css = "[name = 'task_lookup']")
    WebElement task;

    @FindBy(css = "[name = 'case_lookup']")
    WebElement cases;

    @FindBy(css = "#tags")
    WebElement tags;

    @FindBy(xpath = "//*[@id=\"docForm\"]/table/tbody/tr[14]/td[2]/input")
    WebElement saveBtn;

    public NewDocPage(){
        PageFactory.initElements(driver(), this);
    }

    public void enterTitle(String inputTitle){
        title.sendKeys(inputTitle);
    }

    public void enterDescription(String inoutDescription){
        description.sendKeys(inoutDescription);
    }

    public void enterVersion(String inoutVersion){
        version.sendKeys(inoutVersion);
    }

    public void selectFolder(String PathOfFolder){
        uploadFolder.sendKeys(PathOfFolder);
    }

    public void ClickOverwriteFileBtne(){
        overwriteFileBtn.click();
    }

    public void selectDropDownOption(int option) throws InterruptedException {
        Thread.sleep(3000);
        try {
            Select select = new Select(folderDropDown);
            select.selectByIndex(option);
        }catch(Exception e){
            System.out.println("error occur: couldn't select the 'Root Directory'");
        }
    }

    //String input[] = new String[6];
    public void enterRestOfTheCredentials( String input[]) throws InterruptedException {
        contact.sendKeys(input[0]);
        company.sendKeys(input[1]);
        prospect.sendKeys(input[2]);
        task.sendKeys(input[3]);
        cases.sendKeys(input[4]);
        tags.sendKeys(input[5]);
        Thread.sleep(2000);
    }

    public void clickSaveBtn() throws InterruptedException {
        saveBtn.click();
        Thread.sleep(2000);
    }
}
