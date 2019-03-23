package utility;

import base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighLight extends PageBase {


  public HighLight(WebElement element, int count) {
    try {
      highLight(element, count);
    } catch (Exception e) {
      System.out.println("----ERROR---  Element is not highlighted");
    }
  }

  private void highLight(WebElement element, int count) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    for (int i = 0; i < count; i++) {
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
          "background: yellow; border: 2px solid red;");
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
      Thread.sleep(1000);
    }
  }
}
