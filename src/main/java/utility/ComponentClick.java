package utility;

import base.PageBase;
import org.openqa.selenium.WebElement;

public class ComponentClick extends PageBase {

    private boolean isHighLight = false;
    private int count =0;

    public ComponentClick(){

    }

    public void click(WebElement element) throws InterruptedException {
        if(isHighLight && count !=0){
            new Highlight(element, count);
            element.click();
        }

        element.click();
    }
}
