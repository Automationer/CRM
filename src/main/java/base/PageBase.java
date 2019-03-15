package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.elements.AlertHandler;
import utility.elements.CommonElementOps;
import utility.elements.FindBy;
import utility.elements.JavascriptHelper;
import utility.elements.Waits;

// Base of every other page object classes, declared as an abstract class
// so it cannot be instantiated and no other object can be created. 
public abstract class PageBase {

	private static WebDriver driver;
	private WebDriverWait explicitWait;


  protected static JavascriptHelper jsHelper;
  protected Waits waiter;
  protected FindBy elemWith;
  protected AlertHandler alerts;
  protected CommonElementOps elemOps;

	public PageBase(WebDriver incomingDriver) {
		this.driver = incomingDriver;
		this.explicitWait = new WebDriverWait(driver, 50);
		this.jsHelper = new JavascriptHelper(driver);
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
			result = false;
		}
		return result;
	}


	protected WebDriver driver() {
		return this.driver;
	}

	protected WebDriverWait explicitWait() {
		return this.explicitWait;
	}

}
