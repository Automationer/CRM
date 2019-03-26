package pageObjects;

import base.PageBase;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ComponentClick;
import utility.ComponentTextBox;
import utility.HighLight;

public class LandingPage extends PageBase {

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

  public LandingPage() {
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

  public List<Boolean> fillOutForm() {
    ArrayList list = new ArrayList();
    list.add(componentTextBox.enter(newDealElementsPage.getTitle_textBox(), "new batch"));
    list.add(componentTextBox.enter(newDealElementsPage.getCompany_textBox(), "TekLab"));
    list.add(componentTextBox.enter(newDealElementsPage.getCompany_textBox(), "anyone"));
    list.add(componentTextBox.enter(newDealElementsPage.getQuantity_textBox(), "50"));
    // calendar
    return list;
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
