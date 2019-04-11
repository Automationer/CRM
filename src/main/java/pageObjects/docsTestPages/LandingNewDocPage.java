package pageObjects.docsTestPages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingNewDocPage extends PageBase {

    @FindBy(xpath = "//td/a[contains(text(), ' Game document')]")
    WebElement assertPageTitle;

    public LandingNewDocPage(){
        PageFactory.initElements(driver(), this);
    }

    public boolean DocumentSavedSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String titleName = assertPageTitle.getText();
        System.out.println("the title name is: " + titleName);
        return titleName.equalsIgnoreCase(" Game document");
    }
}
