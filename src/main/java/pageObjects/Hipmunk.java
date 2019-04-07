package pageObjects;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.HighLight;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "(//div[@class='FlightRowLeftColumn__price'])")
    List<WebElement> prices;


    public void fillOutFlightInformationTable()
            throws InterruptedException {
       driver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     //   String zoomInJS = "document.body.style.zoom='90%'";
     //   ((JavascriptExecutor) driver()).executeScript(zoomInJS);
        from_textBox.sendKeys("DCA - Ronald Reagan Washington National Airport - Washington, DC");
        Thread.sleep(1000);
        to_textBox.sendKeys("LAX - Los Angeles International - Los Angeles, CA");
        Thread.sleep(1000);
        depart_calendarTextBox.sendKeys("Apr 01");
        return_calendarTextBox.sendKeys("Apr 05");
        searchBtn.click();
        new WebDriverWait(TestBase.getDriver(), 30L).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 3; i++) {
                new HighLight().highLight_Red(prices.get(0));
                Thread.sleep(1000);
            }
            System.out.println("--->>><><><>>>" + prices.get(0).getText());


        } catch (Exception ignored) {

        }
    }

}
