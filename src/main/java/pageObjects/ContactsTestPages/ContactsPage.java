package pageObjects.ContactsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ComponentClick;

public class ContactsPage extends PageBase {

  public ContactsPage() {
    PageFactory.initElements(driver(), this);
  }

  private ComponentClick componentClick = new ComponentClick();

  @FindBy(css = "[title='Contacts']")
  private WebElement contacts_Tab;

  @FindBy(css = "a[title='New Contact']")
  private WebElement newContactOption;

  public void clickOnNewContactsOption() {
    componentClick.hoverOverThenClick(contacts_Tab, newContactOption);
  }

}
