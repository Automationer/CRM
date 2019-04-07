package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.elements.*;


public abstract class PageBase {

    private static WebDriver driver;
    private WebDriverWait explicitWait;


    private static JavascriptHelper jsHelper;
    public Waits waiter;
    private FindBy elemWith;
    private AlertHandler alerts;
    private CommonElementOps elemOps;

    // Constructor - Initializations
    public PageBase(WebDriver incomingDriver) {
        driver = incomingDriver;
        this.explicitWait = new WebDriverWait(driver, 50);
        jsHelper = new JavascriptHelper(driver);
        this.elemWith = new FindBy(driver);
        this.waiter = new Waits(driver);
        this.alerts = new AlertHandler(driver);
        this.elemOps = new CommonElementOps();
    }

    protected PageBase() {
    }

    protected boolean isDisplayed(String url) {
        boolean result = false;
        try {
            result = explicitWait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
        }
        return result;
    }


    protected WebDriver driver() {
        return driver;
    }

    protected WebDriverWait explicitWait() {
        return this.explicitWait;
    }

}
