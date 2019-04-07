package pageObjects.ContactsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends PageBase {

    public ContactsPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "[title='Contacts']")
    WebElement contacts_Tab;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactOption;

    public void clickOnNewContactsOption() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver());
        actions.moveToElement(contacts_Tab)
                .moveToElement(newContactOption)
                .click().build().perform();
        Thread.sleep(2000);
    }

}
