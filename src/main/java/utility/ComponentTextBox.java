package utility;

import base.PageBase;
import org.openqa.selenium.WebElement;

public class ComponentTextBox extends PageBase {

  private boolean isHighLight_On = true;
  private int count = 4;

  public ComponentTextBox() {

  }

  public void enter(WebElement element, String input) {
    if (isHighLight_On && count != 0) {
      new HighLight(element, count);
      element.sendKeys(input);
    } else {
      element.sendKeys(input);
    }
  }


}
