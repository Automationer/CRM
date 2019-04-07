package pageObjects.ContactsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewContactsOptionPage extends PageBase {

    public NewContactsOptionPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "#first_name")
    WebElement firstNameTextBox;

    @FindBy(css = "#surname")
    WebElement lastNameTextBox;

    @FindBy(css = "input[value='Save']:nth-of-type(2)")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id='vSummary']/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[2]/span")
    List<WebElement> firstAndLastNames;

    public void fillOut_form() throws InterruptedException {
        firstNameTextBox.sendKeys("Jack");
        lastNameTextBox.sendKeys("Johnson");
        saveButton.click();
        Thread.sleep(2000);
    }

    public boolean isContactCreated() {
        String firstName = firstAndLastNames.get(0).getText();
        String lastName = firstAndLastNames.get(1).getText();
        return firstName.equals("Jack") && lastName.equals("Johnson");
    }


}
