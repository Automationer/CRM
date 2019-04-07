package utility;

import base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighLight extends PageBase {


  HighLight(WebElement element, int count) {
    try {
      highLight(element, count);
    } catch (Exception e) {
      System.out.println("----ERROR---  Element is not highlighted");
    }
  }

  public HighLight() {

  }

  public void highLight_Yellow(WebElement element) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    js.executeScript(
        "arguments[0].setAttribute('style', 'background: #B2FF33; border: 2px solid red;');",
        element);
    Thread.sleep(1000);
  }

  public void highLight_Green(WebElement element) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    js.executeScript(
        "arguments[0].setAttribute('style', 'background: #ADFF2F; border: 2px solid black;');",
        element);
    Thread.sleep(500);
    js.executeScript(
        "arguments[0].setAttribute('style', '');",
        element);
  }

  public void highLight_Red(WebElement element) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    js.executeScript(
        "arguments[0].setAttribute('style', 'background: #FF334F; border: 3px solid red;');",
        element);
    Thread.sleep(500);
    js.executeScript(
        "arguments[0].setAttribute('style', '');",
        element);
  }

  public void highLight_Purple(WebElement element) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    js.executeScript(
        "arguments[0].setAttribute('style', 'background: purple; border: 3px solid purple;');",
        element);
    Thread.sleep(500);
    js.executeScript(
        "arguments[0].setAttribute('style', '');",
        element);
  }


  private void highLight(WebElement element, int count) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver();
    for (int i = 0; i < count; i++) {
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
          "background: purple; border: 2px solid red;");
      Thread.sleep(1000);
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

    }
  }

}
