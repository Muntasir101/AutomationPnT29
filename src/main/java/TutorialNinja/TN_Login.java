package TutorialNinja;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TN_Login {
    public static void main(String[] args) throws InterruptedException {
        valid_login();
        invalid_login();
    }

    public static void valid_login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Thread.sleep(5000);

        WebElement EmailAddress = driver.findElement(By.cssSelector("input#input-email"));
        WebElement Password = driver.findElement(By.cssSelector("input#input-password"));
        WebElement LoginButton = driver.findElement(By.cssSelector("[action] .btn-primary"));

        EmailAddress.clear();
        EmailAddress.sendKeys("mail123@gmail.com");

        Password.clear();
        Password.sendKeys("123456");

        LoginButton.click();

        // verify login successful and dashboard open
        String expectedDashboardTitle = "My Account";
        String actualDashboardTitle = driver.getTitle();

        if(expectedDashboardTitle.equals(actualDashboardTitle)){
            System.out.println("Login Successful. Dashboard opened");
        }
        else{
            System.out.println("Login Failed.Buf found!!!");
        }

        driver.close();
    }

    public static void invalid_login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Thread.sleep(5000);

        WebElement EmailAddress = driver.findElement(By.cssSelector("input#input-email"));
        WebElement Password = driver.findElement(By.cssSelector("input#input-password"));
        WebElement LoginButton = driver.findElement(By.cssSelector("[action] .btn-primary"));

        EmailAddress.clear();
        EmailAddress.sendKeys("invalid@mail.com");

        Password.clear();
        Password.sendKeys("1111");

        LoginButton.click();

        String ExpectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
        String ActualErrorMessage = driver.findElement(By.cssSelector("div#account-login > .alert.alert-danger.alert-dismissible")).getText();

        // verify error message
        if(ExpectedErrorMessage.equals(ActualErrorMessage)){
            System.out.println("Error Message Exactly Shown.Test Passed.");

        }
        else{
            System.out.println("Error Message mismatch.Actual Error message : " + ActualErrorMessage);
        }

        driver.close();

    }

}
