package utility.elements;

import org.openqa.selenium.WebElement;

import java.util.List;

/*---------------------------------------------------**
 * This utility class stores most commonly used 
 * element operations. Add more if needed
 *--------------------------------------------------**/
public class CommonElementOps {

	/**
	 * Returns found element that contains the text denoted by element
	 * 
	 * @param elems
	 *            Element List
	 * @param value
	 *            Element with desired value
	 * @return null if element not found, otherwise found element
	 */
	public WebElement selectElementByValue(List<WebElement> elems, String value) {
		for (int i = 0; i < elems.size(); i++) {
			String actual = elems.get(i).getText();
			if (value.equalsIgnoreCase(actual)) {
				return elems.get(i);
			}
		}
		return null;
	}

	/**
	 * This method guarantees that given checkbox element is selected
	 * 
	 * @param checkBox
	 *            checkbox element that needs to be clicked
	 */
	public void clickCheckBox(WebElement checkBox) {
		if (checkBox.isSelected() == true) {
			// given check-box is already selected one
			return;
		} else if (checkBox.isSelected() == false) {
			checkBox.click();
			return;
		}
		return;
	}

	/**
	 * his method guarantees that given checkbox element is de-selected
	 * 
	 * @param elem
	 *            checkbox element that needs to be de-selected
	 */
	public void deselectCheckBox(WebElement elem) {
		if (elem.isSelected() == true) {
			// given check-box is already selected one
			elem.click();
			return;
		} else if (elem.isSelected() == false) {
			return;
		}
		return;
	}

	/**
	 * From given list of elements, clicks element that is specified by the values
	 * parameters. Note that you have to know that text values that will be used for
	 * the selection in advance
	 * 
	 * @param checkboxList
	 *            list of elements
	 * @param values
	 *            text values of desired elements to be clicked
	 */
	public void clickMultipleCheckboxWith(List<WebElement> checkboxList, String... values) {
		for (int i = 0; i < checkboxList.size(); i++) {
			for (int v = 0; v < values.length; v++) {
				String elemText = checkboxList.get(i).getText();
				String valueText = values[v];
				if (elemText.equalsIgnoreCase(valueText)) {
					checkboxList.get(i).click();
				}
			} // for:values
		} // for:elems
		return;
	}

}
