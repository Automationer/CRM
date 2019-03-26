package pageObjects;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewDealElementsPage extends PageBase {


  @FindBy(css = "#title")
  WebElement title_textBox;

  @FindBy(css = "[name='client_lookup']")
  WebElement company_textBox;

  @FindBy(css = "[name='contact_lookup']")
  WebElement primaryContact_textBox;

  @FindBy(css = "[name='quantity']")
  WebElement quantity_textBox;

  @FindBy(css = "[name='description']")
  WebElement description_textBox;

  @FindBy(css = "[name='next_step']")
  WebElement nextStep_textBox;

  @FindBy(css = "[id='fieldId_close_date']+img")
  WebElement predictedCloseDate_calendar;

  @FindBy(css = "[id='fieldId_actual_close_date']+img")
  WebElement actualCloseDate_calendar;

  public NewDealElementsPage() {
    PageFactory.initElements(driver(), this);
  }

  public WebElement getTitle_textBox() {
    return title_textBox;
  }

  public WebElement getCompany_textBox() {
    return company_textBox;
  }

  public WebElement getPrimaryContact_textBox() {
    return primaryContact_textBox;
  }

  public WebElement getQuantity_textBox() {
    return quantity_textBox;
  }

  public WebElement getDescription_textBox() {
    return description_textBox;
  }

  public WebElement getNextStep_textBox() {
    return nextStep_textBox;
  }

  public WebElement getPredictedCloseDate_calendar() {
    return predictedCloseDate_calendar;
  }

  public WebElement getActualCloseDate_calendar() {
    return actualCloseDate_calendar;
  }

}
