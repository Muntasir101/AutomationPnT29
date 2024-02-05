package SeleniumBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioAndCheckbox {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(5000);

        WebElement SubscribeYesButton = driver.findElement(By.cssSelector("label:nth-of-type(1) > input[name='newsletter']"));
        SubscribeYesButton.click();

        WebElement PrivacyPolicy = driver.findElement(By.cssSelector("input[name='agree']"));
        PrivacyPolicy.click();

    }
}
