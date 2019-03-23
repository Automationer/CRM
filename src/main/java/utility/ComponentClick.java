package utility;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ComponentClick extends PageBase {

  private boolean isHighLight_On = true;
  private int count = 2;

  public ComponentClick() {

  }

  public void click(WebElement element) {
    if (isHighLight_On && count != 0) {
      new HighLight(element, count);
      element.click();
    } else {
      element.click();
    }
  }

  public void hoverOverThenClick(WebElement hoverElement, WebElement clickElement) {
    Actions actions = new Actions(driver());
    if (isHighLight_On && count != 0) {
      click(hoverElement);
    }
    actions.moveToElement(hoverElement)
        .moveToElement(clickElement)
        .click().build().perform();
  }


}
