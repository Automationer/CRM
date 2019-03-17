package utility;

public class FileUtils {
	/**
	 * Returns the path String for the existing excel file.
	 * 
	 * @param excelName
	 *            existing excel file name without the .xlsx extension
	 * @return complete relative path of the excel file specified
	 */
	public static String getExcelPath(String excelName) {
		String xlname = excelName + ".xlsx";
		String filePath = "\\src\\test\\resources\\excels\\";
		String path = System.getProperty("user.dir") + filePath + xlname;
		return path;
	}

	/**
	 * Returns the path String for the existing log files.
	 * 
	 * @param logName
	 *            existing log file name without the .log extension
	 * @return complete relative path of the log file specified
	 */
	public static String getLogsPath(String logName) {
		String logfileName = logName + ".log";
		String filePath = "\\src\\test\\resources\\logs\\";
		String path = System.getProperty("user.dir") + filePath + logfileName;
		return path;
	}

	/**
	 * Returns the path String for the existing property files
	 * 
	 * @param propName
	 *            existing property file name without the .properties extension
	 * @return complete relative path of the properties file specified
	 */
	public static String getPropertiesPath(String propName) {
		String propFileName = propName + ".properties";
		String filePath = "\\src\\test\\resources\\configurations\\";
		String path = System.getProperty("user.dir") + filePath + propFileName;
		return path;
	}

	/**
	 * Returns the path String for the existing report file
	 * 
	 * @param reportFullName
	 *            existing report file with extention included
	 * @return complete relative path of the report file specified
	 */
	public static String getReportPath(String reportFullName) {
		String filePath = "\\src\\test\\resources\\reports\\" + reportFullName;
		String path = System.getProperty("user.dir") + filePath;
		return path;
	}

	/**
	 * Returns the path String for the existing web driver executables
	 * 
	 * @param driverName
	 *            existing executable file name without an .exe extension
	 * @return complete relative path of the driver file
	 */
	public static String getDriversPath(String driverName) {
		String filePath = "\\src\\test\\resources\\drivers_exe\\" + driverName + ".exe";
		String path = System.getProperty("user.dir") + filePath;
		return path;
	}

	/**
	 * Returns the Reports Configurations xml file full path, EXAMPLE: if you want
	 * to get the full path of ReportsConfig.xml file, just provide ReportsConfig
	 * 
	 * @param reportConfigXml
	 *            report config file, just the name part, xml is added automatically
	 * @return full path of the Reports Configuration file
	 */
	public static String getExtentConfigPath(String reportConfigFileName) {
		String filePath = "\\src\\test\\resources\\configurations\\" + reportConfigFileName + ".xml";
		String path = System.getProperty("user.dir") + filePath;
		return path;
	}
}
