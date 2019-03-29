package pageObjects;

import base.PageBase;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utility.ComponentClick;
import utility.ComponentTextBox;
import utility.HighLight;

public class DemoPageObjects extends PageBase {

  @FindBy(css = "div[id='navmenu'] ul.mlddm>li")
  List<WebElement> nav_tabs;

  @FindBy(css = "div[id='leftMenuContainer'] li")
  List<WebElement> left_menu_tabs;

  @FindBy(css = "[class='calendar_week']>tbody>tr>td")
  List<WebElement> weekdays;

  @FindBy(css = "[class='crmcalendar'] tr")
  List<WebElement> calendar_tr;

  @FindBy(css = "td[align='Center'] tr>td")
  List<WebElement> calendar_tr_td;

  @FindBy(css = "a[title='New Deal']")
  WebElement new_Deal_Option;


  public DemoPageObjects() {
    PageFactory.initElements(driver(), this);
  }

  private ComponentClick componentClick = new ComponentClick();
  private ComponentTextBox componentTextBox = new ComponentTextBox();
  private NewDealElementsPage newDealElementsPage = new NewDealElementsPage();

  public void highLight_AllHeaderTabs() throws InterruptedException {
    for (WebElement temp : nav_tabs) {
      highlight(temp, "yellow");
    }
  }

  public void highLight_AllLeftMenuLists() throws InterruptedException {
    for (WebElement temp : left_menu_tabs) {
      highlight(temp, "green");
    }
  }

  public void highLight_weeks() throws InterruptedException {
    for (WebElement temp : weekdays) {
      highlight(temp, "red");
    }
  }

  public void highLight_calendar() throws InterruptedException {
    for (WebElement temp : calendar_tr) {
      highlight(temp, "liver");
    }
    for (WebElement temp : calendar_tr_td) {
      highlight(temp, "purple");
    }
  }

  public void hoverOverHeadNavTabs() throws InterruptedException {
    Actions actions = new Actions(driver());
    for (WebElement temp : nav_tabs) {
      highlight(temp, "red");
      actions.moveToElement(temp).build().perform();
      Thread.sleep(1000);
    }
  }

  public void createNewDeal() {
    componentClick.hoverOverThenClick(nav_tabs.get(4), new_Deal_Option);
  }

  public void fillOutForm() {
    componentTextBox.enter(newDealElementsPage.getTitle_textBox(), "new batch");
    componentTextBox.enter(newDealElementsPage.getCompany_textBox(), "TekLab");
    componentTextBox.enter(newDealElementsPage.getCompany_textBox(), "anyone");
    componentTextBox.enter(newDealElementsPage.getQuantity_textBox(), "50");
  }

  public void fillOutFlightInformationTable(String from, String to)
      throws InterruptedException {
    driver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver().findElement(By.cssSelector("button[data-lob='flight']")).click();
    Thread.sleep(1000);
    driver().findElement(By.cssSelector("#flight-origin-hp-flight")).sendKeys("DCA");
    Thread.sleep(1000);
    driver().findElement(
        By.cssSelector("[data-value='Washington, DC (DCA-Ronald Reagan Washington National)']"))
        .click();
    driver().findElement(By.cssSelector("#flight-destination-hp-flight"))
        .sendKeys("Los Angeles, California");
    driver().findElement(By.cssSelector("#flight-departing-hp-flight")).sendKeys("04/01/2019");
    driver().findElement(By.cssSelector("#flight-returning-hp-flight")).clear();
    Thread.sleep(1000);
    driver().findElement(By.xpath(
        "//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button")).click();
  }

  private void waitForElement(WebElement element) {
    Wait<WebDriver> wait = new FluentWait<>(driver()).withTimeout(30L, TimeUnit.SECONDS)
        .pollingEvery(500, TimeUnit.MILLISECONDS).ignoring
            (NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring
            (ElementNotVisibleException.class).ignoring(WebDriverException.class)
        .ignoring(Exception.class);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  private void highlight(WebElement element, String color) throws InterruptedException {
    switch (color) {
      case "green":
        new HighLight().highLight_Green(element);
        break;
      case "yellow":
        new HighLight().highLight_Yellow(element);
        break;
      case "red":
        new HighLight().highLight_Red(element);
        break;
      case "liver":
        for (int i = 0; i < 3; i++) {
          new HighLight().highLight_Liver(element);
        }
        break;
      case "purple":
        new HighLight().highLight_Purple(element);
        break;
    }
  }

}
