package utility.elements;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {
	
	private static WebDriver driver;

	public Waits(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Sets global timeout for the web driver 
	 * @param timeout in seconds by defualt
	 * @param unit    desired time unit, use TimeUnit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

	/**
	 * Waits till the element to be visible, checks if the element is visible yet or not in every half second
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitTillVisiblePolling(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// helper
	private WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	/**
	 * Wait till the element to be visible, after 40 seconds, if the element is still not visible
	 * it will throw an NoSuchElementException
	 * @param element
	 */
	public void waitTillVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Waits till the element to be invisible.
	 *
	 * @param element
	 */
	public void waitTillInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * Waits till the element is clickable of not, if the element is clickable, it will return the clickable element
	 * @param element
	 * @return
	 */
	public void waitTillClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Waits till the polling of page title is success or throws exception
	 * 
	 * @param expectedPageTitle
	 * @param timeInMiliSecond
	 * @throws Exception     
	 */
	public static void waitFor(String title) throws Exception {
		WebDriverWait exists = new WebDriverWait(driver, 60);
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(title)));
	}

	/**
	 * Waits till the polling of page URL is success or throws exception
	 * 
	 * @param url
	 */
	public static void waitForURL(String url ) throws Exception {
		WebDriverWait exists = new WebDriverWait(driver, 60);
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains(url)));
	}

	/**
	 * Waits till the polling of element specified by the By parameter is clickable.
	 *
	 * @param element
	 */
	public static void waitForClickable(WebElement element) throws Exception {
		WebDriverWait exists = new WebDriverWait(driver, 60);
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}
	
	/***
	 * This method used for dynamic element search
	 * 
	 * @param by
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;

		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return targetElem;
	}
	
	/**
	 * Waits as user command.
	 *
	 * @param element
	 */
	public void customWait(int inSeconds) {
		try {
			Thread.sleep(inSeconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
