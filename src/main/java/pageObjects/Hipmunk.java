package pageObjects;

import base.PageBase;
import base.TestBase;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utility.HighLight;

public class Hipmunk extends PageBase {

  public Hipmunk() {
    PageFactory.initElements(TestBase.getDriver(), this);
  }

  @FindBy(css = "[class='FlightSearchForm__roundtrip-container'] div input[placeholder='From: City or Airport']")
  WebElement from_textBox;

  @FindBy(css = "[class='FlightSearchForm__roundtrip-container'] div input[placeholder='To: City or Airport']")
  WebElement to_textBox;

  @FindBy(css = "[class='FlightSearchForm__roundtrip-container'] div input[placeholder='Depart']")
  WebElement depart_calendarTextBox;

  @FindBy(css = "[class='FlightSearchForm__roundtrip-container'] div input[placeholder='Return']")
  WebElement return_calendarTextBox;

  @FindBy(xpath = "(//button[@class='flat-button m-orange m-large FlightSearchForm__search'])[2]")
  WebElement searchBtn;

  public void fillOutFlightInformationTable()
      throws InterruptedException {
    driver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    from_textBox.sendKeys("DCA - Ronald Reagan Washington National Airport - Washington, DC");
    Thread.sleep(1000);
    to_textBox.sendKeys("LAX - Los Angeles International - Los Angeles, CA");
    Thread.sleep(1000);
    depart_calendarTextBox.sendKeys("Apr 01");
    return_calendarTextBox.sendKeys("Apr 05");
    searchBtn.click();
    WebElement result = driver()
        .findElement(By.className("flight-tab-results__header-and-chart-container"));
    waitForElement(result);
    int count = 0;
    try {
      while (count < 3) {
        new HighLight().highLight_Green(result);
        count++;
      }
      Thread.sleep(5000);
    } catch (Exception ignored) {
    }
  }

  public static void waitForElement(WebElement element) {
    Wait<WebDriver> wait = new FluentWait<>(TestBase.getDriver()).withTimeout(30L, TimeUnit.SECONDS)
        .pollingEvery(1000, TimeUnit.MILLISECONDS).ignoring
            (NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring
            (ElementNotVisibleException.class).ignoring(WebDriverException.class)
        .ignoring(Exception.class);
    wait.until(ExpectedConditions.visibilityOf(element));
  }
}
