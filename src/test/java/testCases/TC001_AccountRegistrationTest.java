package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = "sanity")
    public void verification() {
        logger.info("🟢 Starting Account Registration Test");

        try {
            HomePage hp = new HomePage(driver);

            // ✅ Replace Thread.sleep() with WebDriverWait in page classes — but keep short sleep for stability
            Thread.sleep(1000);
            hp.clickMyAccount();

            Thread.sleep(1000);
            hp.clickRegister();

            logger.info("🟢 Navigated to Registration Page");

            AccountRegistrationPage ar = new AccountRegistrationPage(driver);
            ar.setname(randomCharacter());
            ar.setlastname(randomCharacter());
            ar.setemail(randomEmail());
            ar.settelephony(randomNumber());   // ✅ changed to randomNumber() for phone number realism
            String pwd = randomPassword();
            ar.setpassword(pwd);
            ar.setconfirmpassword(pwd);
            ar.clickplycy();
            ar.clickcontinuebtn();

            logger.info("✅ Registration form submitted successfully.");

            // You can add validation for confirmation message here, e.g.:
            // String confirmMsg = ar.getConfirmationMsg();
            // Assert.assertTrue(confirmMsg.contains("Your Account Has Been Created!"), "Registration failed!");

        } catch (Exception e) {
            logger.error("❌ Test failed due to exception: " + e.getMessage(), e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("🔵 Account Registration Test Completed");
    }
}




















































//package testCases;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.fail;
//
//import java.time.Duration;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//
//import net.bytebuddy.utility.RandomString;
//import pageObjects.AccountRegistrationPage;
//import pageObjects.HomePage;
//
//
//
//public class TC001_AccountRegistrationTest extends BaseClass {
//
//	
//	@Test(groups="sanity")
//	public void verification() {
//		logger.info("started the homepage");
//		try {
//			
//		HomePage hp=new HomePage(driver);
//		Thread.sleep(2000);
//		hp.clickMyAccount();
//		Thread.sleep(2000);
//		hp.clickRegister();
//		Thread.sleep(2000);
//		logger.info("registration is also stratd");
//		AccountRegistrationPage ar= new AccountRegistrationPage(driver);
//		ar.setname(randomCharacter());
//		ar.setlastname(randomCharacter());
//		ar.setemail(randomEmail());
//		ar.settelephony(randomCharacter());
//		String pwd=randomPassword();
//		ar.setpassword(pwd);
//		ar.setconfirmpassword(pwd);
//		ar.clickplycy();
//		ar.clickcontinuebtn();
//		}
//		catch (Exception e) {
//	        logger.error("Test failed due to exception: " + e.getMessage());
//	        Assert.fail("Test failed due to exception: " + e.getMessage());  // ✅ marks test as failed
//	    }
//	}	
//}
