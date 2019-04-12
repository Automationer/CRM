package pageObjects.docsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingNewDocPage extends PageBase {

    @FindBy(xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td/strong")
    WebElement descriptionTag;

    public LandingNewDocPage(){
        PageFactory.initElements(driver(), this);
    }

    public boolean DocumentSavedSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String titleName = descriptionTag.getText();
        System.out.println("the title name is: " + titleName);
        return titleName.equalsIgnoreCase("Description");
    }
}
