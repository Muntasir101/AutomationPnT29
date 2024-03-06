package Framework.Tests;

import Framework.Pages.LoginPage;
import Framework.utils.PropertyReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LoginPageTest_DD {
    private static final Logger logger = LogManager.getLogger(LoginPageTest_DD.class);

    private WebDriver driver;
    private LoginPage loginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void testSetup(String browserName) throws InterruptedException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser Launch..");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser Launch..");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("Edge Browser Launch..");
        } else {
            System.out.println("Unsupported Browser.Please use Chrome or Firefox or Edge");
        }

        driver.manage().window().maximize();
        PropertyReader propertyReader = new PropertyReader("src/test/java/Framework/config/test_config.properties");
        // Initialize LoginPage
        driver.get(propertyReader.getProperty("LoginPageUrl_Test"));

        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "LoginDataProvider")
    public void testLogin(String Email_DD, String Password_DD) {

        // Perform login
        loginPage.enterEmailAddress(Email_DD);
        loginPage.enterPassword(Password_DD);
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        driver.quit();
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] loginDataValid() throws FileNotFoundException {
        String loginDataCsv = "src/test/java/Framework/data/login_data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(loginDataCsv))) {
            return reader.readAll().stream().skip(1) // skip header in CSV
                    .map(row -> new String[]{row[0], row[1]})
                    .toArray(Object[][]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
