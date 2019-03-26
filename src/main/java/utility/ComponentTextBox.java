package utility;

import base.PageBase;
import org.openqa.selenium.WebElement;

public class ComponentTextBox extends PageBase {

  private boolean isHighLight_On = true;
  private int count = 4;

  public ComponentTextBox() {

  }

  public ComponentTextBox enterWithGreen(WebElement element, String input)
      throws InterruptedException {
    greenColor(element);
    element.sendKeys(input);
    return this;
  }

  public boolean enter(WebElement element, String input) {
    if (isHighLight_On && count != 0) {
      new HighLight(element, count);
      element.sendKeys(input);
    } else {
      element.sendKeys(input);
    }
    return !element.getText().isEmpty();
  }

  private void greenColor(WebElement element) throws InterruptedException {
    new HighLight().highLight_Green(element);
  }

}
