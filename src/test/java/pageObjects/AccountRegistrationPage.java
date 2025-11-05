package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;
	
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="input-firstname")
	WebElement name;
	
	@FindBy(id="input-lastname")
	WebElement lastname;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirm;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ckboxplicy;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement plycy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msg;
	
	public void setname(String nameinput) {
		name.sendKeys(nameinput);
	}
	public void setlastname(String lastnameinput) {
		lastname.sendKeys(lastnameinput);
	}
	public void setemail(String inputemail) {
		email.sendKeys(inputemail);
	}
	public void settelephony(String telepphonyinput) {
		telephone.sendKeys(telepphonyinput);
	}
	public void setpassword(String passwordinput) {
		password.sendKeys(passwordinput);
			}
	public void setconfirmpassword(String confirmpasswordinput) {
		confirm.sendKeys(confirmpasswordinput);
			}
	public void setpolicybtn() {
		ckboxplicy.click();
	}
	public void clickplycy() {
		plycy.click();
	}
	public void clickcontinuebtn() {
		continuebtn.click();
	}
//	public  String checkmsg() {
//	String actual_msg=msg.getText();
//	return actual_msg;
//	}
}
