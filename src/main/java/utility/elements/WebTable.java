package utility.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*---------------------------------------------------**
 * This utility class stores most commonly used 
 * operations that deals with the table element present
 * in the web site. Add and modify more as needed, use 
 * this inside of an page object class to represent a 
 * table. Initiate inside that page object class
 *--------------------------------------------------**/
public class WebTable {
	private WebElement webTable;

	// CONSTRUCTOR
	public WebTable(WebElement webTable) {
		this.webTable = webTable;
	}

	/**
	 * Returns the WebTable wrapper object
	 * 
	 * @return WebTable
	 */
	public WebElement getTable() {
		return webTable;
	}

	/**
	 * Returns the row count of the web table
	 * 
	 * @return number of rows in table
	 */
	public int getRowCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		return tableRows.size();
	}

	/**
	 * Returns the number of column in a row of a table
	 * 
	 * @return number of column in a row
	 */
	public int getColumnCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);

		List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
		return tableCols.size();
	}

	/**
	 * Gets the cell data of a table specified by its row index and column index
	 * 
	 * @param rowIdx
	 *            target row index
	 * @param colIdx
	 *            target column index
	 * @return gets the data in a specified cell with String format
	 */
	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	/**
	 * Returns the row specified by the index
	 * 
	 * @param index
	 * @return single row from a table
	 */
	public WebElement getRow(int index) {
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		return rows.get(index);
	}

}
