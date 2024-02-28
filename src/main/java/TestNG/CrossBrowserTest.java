package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    @Parameters("browserName")
    @BeforeMethod
    public void testSetup(String browserName) throws InterruptedException {
        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser Launch..");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser Launch..");
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("Edge Browser Launch..");
        }
        else {
            System.out.println("Unsupported Browser.Please use Chrome or Firefox or Edge");
        }

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Reporter.log("Webpage open..");
        Thread.sleep(3000);
    }

    @Test(dataProvider = "LoginValidDataProvider")
    public void testLogin(String Email, String Password) throws InterruptedException {
        WebElement EmailAddress = driver.findElement(By.cssSelector("input#input-email"));
        WebElement Password_field = driver.findElement(By.cssSelector("input#input-password"));
        WebElement LoginButton = driver.findElement(By.cssSelector("[action] .btn-primary"));

        EmailAddress.clear();
        EmailAddress.sendKeys(Email);

        Password_field.clear();
        Password_field.sendKeys(Password);

        LoginButton.click();

        Thread.sleep(4000);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "LoginValidDataProvider")
    public Object[][] loginDataValid(){
        return new Object[][]{
                {"mail123@gmail.com", "123456"},
                {"user_5924a1d5@gmail.com","fc57c192"}
        };
    }
    @DataProvider(name = "LoginInValidDataProvider")
    public Object[][] loginDataInvalid(){
        return new Object[][]{
                {"mail12311@gmail12.com", "11123456"}
        };
    }
}
