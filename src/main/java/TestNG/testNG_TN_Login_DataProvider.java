package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNG_TN_Login_DataProvider {
    WebDriver driver;

    @BeforeMethod
    public void testSetup() throws InterruptedException {
        driver = new FirefoxDriver();
        Reporter.log("Browser Launch..");
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Reporter.log("Webpage open..");
        driver.manage().window().maximize();
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
