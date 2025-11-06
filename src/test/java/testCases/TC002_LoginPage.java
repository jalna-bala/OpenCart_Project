package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;

public class TC002_LoginPage extends BaseClass {

    @Test(groups = "smoke")
    public void verifications() {
        logger.info("🔹 Test case started: Login verification");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            logger.info("✅ Login page opened successfully");

            LoginPage lp = new LoginPage(driver);
            lp.setemail(p.getProperty("email"));
            lp.setpassword(p.getProperty("password"));
            lp.loginclickk();

            // ✅ Optional verification
          //  MyaccountPage macc = new MyaccountPage(driver);
          //  Assert.assertTrue(macc.isMyAccountExist(), "Login failed — My Account page not visible!");

            logger.info("✅ Test case passed: Login successful");

        } catch (Exception e) {
            logger.error("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}










































//package testCases;
//
//import static org.testng.Assert.fail;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pageObjects.BasePage;
//import pageObjects.HomePage;
//import pageObjects.LoginPage;
//
//public class TC002_LoginPage extends BaseClass {
//	@Test(groups="smoke")
//	public void verifications() {
//	    logger.info("Test case started");
//
//	    try {
//	        HomePage hp = new HomePage(driver);
//	        hp.clickmyaccount();
//	        hp.clicklogin();
//	        logger.info("Login page opened successfully");
//
//	        LoginPage lp = new LoginPage(driver);
//	        lp.setemail(p.getProperty("email"));      // wrong xpath should fail here
//	        lp.setpassword(p.getProperty("password"));
//	        lp.loginclickk();
//
//	        logger.info("Test case passed");
//
//	    } catch (Exception e) {
//	        logger.error("Test failed due to exception: " + e.getMessage());
//	        Assert.fail("Test failed due to exception: " + e.getMessage());  // ✅ marks test as failed
//	    }
//	}
//
//}