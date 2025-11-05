package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	WebDriver driver;
	public LoginPage (WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="input-email")
	WebElement emailinput;
	
	@FindBy(id="input-password")
	WebElement passwordinput;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	
	public void setemail(String email) {
		emailinput.sendKeys(email);
	}
	public void setpassword(String password) {
		passwordinput.sendKeys(password);
	}
	public void loginclickk() {
		loginbtn.click();
	}
}
