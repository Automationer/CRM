package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    private String crm_URL = "https://classic.crmpro.com/index.html";

    @FindBy(css = "[placeholder='Username']")
    WebElement usernameTextBox;

    @FindBy(css = "[placeholder='Password']")
    WebElement passwordTextBox;

    @FindBy(css = "[type='submit']")
    WebElement loginButton;


    public LoginPage(WebDriver incomingDriver) {
        super(incomingDriver);
        PageFactory.initElements(driver(), this);
        driver().get(crm_URL);
    }

    public void enterUsername() {
        usernameTextBox.sendKeys("ilzat_auto");
    }

    public void enterPassword() {
        passwordTextBox.sendKeys("Ilzat@94");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isSuccessfullyLoggedIn() throws InterruptedException {
        driver().switchTo().frame("mainpanel");
        Thread.sleep(2000);
        return driver().findElement(By.cssSelector("#navmenu")).isDisplayed();
    }


}
