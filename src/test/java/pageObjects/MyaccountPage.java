package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {
	WebDriver driver;
	public MyaccountPage (WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//h2[contains(text(),'My Account')]")
WebElement myaccount;

public boolean ismyaccountexist() {
	try {
	return	(myaccount.isDisplayed());
	}
	catch(Exception e) {
		
	
	return false;
	}
}
}