package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.LinkedList;

public class Browser {
	/**
	 * Clicks the back arrow button of the browser
	 */
	public static void goBack(WebDriver driver) {
		driver.navigate().back();
	}

	/**
	 * Clicks the forward button of the browser
	 */
	public static void goForward(WebDriver driver) {
		driver.navigate().forward();
	}

	/**
	 * Refreshes the window
	 */
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * maximizes the window
	 */
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * Loads the specified URL in the current open window b
	 */
	public static void toUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	/**
	 * Gets the unique windows handles as HashSet
	 * 
	 * @return
	 */
	public static HashSet<String> getWindowHandlens(WebDriver driver) {
		return (HashSet<String>) driver.getWindowHandles();
	}

	/**
	 * Switches to any windows specified by the index
	 * 
	 * @param index
	 */
	public static void SwitchToWindow(WebDriver driver, int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens(driver));

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
	}

	/**
	 * Switches to the parent windows without closing the child window
	 */
	public static void switchToParentWindow(WebDriver driver) {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens(driver));
		driver.switchTo().window(windowsId.get(0));
	}

	/**
	 * Switches to the parent window and closes the child windows as it switches.
	 */
	public static void switchToParentWithChildClose(WebDriver driver) {
		switchToParentWindow(driver);
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens(driver));
		for (int i = 1; i < windowsId.size(); i++) {
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow(driver);
	}

	/**
	 * Switches to the frame identified by the WebElemnet parameter frame.
	 * 
	 * @param frame
	 */
	public static void switchToFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().frame(frame);
	}

	/**
	 * Switches to the the frame identified by the name parameter
	 * 
	 * @param name
	 */
	public static void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * Switches to the the frame identified by the id parameter
	 * 
	 * @param iFrameNum
	 */
	public static void switchToFrame(WebDriver driver, int iFrameNum) {
		driver.switchTo().frame(iFrameNum);
	}

	/**
	 * Switches to the the frame back to the main frame
	 * 
	 * @param iFrameNum
	 */
	public static void switchBackToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
}
