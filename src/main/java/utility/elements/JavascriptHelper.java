package utility.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class JavascriptHelper {
	private WebDriver driver;

	// CONSTRUCTOR
	public JavascriptHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Executes JavaScript statement given by the script parameter
	 * @param script JavaScript statements to be executed.
	 * @return Object
	 */
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	/**
	 * Executes JavaScripts with given arguments
	 * @param script JavaScript statement
	 * @param args List of arguments
	 * @return Object
	 */
	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	/**
	 * Scroll to specified element 
	 * @param element target element
	 */
	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	/**
	 * Scroll to specified element and performs CLICK operation
	 * @param element target element
	 */
	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}

	/**
	 * Scrolls to the element, so that it will be on viewable area
	 * @param element target element
	 */
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * Scrolls to the element, and it will be observable and performs click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}

	/**
	 * Scrolls down vertically
	 */
	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Scrolls up vertically
	 */
	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	/**
	 * Scrolls down the window by 1500 pixel
	 */
	public void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	/**
	 * Scrolls up the window by 1500 pixel
	 */
	public void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	/**
	 * Performs 40% zoom operation on body tag 
	 */
	public void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	/**
	 * zooms the body tag 
	 */
	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	/**v
	 * Highlights specific element, use this for showing the element when capturing the screenshot or the video
	 * or for the test execution demo
	 * @param element elements to be highlighted
	 */
	public void highlightElement(WebElement element) {
		for (int i = 0; i < 5; i++) {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid yellow;");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}
	
	/**
	 * Sets an attribute of an Element to the specified value at Run Time, use this when you want dynamically change the innerText of value 
	 * attribute of an element 
	 * @param element   target element
	 * @param attributeName  target attribute
	 * @param value  value of an attribute
	 */
	public void setAttribute(WebElement element, String attributeName, String value) {
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, attributeName, value);
	}

}