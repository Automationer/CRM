package utility;

/*----------------------------------------------------------------*
 * This lcass contains run-time configurations for the test run.  *
 * Configuration item includes, email configurations such as      *
 * who is the sender, list of recipient of the email, and its     *
 * message header, and email message body.                        *
 *                                                                *
 * It also contains Database connectivity configurations that are * 
 * used on rum-time for connecting database and test.             *
 *----------------------------------------------------------------*/
public class TestConfig {
	// GMAIL is our mailing tool since using outlook is too complicated
	public static String server = "smtp.gmail.com";
	public static String from = "nijatmn@gmail.com"; // Sender email address
	public static String password = "Nijat12345!"; // Sender email password
	
	public static String[] to = {    /* list of people who will be getting email */ 
			"mubarek@gmail.com",
			"suryya@yahoo.com",
			"arafat@gmail.com"
	};  
																							
	public static String subject = "Automation Test Report";
	public static String messageBody = "Please see attached report.html for the automation test result reprot";
	public static String htmlAttachmentPath = System.getProperty("user.dir")  // report attachment
			+ "\\src\\test\\resources\\reports\\index.html";
	public static String htmlAttachmentName = "IBM-CUS-PROJ-4_AutomationReport.html";
}
