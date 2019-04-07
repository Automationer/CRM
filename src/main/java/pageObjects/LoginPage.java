package pageObjects;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ComponentTextBox;

public class LoginPage extends PageBase {

  @FindBy(css = "[placeholder='Username']")
  WebElement usernameTextBox;

  @FindBy(css = "[placeholder='Password']")
  WebElement passwordTextBox;

  @FindBy(css = "[type='submit']")
  WebElement loginButton;

  ComponentTextBox textBox = new ComponentTextBox();

  public LoginPage(WebDriver incomingDriver, String websiteName) {
    super(incomingDriver);
    PageFactory.initElements(driver(), this);
    switch (websiteName) {
      case "crm":
        String crm_URL = "https://classic.crmpro.com/index.html";
        driver().get(crm_URL);
        driver().manage().window().fullscreen();
        break;
      case "hipmunk":
        String hiphunk_url = "https://www.hipmunk.com/flights";
        driver().get(hiphunk_url);
        driver().manage().window().fullscreen();
        break;
    }
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
