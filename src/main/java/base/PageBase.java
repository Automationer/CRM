package base;

import utility.elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Base of every other page object classes, declared as an abstract class
// so it cannot be instantiated and no other object can be created. 
public abstract class PageBase {

	private static WebDriver driver;
	private WebDriverWait explicitWait;

	// Utilities and Helpers are initialized here
	// any extending Page Object Class can use these
	protected static JavascriptHelper jsHelper; // all useful JavaScript executor method
	protected Waits waiter;        // all useful wait methods
	protected FindBy elemWith;     // all useful element finder method
	protected AlertHandler alerts;  // all useful alert box methods
	protected CommonElementOps elemOps; // all useful common element operations

	// Constructor - Initializations
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
