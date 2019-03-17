package utility.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindBy {

	private WebDriver driver;

	// CONSTRUCTOR
	public FindBy(WebDriver inputDriver) {
		this.driver = inputDriver;
	}

	/**
	 * This will find element(s) using the ID attribute
	 * 
	 * @param using
	 *            element's id attribute value
	 * @return WebElement if found, null otherwise
	 */
	public WebElement id(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.id(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find element(s) using the XPath expression
	 * 
	 * @param using
	 *            xpath string or pattern
	 * @return WebElement if found, null otherwise
	 */
	public WebElement xpath(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.xpath(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find element(s) using the Name attribute
	 * 
	 * @param using
	 *            element's name attribute value
	 * @return WebElement if found, null otherwise
	 */
	public WebElement name(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.name(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find element(s) using the Class attribute value
	 * 
	 * @param using
	 *            element's class attribute value
	 * @return WebElement if found, null otherwise
	 */
	public WebElement className(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.className(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find element(s) using its HTML tag
	 * 
	 * @param using
	 *            elements tag name in string
	 * @return WebElement if found, null otherwise
	 */
	public WebElement tagname(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.tagName(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find link(s) using its text
	 * 
	 * @param using
	 *            elements link text
	 * @return WebElement if found, null otherwise
	 */
	public WebElement linkText(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.linkText(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find link(s) using the link's partial text
	 * 
	 * @param using
	 *            elements partial link text
	 * @return WebElement if found, null otherwise
	 */
	public WebElement partialLinkText(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.partialLinkText(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * This will find element(s) using the CSS selector
	 * 
	 * @param using
	 *            elements css pattern
	 * @return WebElement if found, null otherwise
	 */
	public WebElement css(String using) {
		WebElement elem;
		try {
			elem = driver.findElement(By.cssSelector(using));
			return elem;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Returns the element from the given list that contains the text specified by
	 * the targetText param
	 * 
	 * @param elems
	 *            list of element to be traversed
	 * @param targetText
	 *            target text
	 * @return
	 */
	public WebElement withText(List<WebElement> elems, String targetText) {
		for (int i = 0; i < elems.size(); i++) {
			if (elems.get(i).getText().trim().equalsIgnoreCase(targetText)) {
				return elems.get(i);
			}
		}
		return null;
	}

	/**
	 * Returns the child WebElements of given parent WebElemen as a list
	 * 
	 * @param parent
	 *            WebElement that contains subsequent Child elements
	 * @param locatorExpression
	 *            example: id=elementIDText, xpath=//ul/li[@name='list']
	 * @return child elements as a list of WebElements
	 */
	public List<WebElement> childsOf(WebElement parent, String locatorExpression) {
		List<WebElement> childs;
		String[] parts = locatorExpression.split("=");
		String locatorType = parts[0]; // locator type: id, xpath, tagName, linkText
		String value = parts[1]; // actual value of locators

		if (locatorType.equalsIgnoreCase("id"))
			childs = driver.findElements(By.id("value"));
		else if (locatorType.equalsIgnoreCase("xpath"))
			childs = driver.findElements(By.xpath("value"));
		else if (locatorType.equalsIgnoreCase("tagname"))
			childs = driver.findElements(By.tagName(value));
		else
			return null;

		// if we are here, we found the child element of the parent
		return childs;
	}
	
	/**
	 * Returns all the element with given ID attribute
	 * @param id value of id attribute of target elements
	 * @return list of elements 
	 */
	public List<WebElement> allWithId(String id){
		List<WebElement> elements = driver.findElements(By.id(id));
		return elements;
	}
	
	/**
	 * Returns all the element that satisfies the given Xpath pattern
	 * @param xpath 
	 * @return list of elements
	 */
	public List<WebElement> allWithXpath(String xpath){
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}
}


























