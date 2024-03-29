package Framework.Tests;

import Framework.Pages.LoginPage;
import Framework.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;



public class LoginPageTest {
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    private WebDriver driver;
    private LoginPage loginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void testSetup(String browserName) throws InterruptedException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser Launch..");
            logger.info("Chrome Browser Launch");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser Launch..");
            logger.info("Firefox Browser Launch");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("Edge Browser Launch..");
            logger.info("Edge Browser Launch");
        } else {
            System.out.println("Unsupported Browser.Please use Chrome or Firefox or Edge");
        }

        driver.manage().window().maximize();

        PropertyReader propertyReader = new PropertyReader("src/test/java/Framework/config/test_config.properties");
        // Initialize LoginPage
        driver.get(propertyReader.getProperty("LoginPageUrl_Test"));
        logger.info("Login Page Open");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Test data
        String email = "mail123@gmail.com";
        String password = "123456";

        // Perform login
        loginPage.enterEmailAddress(email);
        logger.info("Typing Email");
        loginPage.enterPassword(password);
        logger.info("Typing Password");
        loginPage.clickLoginButton();
        logger.info("Click Login Button");
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        driver.quit();
        logger.info("Test Done.Browser Closed.");
    }
}
