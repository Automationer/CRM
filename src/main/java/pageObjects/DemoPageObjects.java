package pageObjects;

import base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ComponentClick;
import utility.ComponentTextBox;
import utility.HighLight;

import java.util.List;

public class DemoPageObjects extends PageBase {

    @FindBy(css = "div[id='navmenu'] ul.mlddm>li")
    List<WebElement> nav_tabs;

    @FindBy(css = "div[id='leftMenuContainer'] li")
    List<WebElement> left_menu_tabs;

    @FindBy(css = "[class='calendar_week']>tbody>tr>td")
    List<WebElement> weekdays;

    @FindBy(xpath = "//table[@class='crmcalendar']/tbody[1]")
    WebElement calendar;

    @FindBy(xpath = "//*[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr/td")
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
         String zoomInJS = "document.body.style.zoom='90%'";
         ((JavascriptExecutor) driver()).executeScript(zoomInJS);

        for (WebElement temp : nav_tabs) {
            highlight(temp, "yellow");
        }
    }

    public void highLight_AllLeftMenuLists() throws InterruptedException {
        for (WebElement temp : left_menu_tabs) {
            highlight(temp, "green");
        }
    }

    public void leftShouldMenuListsDisplayCorrectPages() throws InterruptedException {
        for (int i = 0; i < left_menu_tabs.size(); i++) {
            if (i == 0 || i == 1 || i == 2) {

            } else {
                componentClick.clickWithGreen(left_menu_tabs.get(i));
                Thread.sleep(2000);
            }
        }
    }


    public void highLight_weeks() throws InterruptedException {
        for (WebElement temp : weekdays) {
            highlight(temp, "red");
        }
    }

    public void highLight_calendar() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            highlight(calendar, "red");
            Thread.sleep(500);
        }
        highlight_slot();
    }

    private void highlight_slot() throws InterruptedException {

        for (WebElement temp : calendar_tr_td) {
            highlight(temp, "red");
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
        componentTextBox.enter(newDealElementsPage.getPrimaryContact_textBox(), "anyone");
        componentTextBox.enter(newDealElementsPage.getQuantity_textBox(), "50");
        componentClick.click(newDealElementsPage.getPredictedCloseDate_calendar());
        componentClick.click(newDealElementsPage.getActualCloseDate_calendar());
        componentTextBox.enter(newDealElementsPage.getDescription_textBox(), "Welcome to TekLab");
        componentTextBox.enter(newDealElementsPage.getNextStep_textBox(), "Start coding....");
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
            case "purple":
                new HighLight().highLight_Purple(element);
                break;
        }
    }

}
