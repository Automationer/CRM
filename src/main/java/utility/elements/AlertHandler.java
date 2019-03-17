package utility.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHandler {
	private WebDriver driver;

	public AlertHandler(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Returns the alert object
	 * 
	 * @return Alert object
	 */
	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	/**
	 * Accepts the OK button that appears on the alert box
	 */
	public void AcceptAlert() {
		getAlert().accept();
	}

	/**
	 * Clicks the NO or negatiion button on the alert box
	 */
	public void DismissAlert() {
		getAlert().dismiss();
	}

	/**
	 * Gets the message that appears on Alert box
	 * 
	 * @return alert message
	 */
	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	/**
	 * Checks wheter alert is present of not
	 * 
	 * @return if switching context to Alert is successful, TRUE, otherwise FALSE
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * Checks if alert is present, if that is the case, it then proceeds to accept
	 * the alert box
	 */
	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
	}

	/**
	 * Checks if alert is present, if that is the case, it then proceeds to dismiss
	 * the alert box
	 */
	public void DismissAlertIfPresent() {
		if (!isAlertPresent())
			return;
		DismissAlert();
	}

	/**
	 * If the alert box is present, it will submits a Strings and accepts the alert
	 * box otherwise it does nothing
	 * 
	 * @param text
	 */
	public void AcceptPrompt(String text) {
		if (!isAlertPresent())
			return;
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}
}
