package utility;

import base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight  extends PageBase {

    public Highlight(WebElement element, int count ) throws InterruptedException {
            try{
                highLight(element, count);
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println("Error occur");
            }

    }


    public void highLight(WebElement element, int count) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        for(int i=0; i<count; i++) {
            js.executeScript("arguments[0].setAttribute('style', arguments[1];", element, "'background: yellow; border: 2px solid red;'");
            js.executeScript("arguments[0].setAttribute('style', arguments[1];", element, "'background: yellow; border: 2px solid red;'");
            Thread.sleep(2000);
        }
    }
}
