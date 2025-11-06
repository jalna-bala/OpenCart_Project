package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login;

    // ✅ Jenkins-safe click using JS + Wait
    public void clickmyaccount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(myaccount));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", myaccount);
            System.out.println("✅ Clicked on My Account successfully.");

        } catch (Exception e) {
            System.err.println("❌ Failed to click on My Account: " + e.getMessage());
        }
    }

    public void clickRegister() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(register));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", register);
            System.out.println("✅ Clicked on Register successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to click on Register: " + e.getMessage());
        }
    }

    public void clicklogin() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(login));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", login);
            System.out.println("✅ Clicked on Login successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to click on Login: " + e.getMessage());
        }
    }
}











































//package pageObjects;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HomePage extends BasePage {
//
//	WebDriver driver;
//	public HomePage (WebDriver driver) {
//		super(driver);
//		
//	}
//		
//
//@FindBy(xpath="//span[text()='My Account']")
//WebElement myaccount;
//
//
//
//
//
//@FindBy(xpath="//a[contains(text(),'Register')]")
//WebElement register;
//
//@FindBy(xpath="//a[contains(text(),'Login')]")
//WebElement Login;
//
//
//public void clickmyaccount() {
//	
//	
//	myaccount.click();
//	
//}
//public void clickRegister() {
//	register.click();
//	
//}
//public void clicklogin() {
//	Login.click();
//}
//
//}
