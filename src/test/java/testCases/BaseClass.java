package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

    public  WebDriver driver;
    public Logger logger;
    public Properties p;

    // ✅ Parameters from TestNG XML
    @Parameters({ "os", "browser" })
    @BeforeClass(groups = { "sanity", "smoke" })
    public void setup(String os, String br) throws IOException, InterruptedException {

        // ✅ Load configuration file
        FileReader file = new FileReader("C://Users//Balaji//Documents//Bala_selenium_project//src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        logger.info("Execution started on OS: " + os + " | Browser: " + br);

        // ✅ Initialize browser
        switch (br.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Chrome browser launched");
                break;

            case "edge":
            	
            	
            	
            	    System.setProperty("webdriver.edge.driver", 
            	        "C:\\Users\\Balaji\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            	    driver = new EdgeDriver();
                        	
          
                logger.info("Edge browser launched");
                break;

            default:
                logger.error("Invalid browser name: " + br);
                throw new IllegalArgumentException("Unsupported browser: " + br);
        }

        // ✅ Configure driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("url"));
      
        
        logger.info("Navigated to URL: " + p.getProperty("url"));
        
    }

    // ✅ Random data generators
    public String randomCharacter() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(5);
    }

    public String randomEmail() {
        return RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(5) + "@gmail.com";
    }

    public String randomPassword() {
        return RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomNumeric(5);
    }

    // ✅ Screenshot capture utility
    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        logger.info("Screenshot captured: " + targetFilePath);
        return targetFilePath;
    }

    @AfterClass(groups = { "sanity", "smoke" })
    public void tearDown() {
       
          //  driver.quit();
            logger.info("Browser closed successfully.");
        
    }
}
