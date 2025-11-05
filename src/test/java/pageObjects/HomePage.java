package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	WebDriver driver;
	public HomePage (WebDriver driver) {
		super(driver);
		
	}
		

@FindBy(xpath="//span[contains(text(),'My Account')]")
WebElement myaccount;

@FindBy(xpath="//a[contains(text(),'Register')]")
WebElement register;

@FindBy(xpath="//a[contains(text(),'Login')]")
WebElement Login;


public void clickmyaccount() {
	myaccount.click();
	
}
public void clickRegister() {
	register.click();
	
}
public void clicklogin() {
	Login.click();
}

}
