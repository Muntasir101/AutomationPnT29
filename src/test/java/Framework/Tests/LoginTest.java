package Framework.Tests;

import Framework.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

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
        loginPage = new LoginPage(driver);
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();
        Reporter.log("Webpage open..");
        Thread.sleep(3000);
    }
    @Test(dataProvider = "LoginValidDataProvider")
    public void testLogin(String Email, String Password) throws InterruptedException {
        loginPage.enterEmailAddress(Email);
        loginPage.enterPassword(Password);
        loginPage.clickLoginButton();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @DataProvider(name = "LoginValidDataProvider")
    public Object[][] loginDataValid(){
        return new Object[][]{
                {"mail123@gmail.com", "123456"}
        };
    }

}